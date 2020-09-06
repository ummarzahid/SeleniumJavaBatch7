package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {

	/*
	 * Go to https://demoqa.com/browser-windows click on New Tab and print the text
	 * from new tab in the console click on New Window and print the text from new
	 * window in the console click on New Window Message and print the text from new
	 * window in the console Verify the title is displayed Print out the title of
	 * the main page
	 */

	public static String url = "https://demoqa.com/browser-windows";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		String mainPageHandle = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// First Window Tab
		WebElement newTabButton = driver.findElement(By.id("tabButton"));
		newTabButton.click();

		Set<String> windowHandle1 = driver.getWindowHandles();
		for (String currentWindow1 : windowHandle1) {
			driver.switchTo().window(currentWindow1);
		}

		WebElement newTabText = driver.findElement(By.id("sampleHeading"));
		System.out.println("First Window Text --> " + newTabText.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);

		// Second Window
		WebElement newWindowButton = driver.findElement(By.id("windowButton"));
		newWindowButton.click();

		Set<String> windowHandle2 = driver.getWindowHandles();
		for (String currentWindow2 : windowHandle2) {
			driver.switchTo().window(currentWindow2);
		}

		WebElement newWindowText = driver.findElement(By.xpath("//h1[text() = 'This is a sample page']"));
		System.out.println("Second Window Text --> " + newWindowText.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);

		// Third window
		WebElement newWindowMessageButton = driver.findElement(By.id("messageWindowButton"));
		newWindowMessageButton.click();

		Set<String> windowHandle3 = driver.getWindowHandles();
		for (String currentWindow3 : windowHandle3) {
			driver.switchTo().window(currentWindow3);
		}
//		WebElement newWindowMsgText = driver.findElement(By.xpath("/html/body"));
//		System.out.println("Third Window Text--> " + newWindowMsgText.getText());
		driver.close();
		driver.switchTo().window(mainPageHandle);
		
		WebElement logo = driver.findElement(By.xpath("//img[@src = '/images/Toolsqa.jpg']"));
		boolean isLogoDisplayed = logo.isDisplayed();
		System.out.println("Logo is Displayed " + isLogoDisplayed);
		System.out.println(driver.getTitle());
		
		driver.quit();

	}
}
