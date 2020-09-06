package com.syntax.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.syntax.Utils.HwBaseClass;
import com.syntax.pages.HwPages;

public class HwTest {

	public static HwPages hwPage;

	@BeforeMethod
	public void setUp() {
		HwBaseClass.setUp();
		hwPage = new HwPages();
	}

	@Test
	public void blankPasswordValidation() {
		// HwPages hwPage= new HwPages();
		hwPage.userNametextBox.sendKeys("Admin");
		hwPage.loginBtn.click();
		Assert.assertTrue(hwPage.errorMsg.isDisplayed());

	}

	@Test
	public void blankUsernameAndPasswordValidation() {
		// HwPages hwPage= new HwPages();
		hwPage.loginBtn.click();
		Assert.assertTrue(hwPage.errorMsg.isDisplayed());

	}

	@Test
	public void invalidPasswordValidation() {
		// HwPages hwPage= new HwPages();
		hwPage.userNametextBox.sendKeys("Admin");
		hwPage.passwordTextBox.sendKeys("123");
		hwPage.loginBtn.click();
		Assert.assertTrue(hwPage.errorMsg.isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		HwBaseClass.tearDown();
	}

}
