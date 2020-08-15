package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launches the browser 
		driver.get("http://google.com"); // open the website 
		Thread.sleep(3000);
		
		driver.navigate().to("http://facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		driver.close();// will close the tab
		//driver.quit();// .quit()---> use to exit the browser.

	}

}
