package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmericanUsingDoWhile {

	public static String url = "https://www.aa.com/homePage.do";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		// enetring destination
		WebElement dest = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
		dest.sendKeys("SYD");

		// opening calendar
		WebElement calendar = driver.findElement(By.id("aa-leavingOn"));
		calendar.click();

		// finding departing month element and getting month text
		WebElement departMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
		String dMonth = departMonth.getText();
		String expMonth = "December"; // assigning variable with month I want

		do { //do while loop. looping over months until it matches desired month, 
			// relocating and calling on next arrow 4 times
			WebElement nextButton = driver.findElement(By.xpath("//a[@title = 'Next']"));
			nextButton.click();
			WebElement nextButton1 = driver.findElement(By.xpath("//a[@title = 'Next']"));
			nextButton1.click();
			WebElement nextButton2 = driver.findElement(By.xpath("//a[@title = 'Next']"));
			nextButton2.click();
			WebElement nextButton3 = driver.findElement(By.xpath("//a[@title = 'Next']"));
			nextButton3.click(); 
			
			dMonth = expMonth;// breaking the loop by re-assigning 

		} while (!dMonth.equals(expMonth));

		List<WebElement> departDates = driver
				.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement departDate : departDates) {
			if (departDate.getText().equals("10")) {
				departDate.click();
				break;
			}
		}
		
		// repeating the above process but opening calendar again
		WebElement returnCalendar = driver.findElement(By.id("aa-returningFrom"));
		returnCalendar.click();

		WebElement returnMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
		String rMonth = returnMonth.getText();
		String expReturnMonth = "January";

		do {
			WebElement nextButton4 = driver.findElement(By.xpath("//a[@title = 'Next']"));
			nextButton4.click();
			rMonth = expReturnMonth;
		} while (!rMonth.equals(expReturnMonth));

		List<WebElement> returnDates = driver
				.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement returnDate : returnDates) {
			if (returnDate.getText().equals("20")) {
				returnDate.click();
				break;
			}
		}

	}
}
