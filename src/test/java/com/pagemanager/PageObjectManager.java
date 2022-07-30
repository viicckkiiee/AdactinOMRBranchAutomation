package com.pagemanager;

import com.pages.BookingConfirmationPage;
import com.pages.BookingHotelPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelpage;
import com.pages.SelectHotelPage;
/**
 * 
 * @author Vikki
 * @CreationDate 25/06/2022
 * @Description To create a pojo class for all pages
 *
 */
public class PageObjectManager {
	
	private LoginPage loginPage;
	private SearchHotelpage searchHotelpage;
	private SelectHotelPage selectHotelPage;
	private BookingHotelPage bookingHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private CancelBookingPage cancelBookingPage;
	
	public LoginPage getLoginPage() {
		return (loginPage==null)? loginPage = new LoginPage() : loginPage;
	}
	public SearchHotelpage getSearchHotelpage() {
		return (searchHotelpage==null)? searchHotelpage = new SearchHotelpage() : searchHotelpage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}
	public BookingHotelPage getBookingHotelPage() {
		return (bookingHotelPage==null)? bookingHotelPage = new BookingHotelPage() : bookingHotelPage;
	}
	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage==null)?bookingConfirmationPage = new BookingConfirmationPage() : bookingConfirmationPage;
	}
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage==null)? cancelBookingPage = new CancelBookingPage() : cancelBookingPage;
	}
	
	

}
