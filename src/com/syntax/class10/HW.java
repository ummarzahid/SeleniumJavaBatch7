package com.syntax.class10;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {

	// overall practice so far we learned

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://artoftesting.com/samplesiteforselenium");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// sample Text
		WebElement sampleText = driver.findElement(By.xpath("//p[text() = 'This is sample text!']"));
		System.out.println(sampleText.getText());

		// This is a Link, separate window
		String mainPageHandle = driver.getWindowHandle();
		WebElement link = driver.findElement(By.xpath("//a[text() = 'This is a link']"));
		link.click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(mainPageHandle)) {
				driver.switchTo().window(windowHandle);
				driver.close();
			}
		}
		driver.switchTo().window(mainPageHandle);

		// TextBox
		WebElement textBox = driver.findElement(By.id("fname"));
		textBox.sendKeys("Ummar");

		// click Button
		WebElement clickButton = driver.findElement(By.id("idOfButton"));
		clickButton.click();

		// double click Button
		WebElement doubleClickButton = driver.findElement(By.id("dblClkBtn"));

		Actions action = new Actions(driver); // creating actions class to perform dblClick
		action.doubleClick(doubleClickButton).perform();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.accept();

		// radioButton
		List<WebElement> genderButtons = driver.findElements(By.xpath("//input[@name = 'gender']"));
		for (WebElement genderButton : genderButtons) {
			if (genderButton.isEnabled() && genderButton.getAttribute("id").equals("male")) {
				genderButton.click();
			}
		}

		// CheckBox
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type= 'checkbox']"));
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.isEnabled() && checkBox.getAttribute("value").equals("Automation")) {
				checkBox.click();
			}
		}

		// DropDown
		WebElement dropDpwn = driver.findElement(By.id("testingDropdown"));
		Select dd = new Select(dropDpwn);
		dd.selectByIndex(2);

		// Generate Alert box
		WebElement alertBox = driver.findElement(By.xpath("//button[text() = 'Generate Alert Box']"));
		alertBox.click();
		alert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());

		alert.accept();
		Thread.sleep(2000);

		// Generate confirm Box
		WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@onclick = 'if (!window.__cfRLUnblockHandlers) return false; generateConfirmBox()']"));
		confirmAlertButton.click();
		Thread.sleep(5000);
		Alert alert1 = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		alert1.dismiss();
		System.out.println("I'm here");
		Thread.sleep(5000);
		
		// Drag and Drop
		WebElement drag = driver.findElement(By.id("sourceImage"));
		WebElement drop = driver.findElement(By.xpath("//div[@ondrop = 'if (!window.__cfRLUnblockHandlers) return false; drop(event)']"));
		Thread.sleep(2000);
		//action.clickAndHold(drag).moveToElement(drop).release().build().perform();
		action.dragAndDrop(drag, drop).perform();
		
		

	}
}
