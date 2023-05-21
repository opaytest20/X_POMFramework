package com.orange.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.orangehrm.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name = "username") 
	WebElement usernameField;
	
	@FindBy(name = "password") 
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@type='submit']") 
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public DashboardPage login(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new DashboardPage();
	}
}
