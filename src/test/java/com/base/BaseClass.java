package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Vikki
 * @Description TO  maintain all the reusable methods
 * @CreationDate 23/06/2022
 *  * 
 */
public class BaseClass {
	
public static WebDriver driver;
	
	/**
	 * 
	 * @param duration
	 * @CreationDate 23/06/2022
	 * @Description Allows driver to wait for certain time before throwing an exception
	 * 
	 */
	public static void implicitWait(Duration duration) {
		driver.manage().timeouts().implicitlyWait(duration);
	}
	/**
	 * @CreationDate 23/06/2022
	 * @Description To click accept/Ok in simple Alert
	 */
	public static void acceptAlert() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	/**
	 * 
	 * @param browserType
	 * @CreationDate 23/06/2022
	 * @Description To launch the particular browser based on given parameter
	 */
	public static void getDriver(String browserType) {
		
		switch (browserType) {
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Mentioned browser not defined");
			break;
		}
		
	}
	
	/**
	 * 
	 * @param url
	 * @CreationDate 23/06/2022
	 * @Description To load requested Web Page based on given url
	 */
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * 
	 * @param element
	 * @return String
	 * @CreationDate 23/06/2022
	 * @Description To get the text from given web element
	 */
	public String getText(WebElement element) {
		String text = element.getText(); return text;
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 * @CreationDate 23/06/2022
	 * @Description To insert values in textbox field 
	 */
	public void send(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	/**
	 * 
	 * @param element
	 * @CreationDate 23/06/2022
	 * @Description To click a Web Element
	 * 
	 */
	public static void click(WebElement element) {
		element.click();
	}
	
	/**
	 * 
	 * @param id
	 * @return WebElement
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using locator 'Id'
	 */
	public WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}
	
	/**
	 * 
	 * @param name
	 * @return WebElement
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using locator 'name'
	 */
	public WebElement findElementByName(String name) {
		return driver.findElement(By.name(name));
	}
	
	/**
	 * 
	 * @param className
	 * @return WebElement
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using locator class
	 */
	public WebElement findElementClassname(String className) {
		return driver.findElement(By.className(className));
	}
	
	/**
	 * 
	 * @param xpath
	 * @return WebElement
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using locator XPath
	 */
	public WebElement findElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * 
	 * @param tagName
	 * @return WebElement
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using tagName
	 */
	public WebElement findElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}
	
	/**
	 * 
	 * @param tagName
	 * @param text
	 * @return WebElement
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using text in XPath
	 */
	public WebElement findElementByText(String tagName, String text) {
		return driver.findElement(By.xpath("//" + tagName + "[text()='" + text + "']"));
	}
	
	/**
	 * 
	 * @param tagName
	 * @param partialText
	 * @return WebElement
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using partial text in XPath
	 */
	public WebElement findElementByPartialText(String tagName, String partialText) {
		return driver.findElement(By.xpath("//" + tagName + "[contains(text(),'"+partialText+"')]"));
	}
	
	/**
	 * 
	 * @param tagName
	 * @param attributeName
	 * @param attriValue
	 * @return WebElement 
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using Attribute name and value
	 */
	public WebElement findElementByAttribute(String tagName, String attributeName, String attriValue) {
		return driver.findElement(By.xpath("//"+tagName+"[@"+attributeName+"='"+attriValue+"']"));
	}
	
	/**
	 * 
	 * @param tagName
	 * @param attributeName
	 * @param partialAttriValue
	 * @return WebElement 
	 * @CreationDate 23/06/2022
	 * @Description To find a WebElement by using partial attribute value
	 */
	public WebElement findElementBypartialAttributeValue(String tagName, String attributeName, String partialAttriValue) {
		return driver.findElement(By.xpath("//"+tagName+"[contains(@"+attributeName+"='"+partialAttriValue+"')]"));
	}
	
	/**
	 * 
	 * @param element
	 * @return String
	 * @CreationDate 23/06/2022
	 * @Description To get the inserted or stored value in a WebElement
	 */
	public static String getAttribute(WebElement element) {
		return element.getAttribute("value");
	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @CreationDate 23/06/2022
	 * @Description To check whether a WebElement is displayed on webpage or not
	 */
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @CreationDate 23/06/2022
	 * @Description To check whether a textbox is enabled to insert values or not
	 * 
	 */
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 * @CreationDate 23/06/2022
	 * @Description To check whether a WebElement is selected or not
	 */
	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	
	/**
	 * 
	 * @param milliSeconds
	 * @throws InterruptedException
	 * @CreationDate 23/06/2022
	 * @Description To make the driver wait for some specified time
	 */
	public void sleep(long milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 * @CreationDate 23/06/2022
	 * @Description To select  a dropdown option by value
	 */
	public void selectByValue(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * 
	 * @param element
	 * @param text
	 * @CreationDate 23/06/2022
	 * @Description To select  a dropdown option by Visible Text
	 */
	public void selectByText(WebElement element, String text ) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @param index
	 * @CreationDate 23/06/2022
	 * @Description To select  a dropdown option by index
	 */
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @CreationDate 23/06/2022
	 * @Description To DeSelect  a dropdown option by index
	 */
	public void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 * @CreationDate 23/06/2022
	 * @Description To DeSelect  a dropdown option by value
	 */
	public void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @CreationDate 23/06/2022
	 * @Description To DeSelect  a dropdown option by index
	 */
	public void deSelectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	/**
	 * 
	 * @param element
	 * @CreationDate 23/06/2022
	 * @Description To DeSelect all the options in dropdown
	 */
	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	
	/**
	 * 
	 * @param element
	 * @CreationDate 23/06/2022 
	 * @Description To move the cursor over particular WebElement
	 */
	public void mouseOver(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * 
	 * @param element
	 * @CreationDate 25/06/2022
	 * @Description To execute right click
	 */
	public void rightclick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @throws AWTException
	 * @CreationDate 25/06/2022
	 * @Description To press enter key
	 */
	public void pressEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @CreationDate 25/06/2022
	 * @Description To get values from properties file
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
/**
 *  @CreationDate 23/06/2022
 *  @Description To close all the browser windows opened by the driver
 */
public static void closeBrowser() {
	driver.quit();
}
	
	

}
