package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HwFb {

	public static String url = "https://www.facebook.com/reg/?rs=2";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		WebElement firstName = driver.findElement(By.id("u_0_n"));
		firstName.sendKeys("Tester");

		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("QA Tester");

		driver.findElement(By.xpath("//input[@id= 'u_0_s']")).sendKeys("test@gmail.com"); // email
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("test@gmail.com"); // confirm email
		driver.findElement(By.cssSelector("input#password_step_input")).sendKeys("testig1234"); // password

		WebElement birthMonth = driver.findElement(By.id("month")); // selecting birth month
		Select selectMonth = new Select(birthMonth);
		selectMonth.selectByIndex(10);

		Select selectDay = new Select(driver.findElement(By.name("birthday_day"))); // selecting birth Day
		selectDay.selectByValue("13");

		WebElement birthYear = driver.findElement(By.id("year"));
		Select selectYear = new Select(birthYear);
		selectYear.selectByVisibleText("1991");

		driver.findElement(By.id("u_0_5")).click(); // clicking radio button
		driver.findElement(By.id("u_0_14")).click(); // click sign up
		Thread.sleep(1000);

		driver.quit();

	}
}