package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class elementCommands {

	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		String title = driver.getTitle();
		
		// if we have to perform multiple actions with one element 
		//We need to create a WebElement to store driver.findElement  
		WebElement ageRadioBtn = driver.findElement(By.xpath("//input[@value = '0 - 5']"));
		boolean isEnbaled = ageRadioBtn.isEnabled();
		boolean isDisplayed = ageRadioBtn.isDisplayed();
		System.out.println(isEnbaled);
		System.out.println(isDisplayed);

		System.out.println("Before clicking " + ageRadioBtn.isSelected());
		ageRadioBtn.click();
		Thread.sleep(2000);
		System.out.println("After clicking " + ageRadioBtn.isSelected());

	}

}
