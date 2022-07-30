package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To execute snippets from TC2_SearchHotel feature file
 *
 */

public class SearchHotelStep extends BaseClass{

	PageObjectManager pom = new PageObjectManager();
	/**
	 * 
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param roomNos
	 * @param dateIn
	 * @param dateOut
	 * @param adultCount
	 * @param childCount
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @CreationDate 25/06/2022
	 * @Description To search hotel
	 */
	@Then("User should search hotel using {string} , {string} , {string} , {string} , {string} , {string} , {string} and {string}")
	public void userShouldSearchHotelUsingAnd(String location, String hotel, String roomType, String roomNos, String dateIn, String dateOut, String adultCount, String childCount) throws FileNotFoundException, IOException {
		pom.getSearchHotelpage().searchHotel(location, hotel, roomType, roomNos, dateIn, dateOut, adultCount, childCount);	 
	}
	
	/**
	 * 
	 * @param message
	 * @CreationDate 25/06/2022
	 * @Description To verify message after booking hotel successfully
	 */
	@Then("After searching hotel User should verify {string} message")
	public void afterSearchingHotelUserShouldVerifyMessage(String message) {
		
		Assert.assertTrue(pom.getSelectHotelPage().selectHotelMsg().contains(message),"Verify Select Hotel");
	}
	/**
	 * 
	 * @param location
	 * @param dateIn
	 * @param dateOut
	 * @CreationDate 25/06/2022
	 * @Description To search hotel using mandatory field only
	 */
	@Then("User should search hotel using mandatory fields {string} , {string} and {string}")
	public void userShouldSearchHotelUsingMandatoryFieldsAnd(String location, String dateIn, String dateOut) {
		pom.getSearchHotelpage().searchHotel(location, dateIn, dateOut);	
	}

	/**
	 * 
	 * @param checkInError
	 * @param checkOutError
	 * @CreationDate 25/06/2022
	 * @Description To verify date of out of range error
	 */
	@Then("After searching hotel User should verify Date OutOfRange error message {string} and {string}")
	public void afterSearchingHotelUserShouldVerifyDateOutOfRangeErrorMessageAnd(String checkInError, String checkOutError) {	
		Assert.assertTrue(pom.getSearchHotelpage().checkInErrorMsg().contains(checkInError),"Verify CheckInDate Error");
		Assert.assertTrue(pom.getSearchHotelpage().checkOutErrorMsg().contains(checkOutError),"Verify CheckOutDate Error");
	}
	
	/**
	 * @CreationDate 25/06/2022
	 * @Description To search hotel without any details
	 */
	@Then("User should search hotel without entering any fields")
	public void userShouldSearchHotelWithoutEnteringAnyFields() {
		
		pom.getSearchHotelpage().searchHotel();
		 	
	}
	/**
	 * 
	 * @param selectLocationErrorMsg
	 * @CreationDate 25/06/2022
	 * @Description To verify error message after searching without any details
	 */
	@Then("After searching hotel User should verify error message {string}")
	public void afterSearchingHotelUserShouldVerifyErrorMessage(String selectLocationErrorMsg) {
		
		Assert.assertTrue(pom.getSearchHotelpage().locationErrorMsg().contains(selectLocationErrorMsg),"Verify Location Error Msg");
		
	}


}
