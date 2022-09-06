package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To store and access all the locators present in Login webpage of AdactinHotelApp
 *
 */

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement txtUsername;	
	@FindBy(id="password")
	private WebElement txtPassword;	
	@FindBy(id="login")
	private WebElement btnLogin;
	@FindBy(xpath="//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement errorLoginMsg;
	

	public WebElement getErrorLoginMsg() {
		return errorLoginMsg;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void login(String username,String password) {
		send(getTxtUsername(), username);
		send(getTxtPassword(), password);
		click(getBtnLogin());
	}
	
	public void loginWithEnter(String username,String password) throws AWTException {
		
		send(getTxtUsername(), username);
		send(getTxtPassword(), password);
		pressEnter();

	}
	
	public void login() {
		//Sample
		click(getBtnLogin());
	}
	
	public String errorMsg() {
		
		return getText(getErrorLoginMsg());
	}
}
