package com.connect;


final class Connect {
	int a;
	int b;
	int c;
	
	
	public void sum(int a, int b) {
		this.a = a;
		this.b = b;
		c=a+b;
	}
	public void display() {
		System.out.println(a+"+"+b+"="+c);
	}
}
