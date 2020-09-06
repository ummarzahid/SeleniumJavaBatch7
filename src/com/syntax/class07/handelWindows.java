package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handelWindows {
	
	public static String url = "https://accounts.google.com/signup";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		String mainPageHandle = driver.getWindowHandle(); //to get window handle or unique identifier
		System.out.println(mainPageHandle);
		
		WebElement helpLink = driver.findElement(By.linkText("Help"));
		helpLink.click();
		
		Set<String> allWindowHandles = driver.getWindowHandles(); // making a Set of all windows to get handel of all windows
		System.out.println(allWindowHandles.size());
		Iterator<String> it = allWindowHandles.iterator(); // making Iterator to switch between multiple windows
		mainPageHandle = it.next();
		String childHandle = it.next();
		System.out.println(childHandle);
		Thread.sleep(2000);
		driver.switchTo().window(mainPageHandle); // switching back to mainpage 
		
		driver .quit();
		
		

	}

}
