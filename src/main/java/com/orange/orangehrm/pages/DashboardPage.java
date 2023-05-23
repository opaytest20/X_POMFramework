package com.orange.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.orangehrm.base.TestBase;

public class DashboardPage extends TestBase{
	@FindBy(xpath = "//span[text()='Admin']") 
	WebElement adminLink;
	
	@FindBy(xpath = "//span[text()='PIM']") 
	WebElement pimLink;
	
	@FindBy(xpath = "//span[text()='Leave']") 
	WebElement leaveLink;
	
	@FindBy(xpath = "//span[text()='Time']") 
	WebElement timeLink;
	
	@FindBy(xpath = "//p[text()='Time at Work']") 
	WebElement timeAtWorkLabel;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-stopwatch']") 
	WebElement stopwatchIcon;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AdminPage clickAdminLink() {
		adminLink.click();
		return new AdminPage();
	}
	
	public PIMPage clickPIMLink() {
		pimLink.click();
		return new PIMPage();
	}
	
	public LeavePage clickLeaveLink() {
		leaveLink.click();
		return new LeavePage();
	}
	
	public TimePage clickTimeLink() {
		timeLink.click();
		return new TimePage();
	}
	
	public AttendancePage clickStopwatchLink() {
		stopwatchIcon.click();
		return new AttendancePage();
	}
	
	public String captureTimeAtWorkLabel() {
		return timeAtWorkLabel.getText();
	}
}
