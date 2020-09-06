package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUsingDoWhile {

	public static String url = "https://www.delta.com/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// opening calendar
		WebElement calender = driver.findElement(By.id("input_departureDate_1"));
		calender.click();
		// finding departing month element and getting month text
		WebElement departMonth = driver.findElement(By.className("dl-datepicker-month-0"));
		String dMonth = departMonth.getText();
		// finding next arrow button
		WebElement monthSelector = driver.findElement(By.xpath("//span[text() = 'Next']"));

		do { 
			monthSelector.click(); // clicking next arrow button
			dMonth = departMonth.getText(); 
			
		} while (!dMonth.equals("November"));

		List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
		for (WebElement departDate : departDates) {
			if (departDate.getText().equals("15")) {
				departDate.click();
				break;
			}
		}
		
		// finding return month element and getting month text
		WebElement returnMonth = driver.findElement(By.className("dl-datepicker-month-1"));
		String rMonth = returnMonth.getText();
		do {
			monthSelector.click();
			rMonth = returnMonth.getText();
			
		}while (!rMonth.equals("January"));

		List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
		for (WebElement returnDate : returnDates) {
			if(returnDate.getText().equals("25")) {
				returnDate.click();
				break;
			}
		}
		
		WebElement done = driver.findElement(By.className("donebutton"));
		done.click();
		
	}
}
