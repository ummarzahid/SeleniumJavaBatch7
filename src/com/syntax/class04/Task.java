package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement UserName = driver.findElement(By.id("txtUsername"));
		UserName.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Hum@nhrm123");
		
		WebElement LoginButton = driver.findElement(By.id("btnLogin"));
		LoginButton.click();
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt = 'OrangeHRM']"));
		if(logo.isDisplayed()) {
			System.out.println("Logo is Displayed");
		}else {
			System.out.println("Logo is not displayed");
		}
		

	}

}
