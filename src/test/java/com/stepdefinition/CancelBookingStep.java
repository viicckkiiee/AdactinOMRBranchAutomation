package com.stepdefinition;

import java.awt.AWTException;
import java.time.Duration;

import org.testng.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To execute snippets from TC5_CancelBooking feature file
 *
 */

public class CancelBookingStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
/**
 * 
 * @throws AWTException
 * @CreationDate 25/06/2022
 * @Description To  cancel generated order id
 */
@Then("User should cancel the generated order id")
public void userShouldCancelTheGeneratedOrderId() throws AWTException {
	implicitWait(Duration.ofSeconds(15));
	pom.getCancelBookingPage().cancelOrder(BookingHotelStep.orderId);
	
}
/**
 * 
 * @param string
 * @CreationDate 25/06/2022
 * @Description To verify 
 */
@Then("After cancelling the order id User should verify cancellation msg {string}")
public void afterCancellingTheOrderIdUserShouldVerifyCancellationMsg(String string) {
	
	Assert.assertTrue(pom.getCancelBookingPage().cancelledOrderMsg().contains(string),"Verify Booking Cancelled");
}
/**
 * 
 * @param string
 * @throws AWTException
 * @CreationDate 25/06/2022
 * @Description To cancel existing order id
 */
@Then("User should cancel the existing order id {string}")
public void userShouldCancelTheExistingOrderId(String string) throws AWTException {
	pom.getCancelBookingPage().cancelExistingOrder();
}

}
