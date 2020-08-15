package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWAlert {

	public static String url = "http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement alertBox = driver.findElement(By.xpath("//button[@onclick = 'myAlertFunction()']"));
		alertBox.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		WebElement confirmAlert = driver.findElement(By.xpath("//button[@onclick = 'myConfirmFunction()']"));
		confirmAlert.click();
		Thread.sleep(2000);
		alert.dismiss();
		
		WebElement promptAlert = driver.findElement(By.xpath("//button[@onclick = 'myPromptFunction()']"));
		promptAlert.click();
		Thread.sleep(2000);
		alert.sendKeys("Syntax");
		alert.accept();

	}
}
