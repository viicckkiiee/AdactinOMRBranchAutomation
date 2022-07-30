package com.stepdefinition;

import org.testng.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To execute common snippets from all the feature files
 *
 */

public class CommonSteps {
	
	PageObjectManager pom = new PageObjectManager();
	/**
	 * 
	 * @param string
	 * @CreationDate 25/06/2022
	 * @Description To verify successful login message
	 */
	@Then("After login User should verify successful login message {string}")
	public void afterLoginUserShouldVerifySuccessfulLoginMessage(String string) {
		
		Assert.assertTrue(pom.getSearchHotelpage().helloUsernameMsg().contains(string),"Verify Login");
		
	}


}
