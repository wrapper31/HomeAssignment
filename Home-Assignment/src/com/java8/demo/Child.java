package com.java8.demo;

public class Child extends Parent {
	
	Parent parent;
	
	

	public Child(Parent parent) {
		super();
		this.parent = parent;
	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return this.parent.sayHello() + ", Child is Called";
	}
	
	
	
	public static void main(String[] args) {
		
		Child child = new Child(new Parent());
		System.out.print(child.sayHello());
		System.out.println();
		
		Integer integer = new Integer(5);
		Integer int2 = Integer.valueOf(5);
		
		
		
	}
}
