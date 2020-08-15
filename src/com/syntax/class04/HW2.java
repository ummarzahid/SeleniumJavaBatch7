package com.syntax.class04;

import java.security.spec.PSSParameterSpec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {

	/*
	 * HRMS Application Negative Login: Open chrome browser Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login” Enter
	 * valid username Leave password field empty Verify error message with text
	 * “Password cannot be empty” is displayed.
	 */

	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement enterUserName = driver.findElement(By.id("txtUsername"));
		enterUserName.sendKeys("Admin");

		Thread.sleep(1000);

		WebElement clickLogin = driver.findElement(By.id("btnLogin"));
		clickLogin.click();
		
		WebElement passwordEmpty = driver.findElement(By.id("spanMessage"));
		if(passwordEmpty.isDisplayed()) {
			String result = passwordEmpty.getText();
			if(result.equals("Password cannot be empty")) {
				System.out.println("Leave password field empty test passed ");
			}else {
				System.out.println("Test failed");
			}
		}

	}
}
