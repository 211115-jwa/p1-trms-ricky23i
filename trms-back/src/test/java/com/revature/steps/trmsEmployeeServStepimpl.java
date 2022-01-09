package com.revature.steps;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.trmsEmployeeServicePage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trmsEmployeeServStepimpl {
	private trmsEmployeeServicePage loginPage;
	private WebDriver driver;
	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		loginPage = new trmsEmployeeServicePage(driver);
	}
	@Given("the user is on the requests page")
	public void the_user_is_on_the_requests_page() {
		loginPage.navigateTo();
	}
	@When("the user enters a incorrect employee id")
	public void the_user_enters_a_incorrect_employee_id() {
		 loginPage.submitRequest("454546");
	}
	@When("the user enters a employee id")
	public void the_user_enters_a_employee_id() {
		 loginPage.submitRequest("2");
	}

	@Then("the appropriate invalid msg should appear")
	public void the_appropriate_invalid_msg_should_appear() {
		 String msg=loginPage.getErrorMessage();
		  // System.out.println(msg);
		   assertFalse(msg.contains("result"));
	}

	@Then("the approproate information appears")
	public void the_approproate_information_appears() {
		 String msg=loginPage.getErrorMessage();
		 //  System.out.println(msg);
		   assertTrue(msg.contains("result"));
	}

}
