package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

	/*
	 * Go to http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html Select
	 * any radiobutton and the age group ---> use List and loop Click on get values
	 * Verify the text in the page -- do not hardcode the values and compare
	 */

	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		System.out.println("========== Single Radio Buttons Demo ==========");

		List<WebElement> sexButtons = driver.findElements(By.xpath("//input[@name = 'optradio']"));

		for (WebElement sexButton1 : sexButtons) {
			if (sexButton1.isEnabled()) {
				String bt = sexButton1.getAttribute("value");

				if (bt.equals("Male")) {
					sexButton1.click();
					Thread.sleep(1000);
					break;
				}

			}

		}

		WebElement getChekcedValue = driver.findElement(By.id("buttoncheck"));
		getChekcedValue.click();

		WebElement checkingValue = driver.findElement(By.xpath("//p[@class = 'radiobutton']"));
		if (checkingValue.isDisplayed()) {
			String getCheckedValueText = checkingValue.getText();
			if (getCheckedValueText.equals("Radio button 'Male' is checked")) {
				System.out.println("Radio Button Test passed");
			} else {
				System.out.println("Radio Button Test Failed");
			}
		}

		System.out.println("========== Group Radio Buttons Demo ==========");

		List<WebElement> genderButtons = driver.findElements(By.xpath("//input[@name = 'gender']"));
		for (WebElement genderButton1 : genderButtons) {
			if (genderButton1.isEnabled()) {
				String btn = genderButton1.getAttribute("value");
				if (btn.equals("Male")) {
					genderButton1.click();
					Thread.sleep(1000);
					break;

				}
			}
		}

		List<WebElement> ageButtons = driver.findElements(By.xpath("//input[@name = 'ageGroup']"));
		for (WebElement ageButton1 : ageButtons) {
			if (ageButton1.isEnabled()) {
				String bttn = ageButton1.getAttribute("value");
				if (bttn.equals("15 - 50")) {
					ageButton1.click();
					Thread.sleep(1000);
					break;
				}
			}

		}

		WebElement getValuesButton = driver.findElement(By.xpath("//button[@onclick= 'getValues();']"));
		getValuesButton.click();

		WebElement verifyGetValuesButton = driver.findElement(By.xpath("//p[@class = 'groupradiobutton']"));
		if (verifyGetValuesButton.isDisplayed()) {
			String result = verifyGetValuesButton.getText();
			if (result.contains("Sex : Male") || result.contains(" Age group: 15 - 50")) {
				System.out.println("Group Radio Buttons Demo Test Passed");
			} else {
				System.out.println("Test Failed");
			}
		}

	}

}
