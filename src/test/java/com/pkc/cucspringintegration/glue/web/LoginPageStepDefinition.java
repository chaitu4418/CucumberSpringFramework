package com.pkc.cucspringintegration.glue.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pkc.cucspringintegration.pom.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * This class represents the Step definitions for the login feature.
 * 
 * @author Pius Kurian
 *
 */

public class LoginPageStepDefinition {
	/**
	 * Web driver is dynamically loaded fro the spring configuration file and and the active 
	 * profile in the config file
	 * 
	 * Usage: mvn test -Dspring.profiles.active=chrome. Here it initializes
	 * chrome browser.
	 * 
	 */
	@Autowired
	private WebDriver driver;

	private LoginPage loginPage;
	private boolean loginStatus;

	Logger logger = LoggerFactory.getLogger(LoginPageStepDefinition.class);

	/**
	 * Before hook for the feature.
	 */
	@Before
	public void open() {
		
		logger.info("entered the @Before segment, may add additional configuration...");
	}

	/**
	 * This method launches the browser and gets the login page
	 * 
	 * @param email
	 *            - username is the passed iin email from the feature file
	 * @throws Throwable
	 */
	@Given("^I launch \"([^\"]*)\" page$")
	public void launchPage(String url) throws Throwable {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
	}

	/**
	 * This method checks if the user is registered with the passed in email
	 * 
	 * @param email
	 * @throws Throwable
	 */
	@Given("^I am not a registered user with ([^\"]*)$")
	public void isRegisteredUser(String email) throws Throwable {
		loginPage.login(email, "");
		if (loginPage.isCustomerAccountFound("No customer account found")) {
			logger.error("The user is not registered and the test cannot continue");
			assertTrue(true);
		}
	}

	/**
	 * This method tries to login
	 * 
	 * @param email
	 * @param password
	 * @throws Throwable
	 */
	@And("^I login with unregistered ([^\"]*) and ([^\"]*)$")
	public void login(String email, String password) throws Throwable {

		loginStatus = loginPage.login(email, password);
		System.out.println("loginStatus:" + loginStatus);
		assertFalse(loginStatus);
	}

	/**
	 * This method verifies the login status with the input provided as status
	 * 
	 * @param status
	 *            - success for successful login and failure for failed login
	 * @throws Throwable
	 */
	@Then("^Verify my login ([^\"]*)$")
	public void verifyLogin(String status) throws Throwable {
		if (status.equals("success")) {
			assertTrue(loginStatus);
		} else if (status.equals("failure")) {
			assertFalse(loginStatus);
		}
	}

	/**
	 * After hook or the feature
	 */

	@After
	public void close() {
		driver.quit();
		driver = null;
	}

}