 package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.stepdefinition.BookingHotelStep;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To store and access all the locators present in CancelBooking webpage of AdactinHotelApp
 *
 */

public class CancelBookingPage extends BookingHotelStep{
	
	
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_id_text")
	private WebElement txtOrderId;
	@FindBy(name="search_hotel_id")
	private WebElement searchButton;
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnItinerary;
	@FindBy(xpath="//input[contains(@id,'btn')]")
	private WebElement cancelOrder;
	@FindBy(id="search_result_error")
	private WebElement cancelMsg;
	
	public WebElement getCancelMsg() {
		return cancelMsg;
	}
	
	public WebElement getBtnItinerary() {
		return btnItinerary;
	}

	
	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCancelOrder() {
		return cancelOrder;
	}
	
public void cancelOrder(String orderId) throws AWTException {
	
	click(getBtnItinerary());
	send(getTxtOrderId(),orderId);
	click(getSearchButton());
	click(getCancelOrder());
	acceptAlert();
		
	}

public void cancelExistingOrder() throws AWTException {
	click(getBtnItinerary());
	click(getCancelOrder());
	acceptAlert();
	
}

public String cancelledOrderMsg() {
	return getText(getCancelMsg());
}
	

}
