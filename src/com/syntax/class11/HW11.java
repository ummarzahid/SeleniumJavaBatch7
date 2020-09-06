package com.syntax.class11;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW11 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Index");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// deleting from table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class= 'table']/tbody/tr"));
		System.out.println(rows.size());

		for (int i = 1; i < rows.size(); i++) {
			String rowText = rows.get(i).getText();
			if (rowText.contains("Phani3")) {
				WebElement cols = driver.findElements(By.xpath("//table[@class= 'table']/tbody/tr/td[4]")).get(i - 1);
				String text = cols.getText();
				if (text.contains("DELETE")) {
					cols.click();
					break;
				}
			}
		}
		driver.findElement(By.xpath("//input[@type= 'submit']")).click();

		// AjaxCall
		WebElement ajaxButton = driver.findElement(By.xpath("//a[text() = 'AjaxCall']"));
		ajaxButton.click();

		WebElement ajaxLink = driver.findElement(By.xpath("//a[text() = 'This is a Ajax link']"));
		ajaxLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'ContactUs']")));
		String getText = driver.findElement(By.xpath("//div[@class = 'ContactUs']")).getText();
		System.out.println(getText);

		// Form
		WebElement formButton = driver.findElement(By.xpath("//a[text() = 'Form']"));
		formButton.click();
		WebElement formTab = driver.findElement(By.linkText("Form"));
		formTab.click();
		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.sendKeys("Ummar");
		WebElement lastname = driver.findElement(By.id("lastname"));
		lastname.sendKeys("Zahid");

		// radio button
		List<WebElement> radioButtons = driver.findElements(By.xpath("//label[@class='radio-inline']"));
		for (WebElement radioButton : radioButtons) {
			if (radioButton.isEnabled() && radioButton.getText().equals("Married")) {
				driver.findElement(By.xpath("//input[@name='optradio']")).click();
			}
		}

		// CheckBox
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//label[@class='checkbox-inline']"));
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.isEnabled() && checkBox.getText().equals("Reading")) {
				driver.findElement(By.xpath("//input[@value='read']")).click();
			}
		}

		// select
		WebElement country = driver.findElement(By.id("sel1"));
		Select select = new Select(country);
		select.selectByVisibleText("Canada");

		// Calendar
		WebElement calender = driver.findElement(By.id("datepicker"));
		calender.click();
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select select1 = new Select(month);
		select1.selectByIndex(9);

		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select2 = new Select(year);
		select2.selectByValue("1991");

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement date : dates) {
			if (date.getText().equals("13")) {
				date.click();
				break;
			}
		}

		WebElement phoneNumber = driver.findElement(By.id("phonenumber"));
		phoneNumber.click();
		phoneNumber.sendKeys("123456789");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Syntax123");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("syntaxtest@gmail.com");
		WebElement comment = driver.findElement(By.id("comment"));
		comment.sendKeys("I am learning SDET");
		WebElement password = driver.findElement(By.id("pwd"));
		password.sendKeys("password007");
		WebElement submit1 = driver.findElement(By.xpath("//button[@type='submit']"));
		submit1.click();

		// Control
		WebElement controlTab = driver.findElement(By.xpath("//a[text() ='Controls']"));
		controlTab.click();

		// drag----drop
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, dropable).perform();
		Thread.sleep(2000);

		// DoubleClick
		WebElement dbClick = driver.findElement(By.xpath("//button[@name='dblClick']"));
		action.doubleClick(dbClick).perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// iFrame
		driver.switchTo().frame("iframe_a");
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("Ummar Zahid");
		driver.switchTo().defaultContent();

		// New Tab
		String mainPage = driver.getWindowHandle();
		System.out.println(mainPage);
		WebElement newTabBtn = driver.findElement(By.id("Button"));
		newTabBtn.click();

		Set<String> allWindowHandle = driver.getWindowHandles();
		Iterator<String> it = allWindowHandle.iterator();
		String childPage = it.next();
		childPage = driver.getWindowHandle();
		System.out.println(childPage);
		driver.switchTo().window(mainPage);

		// New Window
		WebElement pressPlay = driver.findElement(By.linkText("Click here to watch videos on C#"));
		pressPlay.click();
		Thread.sleep(10000);
		Iterator<String> it2 = allWindowHandle.iterator();
		String childPages = it2.next();
		System.out.println("This is child handle: " + childPages);
		driver.switchTo().window(mainPage);

		// Widgets
		WebElement widgetsTab = driver.findElement(By.linkText("Widgets"));
		widgetsTab.click();
		WebElement chooseFile = driver.findElement(By.id("image_file"));
		chooseFile.sendKeys("C:\\Users\\ammar\\Desktop\\uploadFileTest.txt");
		WebElement upLoad = driver.findElement(By.xpath("//input[@type='button']"));
		upLoad.click();

		// Click Me!
		WebElement actionsTab = driver.findElement(By.linkText("Actions"));
		actionsTab.click();
		WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me !']"));
		clickMe.click();
		alert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// Double Click
		WebElement dBclickMe = driver.findElement(By.xpath("//button[text()='Double Click Me !']"));
		action.doubleClick(dBclickMe).perform();
		alert = driver.switchTo().alert();
		alert.accept();

		// MouseHoverOver to blue box
		WebElement blueBox = driver.findElement(By.id("div2"));
		action.moveToElement(blueBox).perform();

		// drag and drop
		WebElement draggable2 = driver.findElement(By.id("draggable"));
		WebElement droppable2 = driver.findElement(By.id("droppable"));
		action.dragAndDrop(draggable2, droppable2).perform();

		// Selecting numbers on a grid
		WebElement draggable3 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-selectee']"));
		WebElement droppable3 = driver.findElement(By.xpath("//li[@name='eleven']"));
		action.dragAndDrop(draggable3, droppable3).perform();

		// ScreenShots
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/SeFinalBigHW/SC.png")); 
																							
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);
		driver.quit();

	}
}
