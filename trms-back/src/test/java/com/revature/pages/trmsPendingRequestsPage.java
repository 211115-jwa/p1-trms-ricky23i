package com.revature.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class trmsPendingRequestsPage {
	private WebDriver driver;
	
	@FindBy(id="reqid")
	private WebElement reqIdInput;
	@FindBy(id="empid")
	private WebElement empIdInput;
	@FindBy(id="submit2")
	private WebElement reqbut;
	@FindBy(id="approver")
	private WebElement a;
	@FindBy(id="denyr")
	private WebElement d;

	
	
	
	public trmsPendingRequestsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo() {
		driver.get("file:///C:/Users/rduen/eclipse-workspace/project1/p1-trms-ricky23i/trms-front/request_rewiew.html");
	}
	@SuppressWarnings("deprecation")
	public void submitRequest(String id) {
		empIdInput.sendKeys(id);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		reqbut.click();
	}
	@SuppressWarnings("deprecation")
	public void submitApprove(String id) {
		reqIdInput.sendKeys(id);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		a.click();
	}
	
	@SuppressWarnings("deprecation")
	public String getErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a= driver.switchTo().alert();
		return a.getText();
	}
}
