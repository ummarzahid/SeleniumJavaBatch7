package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.className("button")).click();

		String actualtitle = driver.getTitle();
		String expectedtitle = "Web Orders";
		if (actualtitle.equalsIgnoreCase(expectedtitle)) {
			System.out.println("This is a right title");
		} else {
			System.out.println("This is a Wrong Title");
		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();

	}

}
