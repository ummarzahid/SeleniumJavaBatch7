package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ammar/eclipse-workspace/SeleniumJavaBatch7/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https:www.amazon.com");	
		
	}

}
