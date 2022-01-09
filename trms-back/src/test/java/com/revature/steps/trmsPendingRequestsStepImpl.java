package com.revature.steps;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.revature.pages.trmsPendingRequestsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trmsPendingRequestsStepImpl {
	private trmsPendingRequestsPage loginPage;
	private WebDriver driver;
	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		loginPage = new trmsPendingRequestsPage(driver);
	}
	@Given("the user is on the request management page")
	public void the_user_is_on_the_request_management_page() {
	  loginPage.navigateTo();
	}

	@When("the user enters a  correct employee id")
	public void the_user_enters_a_correct_employee_id() {
	   loginPage.submitRequest("3");
	}

	@Then("the approproate alert appears")
	public void the_approproate_alert_appears() {
		 String msg=loginPage.getErrorMessage();
		 //  System.out.println(msg);
		   assertTrue(msg.contains("results"));
	}
	@Then("the approproate alert approved")
	public void the_approproate_alert_approved() {
		 String msg=loginPage.getErrorMessage();
		 //  System.out.println(msg);
		   assertTrue(msg.contains("Approved"));
	}
	@When("the user enters a invalid employee id")
	public void the_user_enters_a_invalid_employee_id() {
		loginPage.submitRequest("456455464");
	}

	@Then("the appropriate error alert appears")
	public void the_appropriate_error_alert_appears() {
		 String msg=loginPage.getErrorMessage();
		 //  System.out.println(msg);
		   assertFalse(msg.contains("results"));
	}

	@When("the user enters a request id plus selects role")
	public void the_user_enters_a_request_id_plus_selects_role() {
	 loginPage.submitApprove("3");
	}

	@When("the user enters a incorrect request id plus selects role")
	public void the_user_enters_a_incorrect_request_id_plus_selects_role() {
		loginPage.submitApprove("5455465465");
	}
	
}
