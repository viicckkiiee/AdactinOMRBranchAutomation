package com.stepdefinition;

import org.testng.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To execute snippets from TC3_SelectHotel feature file
 *
 */

public class SelectHotelStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	/**
	 * @CreationDate 25/06/2022
	 * @Description To select a hotel and continue
	 */
	@Then("User should select a hotel and click continue")
	public void userShouldSelectAHotelAndClickContinue() {
		pom.getSelectHotelPage().selectHotel();
		 
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 25/06/2022
	 * @Description To verify successful message after selecting a hotel
	 */
	@Then("After selecting a hotel successfully User should verify {string} message")
	public void afterSelectingAHotelSuccessfullyUserShouldVerifyMessage(String string) {
		
		Assert.assertTrue(pom.getBookingHotelPage().bookAHotelMsg().contains(string),"Verify Book A Hotel");
		
	}
	/**
	 * @CreationDate 25/06/2022
	 * @Description To continue without selecting a hotel
	 */
	@Then("User should click continue without selecting a hotel")
	public void userShouldClickContinueWithoutSelectingAHotel() {
		
		pom.getSelectHotelPage().selectContinue();
		 
	}
	/**
	 * 
	 * @param string
	 * @CreationDate 25/06/2022
	 * @Description TO verify error message
	 */
	@Then("After clicking continue User should verify error message {string}")
	public void afterClickingContinueUserShouldVerifyErrorMessage(String string) {
		
		Assert.assertTrue(pom.getSelectHotelPage().selectHotelErrorMsg().contains(string),"Verify Please Select a Hotel");

	}


}
