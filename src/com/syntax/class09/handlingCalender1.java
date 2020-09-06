package com.syntax.class09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handlingCalender1 {

	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();

		WebElement leave = driver.findElement(By.linkText("Leave"));
		leave.click();

		WebElement leaveList = driver.findElement(By.linkText("Leave List"));
		leaveList.click();
		Thread.sleep(2000);

		WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
		fromCalendar.click();
		WebElement mDD = driver.findElement(By.className("ui-datepicker-month"));
		Select monthDD = new Select(mDD);
		monthDD.selectByVisibleText("Oct");

		WebElement yDD = driver.findElement(By.className("ui-datepicker-year"));
		Select yearDD = new Select(yDD);
		yearDD.selectByVisibleText("2021");

		List<WebElement> fromDates = driver
				.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement fromDate : fromDates) {
			if (fromDate.getText().equals("15")) {
				fromDate.click();
				break;
			}
		}

	}
}
