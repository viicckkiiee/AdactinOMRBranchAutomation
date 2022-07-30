package com.stepdefinition;

import java.util.List;
import java.util.Map;
import org.testng.*;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;
import cucumber.api.java.en.Then;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To execute snippets from TC4_BookingHotel feature file
 *
 */

public class BookingHotelStep extends BaseClass{
	
	static  String orderId;
	
	PageObjectManager pom = new PageObjectManager();
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 * @CreationDate 25/06/2022
	 * @Description To book the hotel with mandatory credentials and to save OrderId
	 */
	@Then("User should book the hotel with all mandatory credentials like {string},{string},{string} and save the order id")
	public void userShouldBookTheHotelWithAllMandatoryCredentialsLikeAndSaveTheOrderId(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> asMaps = dataTable.asMaps();
		String cvv = asMaps.get(2).get("CVV");
		String ccType = asMaps.get(2).get("CreditCard Type");
		String ccNo = asMaps.get(2).get("CreditCard No");
		String expMonth = asMaps.get(2).get("Exp Month");
		String expYear = asMaps.get(2).get("Exp Year");
		
		pom.getBookingHotelPage().bookHotel(firstName, lastName, address, ccNo, ccType, expMonth, expYear, cvv);
		
		orderId = pom.getBookingConfirmationPage().getOrderId();	
	}
	
	/**
	 * 
	 * @param string
	 * @CreationDate 25/06/2022
	 * @Description To verify message for successful  hotel booking
	 */
	@Then("After booking hotel successfully User should verify {string} message")
	public void afterBookingHotelSuccessfullyUserShouldVerifyMessage(String string) {
		
		Assert.assertTrue(pom.getBookingConfirmationPage().bookingconfirmMsg().contains(string),"Verify Booking Confirmation Msg");
		
	}
	/*
	 * @CreationDate 25/06/2022
	 * @Description To book hotel without any credentials
	 */
	@Then("User should book the hotel without entering any credentials")
	public void userShouldBookTheHotelWithoutEnteringAnyCredentials() {
		
		pom.getBookingHotelPage().bookHotel();
			
	}
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param add
	 * @param ccNo
	 * @param ccType
	 * @param expMonth
	 * @param cvv
	 * @CreationDate 25/06/2022
	 * @Description To verify error messages after clicking book now without any credentials
	 */
	@Then("After booking hotel User should verify error messages {string},{string},{string},{string},{string},{string} and {string}")
	public void afterBookingHotelUserShouldVerifyErrorMessagesAnd(String fName, String lName, String add, String ccNo, String ccType, String expMonth, String cvv) {
		Assert.assertTrue(pom.getBookingHotelPage().firstNameError().contains(fName),"Verify firstNameError");
		Assert.assertTrue(pom.getBookingHotelPage().lastNameError().contains(lName),"Verify lastName Error");
		Assert.assertTrue(pom.getBookingHotelPage().addressError().contains(add),"Verify address Error");
		Assert.assertTrue(pom.getBookingHotelPage().ccNoError().contains(ccNo),"Verify ccNo Error");
		Assert.assertTrue(pom.getBookingHotelPage().ccTypeError().contains(ccType),"Verify ccType Error");
		Assert.assertTrue(pom.getBookingHotelPage().expMonthError().contains(expMonth),"verify expMonth Error");
		Assert.assertTrue(pom.getBookingHotelPage().cvvError().contains(cvv),"Verify cvv Error");
	}


}
