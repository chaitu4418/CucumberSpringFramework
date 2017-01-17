package com.pkc.cucspringintegration.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This class represents the Page Object Model for the Log in page.
 * 
 * @author Pius Kurian
 *
 */

public class LoginPage extends AbstractBasePage {

	@FindBy(how = How.ID, using = "Email")
	WebElement username;
	@FindBy(how = How.NAME, using = "Password")
	WebElement password;
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
	WebElement loginButton;
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[4]/input")
	WebElement loginButtonWithFailure;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Type Email
	 */

	private void typeUsername(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}

	/**
	 * Type password
	 */
	private void typePassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	/**
	 * Click on login button
	 */
	private void clickOnLoginButton() {

		this.loginButton.click();

	}

	/**
	 * This method searches for the provided text on the returned page after
	 * successful Log in.
	 * 
	 * @param text
	 *            - text to be found on the page
	 * @return - true or false based on the outcome
	 */

	public boolean isLoginSuccessful(String text) {
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		return list.size() > 0;
	}

	/**
	 * This method searches for the provided text on the returned page after
	 * successful Log in.
	 * 
	 * @param text
	 *            - text to be found on the page
	 * @return - true or false based on the outcome
	 */

	public boolean isCustomerAccountFound(String text) {
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		return list.size() > 0;
	}

	/**
	 * This method tests the login method and verifies that appropriate result
	 * is returned
	 * 
	 * @param username
	 *            - email of the registered user
	 * @param password
	 *            - password of the registered user
	 * @return boolean - true or false based on the log in outcome
	 */

	public boolean login(String username, String password) {

		typeUsername(username);
		typePassword(password);
		if (password.equals("")) {
			clickOnLoginButton();
		} else {
			clickOnLoginButtonWithFailure();
		}
		return isLoginSuccessful("Log out");
	}

	private void clickOnLoginButtonWithFailure() {
		loginButtonWithFailure.click();

	}
}
