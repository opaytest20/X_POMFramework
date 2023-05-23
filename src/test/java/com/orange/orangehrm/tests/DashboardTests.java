package com.orange.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.orangehrm.base.TestBase;
import com.orange.orangehrm.pages.DashboardPage;
import com.orange.orangehrm.pages.LoginPage;

public class DashboardTests extends TestBase{
	DashboardPage dashboardPage;
	LoginPage loginPage;
	
	public DashboardTests() {
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() {
		initialize();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void validateAdminLinkClick() {
		dashboardPage.clickAdminLink();
		WebElement element = driver.findElement(By.xpath("//h6[text()='Admin']"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	@Test
	public void validatePIMLinkClick() {
		dashboardPage.clickPIMLink();
		WebElement element = driver.findElement(By.xpath("//h6[text()='PIM']"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	@Test
	public void validateStopwatchLinkClick() {
		dashboardPage.clickStopwatchLink();
		WebElement element = driver.findElement(By.xpath("(//h6[text()='Attendance'])[1]"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
