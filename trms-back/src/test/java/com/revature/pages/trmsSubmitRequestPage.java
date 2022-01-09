package com.revature.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class trmsSubmitRequestPage {
	private WebDriver driver;
	
	@FindBy(id="id")
	private WebElement empIdInput;
	@FindBy(id="loca")
	private WebElement eventType;
	@FindBy(id="cost")
	private WebElement cost;
	@FindBy(id="submitbutton")
	private WebElement loginBtn;

	
	
	
	public trmsSubmitRequestPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo() {
		driver.get("file:///C:/Users/rduen/eclipse-workspace/project1/p1-trms-ricky23i/trms-front/trms_front.html");
	}
	@SuppressWarnings("deprecation")
	public void submitRequest(String id, String c, String evn) {
		empIdInput.sendKeys(id);
		eventType.sendKeys(evn);
		cost.sendKeys(c);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		loginBtn.click();
	}
	@SuppressWarnings("deprecation")
	public String getErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a= driver.switchTo().alert();
		return a.getText();
	}


}
