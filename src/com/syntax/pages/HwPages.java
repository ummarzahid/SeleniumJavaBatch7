package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.Utils.HwBaseClass;

public class HwPages extends HwBaseClass {

	@FindBy(xpath = "//input[@id = 'txtUsername']")
	public WebElement userNametextBox;

	@FindBy(id = "txtPassword")
	public WebElement passwordTextBox;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(id = "spanMessage")
	public WebElement errorMsg;

	
	public HwPages() {
		PageFactory.initElements(driver, this);
	}

}
