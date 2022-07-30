package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * @author Vikki
 * @CreationDate 27/06/2022
 * @Description To execute some business logics before and after of each scenarios
 *
 */

public class HooksClass extends BaseClass {
	
	
	@Before
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @CreationDate 25/06/2022
	 * @Description To launch browser and open adactinhotel webpage
	 */
	public void beforeScenario() throws FileNotFoundException, IOException {
		
		getDriver(getPropertyFileValue("browsertype"));
		loadUrl(getPropertyFileValue("url"));
		implicitWait(Duration.ofSeconds(15));
	}
	
	@After
	/**
	 * 
	 * @param scenario
	 * @CreationDate 25/06/2022
	 * @Description To take screenshot and close the browser after each scenario 
	 */
	public void afterScenario(Scenario scenario) {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(b, "Every Scenario");
		
		closeBrowser();
		
	}
	
	

}
