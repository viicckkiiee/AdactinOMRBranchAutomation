package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To store and access all the locators present in SearchHotel webpage of AdactinHotelApp
 *
 */

public class SearchHotelpage extends BaseClass {
	
	public SearchHotelpage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement dnLocation;	
	@FindBy(id="hotels")
	private WebElement dnHotel;	
	@FindBy(id="room_type")
	private WebElement roomType;	
	@FindBy(id="room_nos")
	private WebElement roomNos;	
	@FindBy(id="datepick_in")
	private WebElement inDate;	
	@FindBy(id="datepick_out")
	private WebElement outDate;	
	@FindBy(id="adult_room")
	private WebElement adult;	
	@FindBy(id="child_room")
	private WebElement child;	
	@FindBy(id="Submit")
	private WebElement btnSubmit;	
	@FindBy(id="username_show")
	private WebElement helloUsernameMsg;	
	@FindBy(xpath="//span[text()='Please Select a Location']")
	private WebElement errorLocationMsg;	
	@FindBy(id="checkin_span")
	private WebElement checkInDateErrorMsg;	
	@FindBy(id="checkout_span")
	private WebElement checkOutDateErrorMsg;
	
	public WebElement getErrorLocationMsg() {
		return errorLocationMsg;
	}

	public WebElement getCheckInDateErrorMsg() {
		return checkInDateErrorMsg;
	}

	public WebElement getCheckOutDateErrorMsg() {
		return checkOutDateErrorMsg;
	}
	

	public WebElement getHelloUsernameMsg() {
		return helloUsernameMsg;
	}

	public WebElement getdnLocation() {
		return dnLocation;
	}

	public WebElement getdnHotel() {
		return dnHotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getInDate() {
		return inDate;
	}

	public WebElement getOutDate() {
		return outDate;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	
	public void searchHotel(String location,String hotelName,String roomType,String roomNos,String dateIn,String dateOut,String adultCount,String childCount ) {
		
		selectByText(getdnLocation(), location);
		selectByText(getdnHotel(), hotelName);
		selectByText(getRoomType(), roomType);
		selectByText(getRoomNos(), roomNos);
		getInDate().clear();
		send(getInDate(), dateIn);
		getOutDate().clear();
		send(getOutDate(), dateOut);
		selectByText(getAdult(), adultCount);
		selectByText(getChild(), childCount);
		click(getBtnSubmit());
		
	}
	
	public void searchHotel(String location,String dateIn,String dateOut) {
		
		selectByText(getdnLocation(), location);
		getInDate().clear();
		send(getInDate(), dateIn);
		getOutDate().clear();
		send(getOutDate(), dateOut);
		
		click(getBtnSubmit());
	}
	
	public void searchHotel() {
		click(getBtnSubmit());
	}
	
	public String helloUsernameMsg() {
		
		return getAttribute(getHelloUsernameMsg());
	}
	
	public String checkInErrorMsg() {
		return getText(getCheckInDateErrorMsg());
	}
	
	public String checkOutErrorMsg() {
		return getText(getCheckOutDateErrorMsg());
	}
	
	
	public String locationErrorMsg() {
		return getText(getErrorLocationMsg());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
