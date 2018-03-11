package com.java8.unit01;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//packing
        int val = ((((25 << 1) | 1) << 8) | 255);
        System.out.println("packed=" + val);
        System.out.println("packed binary=" 
                               + Integer.toBinaryString(val));         //0011001111111111
        
        //unpacking
        System.out.println("height=" + (val & 0xff));             //extract last 8 bits.
        System.out.println("gender=" + ((val >>> 8) & 1));  //extract bit 9
        System.out.println("age=" + ((val >>> 9)));              //extract bits 10 – 16.

	}

}
