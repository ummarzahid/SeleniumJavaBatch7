package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handlingDropDowns {

	public static String url = "http://166.62.36.207/syntaxpractice/basic-select-dropdown-demo.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		WebElement daysDD = driver.findElement(By.id("select-demo"));
		Select select = new Select(daysDD); // always need a select class to get an element from the DD list 
		
		select.selectByIndex(2);
//		Thread.sleep(1000);
//		
//		select.selectByVisibleText("Wednesday");
//		Thread.sleep(1000);
//		
//		select.selectByValue("Sunday");
		
		// need to create a List to store DD options and to see the DD size and use method .getOptions(); and .size();
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println(size);
		
		//using for loop to loop through all options one bye one 
		for(int i = 0; i < size; i++) {
			select.selectByIndex(i);
			Thread.sleep(1000);
		}

	}

}
