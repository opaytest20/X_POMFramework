package com.orange.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.orangehrm.base.TestBase;
import com.orange.orangehrm.pages.LoginPage;

public class LoginTests extends TestBase{
	LoginPage loginPage;
	
	public LoginTests() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		loginPage = new LoginPage();
	}
	
	@Test (priority=1)
	public void validateTitle() {
		String title = loginPage.getPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		Thread.sleep(5000);
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		WebElement element = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	@Test(priority=3)
	public void loginTestNegative() throws InterruptedException {
		Thread.sleep(5000);
		loginPage.login("invalid", "invalid");
		WebElement element = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
