package com.revature.steps;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.trmsSubmitRequestPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trmsSubmitRequestStepImpl {

	private trmsSubmitRequestPage loginPage;
	private WebDriver driver;
	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		loginPage = new trmsSubmitRequestPage(driver);
	}

@Given("the user is on the reimbursement request submission page")
public void the_user_is_on_the_reimbursement_request_submission_page() {
loginPage.navigateTo();
}

@When("the user enters the information in all fields")
public void the_user_enters_the_information_in_all_fields() {
    loginPage.submitRequest("2", "100", "africa");
  
}

@When("the user enters the information in all fields incorrectly")
public void the_user_enters_the_information_in_all_fields_incorrectly() {
	 loginPage.submitRequest("564545", "100", "africa");
	
}


@Then("the messaged submitted apppears")
public void the_messaged_submitted_apppears() {
	
	 String msg=loginPage.getErrorMessage();
	  // System.out.println(msg);
	   assertTrue(msg.contains("has been sent"));
}

@Then("the appropriate error message should appear")
public void the_appropriate_error_message_should_appear() {
   String msg=loginPage.getErrorMessage();
   //System.out.println(msg);
   assertFalse(msg.contains("has been sent"));
}

}
