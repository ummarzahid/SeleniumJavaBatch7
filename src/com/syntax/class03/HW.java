package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(@id, 'btn_basic_example')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id = 'btn_inter_example']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'Validations')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name*= 'first']")).sendKeys("Ummar");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name^= 'last']")).sendKeys("Zahid");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder *= 'E-']")).sendKeys("abc123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[starts-with(@name, 'pho')]")).sendKeys("123 456 6778");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name = 'address']")).sendKeys("1234 USA st");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@name, 'city')]")).sendKeys("Alexandria");
		Thread.sleep(1000);

		WebElement drpDown = driver.findElement(By.name("state"));
		Select dD = new Select(drpDown);
		dD.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("input[name='zip']")).sendKeys("22309");
		driver.findElement(By.xpath("//button[contains(@onclick, 'Form();')]")).click();
		
		Thread.sleep(3000);
		driver.quit();

		

	}

}
