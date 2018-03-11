package com.java8.demo;

public class StringManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("Hello"));
		//System.out.println(new StringBuilder("Hello World").reverse( ).toString( ));
	}

	
	public static String reverse(String input) {
		
		if(input==null || input.length()==0) {
			return input;
		}
		//System.out.println(input.substring(1));
		System.out.println(input.substring(1)+input.charAt(0));
		return reverse(input.substring(1))+input.charAt(0);
	}
}
