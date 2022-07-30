package com.stepdefinition;

import java.awt.AWTException;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To execute snippets from TC1_LoginPage feature file
 *
 */
public class LoginPageStep extends BaseClass {

	 PageObjectManager pom = new PageObjectManager();
	 /**
	  * 
	  * @throws FileNotFoundException
	  * @throws IOException
	  * @CreationDate 25/06/2022
	  * @Description To launch adactin login page
	  */
	@Given("User is on the adactin login page")
	public void userIsOnTheAdactinLoginPage() throws FileNotFoundException, IOException {
		
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @CreationDate 25/06/2022
	 * @Description To execute login
	 */
	@When("User should login using {string} and {string}")
	public  void userShouldLoginUsingAnd(String username, String password) throws FileNotFoundException, IOException {

		pom.getLoginPage().login(username, password);
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws AWTException
	 * @CreationDate 25/06/2022
	 * @Description To login with help of Enter Key
	 */
	@When("User should login using {string} and {string} with the help of Enter key")
	public void userShouldLoginUsingAndWithTheHelpOfEnterKey(String username, String password) throws AWTException {
		
		pom.getLoginPage().loginWithEnter(username, password);
		 
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 25/06/2022
	 * @Description To verify error message after logging in with invalid credentials
	 */
	@Then("After login User should verify  login error message contains {string}")
	public void afterLoginUserShouldVerifyLoginErrorMessageContains(String string) {
		
		Assert.assertTrue(pom.getLoginPage().errorMsg().contains("Invalid Login details or Your Password might have expired"),"Verify Login Error");
		
	}

}
