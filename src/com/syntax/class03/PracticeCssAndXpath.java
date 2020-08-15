package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCssAndXpath {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a#btn_basic_example")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text() = 'Simple Form Demo'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder^= 'Please enter']")).sendKeys("batch 7 rock!!!"); //css method starts wit
		driver.findElement(By.xpath("//button[text() = 'Show Message' ]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[starts-with(@id, 'sum1')]")).sendKeys("10");  //tagname[starts-with(@attribute, 'attribute value')]

		driver.findElement(By.cssSelector("input#sum2")).sendKeys("20"); //tagname#idValue
		driver.findElement(By.cssSelector("button[onclick $= '()']")).click(); //css method ends with
		
		driver.quit();
		
	}

}
