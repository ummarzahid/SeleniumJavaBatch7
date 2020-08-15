package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HwEbay {

	/*
	 * HW2 Go to ebay.com get all the categories and print them in the console
	 * select Computers/Tables & Networking click on search verify the header
	 */

	public static String url = "https://www.ebay.com/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		WebElement AllCategories = driver.findElement(By.id("gh-cat")); // getting all categories
		Select selectDd = new Select(AllCategories);

		List<WebElement> list = selectDd.getOptions(); // saving all categories and printing in console
		for (WebElement dDlist : list) {
			String getText = dDlist.getText();
			System.out.println(getText);
		}

		selectDd.selectByVisibleText("Computers/Tablets & Networking"); // selcting Computers/Tablets & Networking
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#gh-btn")).click(); // click search

		// verify header  
		String expectedText = "Computers, Tablets & Network Hardware";
		String actualText = driver.findElement(By.xpath("//span[@class = 'b-pageheader__text']")).getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Header verified");
		} else {
			System.out.println("Wrong Header");
		}
		Thread.sleep(1000);
		driver.quit();

	}

}
