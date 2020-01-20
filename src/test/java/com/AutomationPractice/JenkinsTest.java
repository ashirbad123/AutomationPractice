package com.AutomationPractice;

import org.testng.annotations.Test;

public class JenkinsTest {

	@Test
	public void loginTest() {
		System.out.println("Username from jenkins is"+System.getProperty("username"));
		System.out.println("Password from jenkins is"+ System.getProperty("password"));
		System.out.println("url from jenkins is "+ System.getProperty("url"));
		
	}
}
