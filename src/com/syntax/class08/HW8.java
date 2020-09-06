package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW8 {

	/*
	 * go to https://the-internet.herokuapp.com/dynamic_controls click on checkbox
	 * and click on remove verify the text click on enable verify the textbox is
	 * enabled enter text and click disable verify the textbox is disabled
	 */

	public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// click on check box
		WebElement checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
		checkBox.click();

		// click on remove button
		WebElement removeButton = driver.findElement(By.xpath("//button[@onclick= 'swapCheckbox()']"));
		removeButton.click();
		// add explicit wait to for an element to be visible after clicking remove
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// type of ExpectedCondition
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
		// getting text
		WebElement text1 = driver.findElement(By.id("message"));
		String getTxt = text1.getText();
		System.out.println(getTxt);

		// click on enable
		WebElement enableButton = driver.findElement(By.xpath("//button[@onclick= 'swapInput()']"));
		enableButton.click();
		// wait
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
		// getting text
		WebElement text2 = driver.findElement(By.id("message"));
		System.out.println(text2.getText());

		WebElement textBox = driver.findElement(By.xpath("//input[@type= 'text']"));
		System.out.println("Text box is enabled-->" + textBox.isEnabled());

		textBox.sendKeys("Syntax is Awsome");

		// disabling text box
		WebElement disableButton = driver.findElement(By.xpath("//button[@onclick= 'swapInput()']"));
		disableButton.click();

		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(), 'disabled!')]")));

		WebElement textBoxisDisable = driver.findElement(By.xpath("//p[contains(text(), 'disabled!')]"));
		System.out.println(textBoxisDisable.getText());
		System.out.println("Text box is disabled-->" + textBoxisDisable.isEnabled());

		driver.quit();

	}
}
