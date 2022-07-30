package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To store and access all the locators present in BookingHotel webpage of AdactinHotelApp
 *
 */

public class BookingHotelPage extends BaseClass {
	
	public BookingHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	@FindBy(id="last_name")
	private WebElement txtLastName;
	@FindBy(id="address")
	private WebElement txtAddress;
	@FindBy(id="cc_num")
	private WebElement txtCreditCardNo;
	@FindBy(id="cc_type")
	private WebElement dDnCreditCardType;
	@FindBy(id="cc_exp_month")
	private WebElement dDnExpMonth;
	@FindBy(id="cc_exp_year")
	private WebElement dDnExpYear;	
	@FindBy(id="cc_cvv")
	private WebElement txtCVV;	
	@FindBy(id="book_now")
	private WebElement btnBookNow;	
	@FindBy(xpath="//td[contains(text(),'Book A Hotel')]")
	private WebElement msg;	
	@FindBy(id="first_name_span")
	private WebElement errorFirstnameMsg;	
	@FindBy(id="last_name_span")
	private WebElement errorLastnameMsg;	
	@FindBy(id="address_span")
	private WebElement errorAddressMsg;	
	@FindBy(id="cc_num_span")
	private WebElement errorCCNumMsg;	
	@FindBy(id="cc_type_span")
	private WebElement errorCCtypeMsg;	
	@FindBy(id="cc_expiry_span")
	private WebElement errorExpMonthMsg;	
	@FindBy(id="cc_cvv_span")
	private WebElement errorCVVMsg;

	
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getdDnCreditCardType() {
		return dDnCreditCardType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxtCVV() {
		return txtCVV;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getMsg() {
		return msg;
	}

	public WebElement getErrorFirstnameMsg() {
		return errorFirstnameMsg;
	}

	public WebElement getErrorLastnameMsg() {
		return errorLastnameMsg;
	}

	public WebElement getErrorAddressMsg() {
		return errorAddressMsg;
	}

	public WebElement getErrorCCNumMsg() {
		return errorCCNumMsg;
	}

	public WebElement getErrorCCtypeMsg() {
		return errorCCtypeMsg;
	}

	public WebElement getErrorExpMonthMsg() {
		return errorExpMonthMsg;
	}

	public WebElement getErrorCVVMsg() {
		return errorCVVMsg;
	}

	public void bookHotel(String firstName,String lastName,String address,String ccNo,String ccType,String expMonth,String expYear,String cvv) {
	
		send(getTxtFirstName(), firstName);
		send(getTxtLastName(), lastName);
		send(getTxtAddress(), address);
		send(getTxtCreditCardNo(), ccNo);
		selectByText(getdDnCreditCardType(), ccType);
		selectByText(getdDnExpMonth(), expMonth);
		selectByText(getdDnExpYear(), expYear);
		send(getTxtCVV(), cvv);
		click(getBtnBookNow());
	}
	
	public void bookHotel() {
		click(getBtnBookNow());
	}
	
	public String bookAHotelMsg() {
		return getText(getMsg());
	}
	
	public String firstNameError() {
		return getText(getErrorFirstnameMsg());
	}
	
	public String lastNameError() {
		return getText(getErrorLastnameMsg());
	}
	
	public String addressError() {
		return getText(getErrorAddressMsg());
	}
	
	public String ccNoError() {
		return getText(getErrorCCNumMsg());
	}
	
	public String ccTypeError() {
		return getText(getErrorCCtypeMsg());
	}
	
	public String expMonthError() {
		return getText(getErrorExpMonthMsg());
	}
	
	public String cvvError() {
		return getText(getErrorCVVMsg());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
