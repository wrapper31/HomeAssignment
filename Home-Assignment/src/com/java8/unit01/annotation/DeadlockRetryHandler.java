package com.java8.unit01.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DeadlockRetryHandler implements InvocationHandler
{   
    private Object target;
     
    public DeadlockRetryHandler(Object target)
    {
        this.target = target;
    }
     
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Annotation[] annotations = method.getAnnotations();
        DeadlockRetry deadlockRetry = (DeadlockRetry) annotations[0];
         
        final Integer maxTries = deadlockRetry.maxTries();
        long tryIntervalMillis = deadlockRetry.tryIntervalMillis();
         
        int count = 0;
         
        do
        {
            try
            {
                count++;
                Object result = method.invoke(target, args);    // retry
                return result;
            }
            catch (Throwable e)
            {
                if (!DeadlockUtil.isDeadLock(e))
                {
                    throw new RuntimeException(e);
                }
                 
                if (tryIntervalMillis > 0)
                {
                    try
                    {
                        Thread.sleep(tryIntervalMillis);
                    }
                    catch (InterruptedException ie)
                    {
                        System.out.println("Deadlock retry thread interrupted" + ie);
                    }
                }
            }
        }
        while (count <= maxTries);
         
        //gets here only when all attempts have failed
        throw new RuntimeException("DeadlockRetryMethodInterceptor failed to successfully execute target "
                + " due to deadlock in all retry attempts",
                new DeadlockDataAccessException("Created by DeadlockRetryMethodInterceptor", null));
    }   
}

