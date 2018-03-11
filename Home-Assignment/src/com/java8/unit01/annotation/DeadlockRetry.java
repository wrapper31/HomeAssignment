/**
 * 
 */
package com.java8.unit01.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
/**
 * @author ajitrai
 *
 */
public @interface DeadlockRetry {
	int maxTries() default 10;
    int tryIntervalMillis() default 1000;
}
