package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To store and access all the locators present in BookingConfirmation webpage of AdactinHotelApp
 *
 */

public class BookingConfirmationPage extends BaseClass {
	
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement confirmationText;
	@FindBy(name="order_no")
	private  WebElement orderIdElement;

	public WebElement getConfirmationText() {
		return confirmationText;
	}

	public  WebElement getOrderIdElement() {
		return orderIdElement;
	}
	
	public  String getOrderId() {
		
		return getAttribute(getOrderIdElement());
	}
	
	public String bookingconfirmMsg() {
		return getText(getConfirmationText());
	}
	
	

}
