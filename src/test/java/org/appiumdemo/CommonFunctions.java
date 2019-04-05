package org.appiumdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import utility.Log;

public class CommonFunctions {

	static WebDriver driver = null;		//static webdriver to access it throughout the project
	public static Properties objRepo = new Properties();
	
	/*
	 * This function is used to enter text in textbox 
	 * @params ObjectLocator, text which is to be entered ,object name
	 * @applicable to mobile,web
	 */
	public boolean enterText(By objLocator, String strText, String objName) throws Exception {
		try {
			boolean result = true;
			WebElement txtboxElement = getElement(objLocator, objName);
			txtboxElement.clear();
			txtboxElement.sendKeys(strText);
			return result;

		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	/*
	 * This function is used to click on an element 
	 * @params ObjectLocator, object name
	 * @applicable to mobile,web
	 */
	public void click(By objLocator, String objName) throws Exception {
		try {
			WebElement btnElement = getElement(objLocator, objName);
			btnElement.click();
		} catch (Exception e) {
			e.getMessage();
		}

	}
	/*
	 * This method is used to get the element from the by locator
	 * @params By locator,object name
	 */
	public WebElement getElement(By objLocator, String objName) throws Exception {
		WebElement element = null;
		try {
			element = driver.findElement(objLocator);
		} catch (Exception e) {
			e.getMessage();
		}
		return element;
	}


	/*
	 * This method is used to connect to Android App through perfecto mobile cloud
	 * Give the device parameters in which you want to run the test script
	 */
	public AppiumDriver connectToPerfectoAndroidApp() throws Exception {
		try {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			String perfectoUsername=getValueFromPropertyValue("perfectoUsername");
			String perfectoPassword=getValueFromPropertyValue("perfectoPassword");
			
			capabilities.setCapability("user", "manoj_yadav11@infosys.com");
			//capabilities.setCapability("password", "ASa4uBYBe");
			capabilities.setCapability("password", "qute%Y2YR");
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("automationName", "UIAutomator1");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4D0598657C747000");
			//capabilities.setCapability("deviceName", "Galaxy Ace III");
			capabilities.setCapability(MobileCapabilityType.VERSION, "4.2.2");
			//capabilities.setCapability(MobileCapabilityType.APP,"PRIVATE:ebay_oldest.apk" );
			capabilities.setCapability("appPackage","com.android.vending" );

			String host = "mobilecloud.perfectomobile.com";
			String  url = "https://" + host + "/nexperience/perfectomobile/wd/hub";

			driver = new AndroidDriver(new URL(url), capabilities);
			System.out.println(driver);

			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (AppiumDriver)driver;
	}
	
	/*
	 * This method is used to get the property value corresponding to the locator name provided from the properties file
	 * @params Name of the locator corresponding to which the value is to be fetched
	 */
	public String getValueFromPropertyValue (String locatorName){
		try{
			System.out.println(System.getProperty("user.dir")+"\\Config.properties");
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
			objRepo.load(objfile);
			String locatorProperty = objRepo.getProperty(locatorName);
			return locatorProperty;
		}
		catch (Exception e){
			return e.getMessage();
			
		}
		
	}

	/*
	 * This message is used to get the locator from properties file 
	 * @params the locator name for which the value is to be fetched
	 */
	public By getObjectLocatorFromPropertiesFile(String locatorName) throws IOException {
		By locator = null;
		try{
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\pageObjects\\pageObject.properties");
		objRepo.load(objfile);

		String locatorProperty = objRepo.getProperty(locatorName);
		System.out.println(locatorProperty.toString());

		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];

		
		switch (locatorType) {
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		System.out.println(locator);
		}
		catch(Exception e){
			e.getMessage();
		}
		return locator;
	}
	
	/**
     * This method is used for explicit wait to explicitly wait for a particular element until that element is visible,invisible,presence,frame,clickable
     * @return void
     */
	public void explicitWait(By obj,int maxTimeOut , String strConditionMode) throws Exception

    {
			try{
					String mode = strConditionMode.toUpperCase();                   

                                    switch (mode) {

                                    case "VISIBILITY":
                                    	(new WebDriverWait(driver, maxTimeOut)).until(ExpectedConditions.visibilityOfElementLocated(obj));      
                                         break;
                                    case "INVISIBILITY":
                                    	(new WebDriverWait(driver, maxTimeOut)).until(ExpectedConditions.invisibilityOfElementLocated(obj));
                                    	break;
                                    case "PRESENCE":
                                    	(new WebDriverWait(driver, maxTimeOut))
                                    	.until(ExpectedConditions.presenceOfElementLocated(obj));
                                    	break;  
                                    case "FRAME":
                                    	(new WebDriverWait(driver, maxTimeOut))
                                    	.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(obj));
                                    	break;
                                    case "CLICKABLE":
                                    	(new WebDriverWait(driver, maxTimeOut))
                                    	.until(ExpectedConditions.elementToBeClickable(obj));       
                                    	break;

                                    default:
                                    	break;



                                    }                                                             

                    }

                    catch(Exception e){

                                    e.getMessage();

                    }



    }
	
	/**
     * This method is to swipe Up
     * @applicableTo  Mobile
     * @driversBase Appium
     * @return void
     */
	public void swipeUp(){
		try
		{
			AndroidDriver driverA = (AndroidDriver)driver;
			Dimension pageSize = driverA.manage().window().getSize();
			System.out.println(pageSize);
			int starty = (int) (pageSize.height* 0.8);
			int endy = (int) (pageSize.height * 0.4);
			int startx = (int) (pageSize.width *0.2);

			TouchAction swipeDown = new TouchAction(driverA);

//                                    swipeDown.press(startx, starty).moveTo(startx,endy).release();
			PointOption point1 = PointOption.point(startx, starty);
			PointOption point2 = PointOption.point(startx,endy);
			swipeDown.press(point1).moveTo(point2).release();
			(driverA).performTouchAction(swipeDown);

			Log.info("Swiped Up Successfully");
		}

        catch (Exception e){

             e.getMessage();           

        }



}
	

}
