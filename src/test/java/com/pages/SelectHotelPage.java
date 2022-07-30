package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To store and access all the locators present in SelectHotel webpage of AdactinHotelApp
 *
 */

public class SelectHotelPage extends BaseClass {
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="radiobutton_0")
	private WebElement btnSelect;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(className="login_title")
	private WebElement msg;	
	@FindBy(id="radiobutton_span")
	private WebElement selectHotelErrorMsg;

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getSelectHotelErrorMsg() {
		return selectHotelErrorMsg;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getMsg() {
		return msg;
	}


	public void selectHotel() {
		click(getBtnSelect());
		click(getBtnContinue());
	}

	public void selectContinue() {
		click(getBtnContinue()); 
	}

	public String errorMsg() {
		return getText(getSelectHotelErrorMsg());
	}
	
	public String selectHotelMsg() {
		return getText(getMsg());
	}
	
	public String selectHotelErrorMsg() {
		return getText(getSelectHotelErrorMsg());
	}
	

}
