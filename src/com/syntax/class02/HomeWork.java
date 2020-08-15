package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		driver.manage().window().maximize();

		driver.findElement(By.id("customer.firstName")).sendKeys("Angelina");
		driver.findElement(By.id("customer.lastName")).sendKeys("Jolie");
		driver.findElement(By.name("customer.address.street")).sendKeys("1234 Bradpitt Rd");
		driver.findElement(By.id("customer.address.city")).sendKeys("Los Angeles");
		driver.findElement(By.name("customer.address.state")).sendKeys("California");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("007");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("123 911 4567");
		driver.findElement(By.id("customer.ssn")).sendKeys("987-34-1122");

		driver.findElement(By.id("customer.username")).sendKeys("Brangelina");
		driver.findElement(By.id("customer.password")).sendKeys("pittJolie");
		driver.findElement(By.id("repeatedPassword")).sendKeys("pittJolie");
		Thread.sleep(3000);
		
		driver.findElement(By.className("button")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
