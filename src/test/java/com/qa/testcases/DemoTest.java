package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {

	// trying git from command line
	
	@Test
	public void sum() {
		System.out.println("sum test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(30, a+b);
	}
	
	@Test
	public void substract() {
		System.out.println("substract test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(10, b-a);
	}
	
	@Test
	public void division() {
		System.out.println("division test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(2, b/a);
	}
	
	@Test
	public void multiplication() {
		System.out.println("multiplication test");
		int a = 10;
		int b = 20;
		Assert.assertEquals(200, a*b);
	}
	
}

