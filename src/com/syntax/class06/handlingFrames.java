package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingFrames {

	public static String url = "http://uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.switchTo().frame(0); // switching into frame by index
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("Batch 7");
		
		driver.switchTo().defaultContent(); // switching back to main page 
		
		WebElement clickOnLinkText = driver.findElement(By.xpath("//h3[text() = 'click on the below link: ']"));
		String text = clickOnLinkText.getText();
		System.out.println(text);
		
		driver.switchTo().frame("iframe_a"); // switching by name 
		textBox.clear();
		textBox.sendKeys("Syntax");
		
		driver.switchTo().defaultContent();
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));
		driver.switchTo().frame(iframe); // switching by WebElement 
		textBox.clear();
		textBox.sendKeys("Wassup");

	}
}
