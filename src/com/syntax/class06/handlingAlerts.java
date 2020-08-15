package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingAlerts {

	public static String url = "http://uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement simpleButton = driver.findElement(By.id("alert"));
		simpleButton.click();

		Alert alert = driver.switchTo().alert(); // switching to alert
		Thread.sleep(3000);
		alert.accept();

		WebElement confirmationAlertButton = driver.findElement(By.id("confirm"));
		confirmationAlertButton.click();
		Thread.sleep(3000);
		String confirmALertText = alert.getText();
		System.out.println(confirmALertText);
		// handling confirmation alert
		alert.dismiss();

		WebElement promptAlertButton = driver.findElement(By.id("prompt"));
		promptAlertButton.click();
		Thread.sleep(3000);

		alert.sendKeys("Syntax");
		Thread.sleep(3000);
		alert.accept();

	}
}
