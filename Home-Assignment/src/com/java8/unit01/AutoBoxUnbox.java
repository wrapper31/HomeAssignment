package com.java8.unit01;

public class AutoBoxUnbox {

    public static void main(String[] args) throws InterruptedException {
        Long value = 0L;
        new AutoBoxUnbox().eval(value);
    }

    void eval(long val) {
        System.out.println(1);
    }

     void eval(Long value) {
        System.out.println(2);
    }
} 