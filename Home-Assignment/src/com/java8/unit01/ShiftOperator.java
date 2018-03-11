package com.java8.unit01;

public class ShiftOperator {
	//multiply 10 by 2 power n where n = 6
    private static final int  MULTIPLY = 10 << 6 << 9;
    
    //Divide 640 by  2 power n where n = 6.
    private static final int  DIVIDE = 640 >> 6;
    
    public static void main(String[ ] args) {
         System.out.println(MULTIPLY);               // 640
         System.out.println(DIVIDE);                 // 10
    }
}
