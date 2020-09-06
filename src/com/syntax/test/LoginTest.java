package com.syntax.test;

import com.syntax.Utils.BaseClass;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithFindBy;
import com.syntax.pages.LoginPage;

public class LoginTest {

	public static void main(String[] args) {
		BaseClass.setUp();
		LoginPage loginPage = new LoginPage(); // creating login page class obj and call elements 
		
		loginPage.username.sendKeys("Admin");
		loginPage.password.sendKeys("Hum@nhrm123");
		loginPage.loginButton.click();
		
		BaseClass.tearDown();

	}

}
