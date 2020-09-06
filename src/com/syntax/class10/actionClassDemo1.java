package com.syntax.class10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClassDemo1 {



	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();

		WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));
		
		Actions action = new Actions(driver);// needs action class to move mouse, drag and drop double click etc;
		action.moveToElement(accountsAndLists).perform();

	}
}
