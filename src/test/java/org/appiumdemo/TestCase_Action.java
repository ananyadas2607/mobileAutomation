package org.appiumdemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;

public class TestCase_Action {
	
	CommonFunctions obj1= new CommonFunctions();
	
	/*
	 * Searches for Ebay app in play Store
	 */
	public void searchForEbayInPlayStore() throws Exception
	{
		try
		{
			By searchforEbay=obj1.getObjectLocatorFromPropertiesFile("searchforEbayinPlayStore");
			obj1.click(searchforEbay, "Search for Ebay");
			
			Thread.sleep(5000);
			
			WebElement searchforEbayEle=obj1.getElement(searchforEbay, "Element for search for ebay");
			searchforEbayEle.sendKeys("ebay");
			
			Thread.sleep(5000);
			
			searchforEbayEle.sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			
			Log.info("Successfully searched for ebay App in play store");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	/*
	 * Installs the ebay app from Play Store in Android mobile
	 */
	public void installAppfromAppStore() throws Exception
	{
		try {
			By installfromPlayStore=obj1.getObjectLocatorFromPropertiesFile("installfromPlayStore");
			obj1.click(installfromPlayStore, "install from play store");
			
			By acceptAgreementfromPlayStore=obj1.getObjectLocatorFromPropertiesFile("acceptAgreementfromPlayStore");
			obj1.explicitWait(acceptAgreementfromPlayStore, 10, "VISIBILITY");
			obj1.click(acceptAgreementfromPlayStore, "accept in play store");
			
			By openAppfromPlayStore=obj1.getObjectLocatorFromPropertiesFile("openAppfromPlayStore");
			obj1.explicitWait(openAppfromPlayStore, 10, "VISIBILITY");
			obj1.click(openAppfromPlayStore, "open from Play STore");
			
			By getStartedfromPlayStore=obj1.getObjectLocatorFromPropertiesFile("getStartedfromPlayStore");
			obj1.click(getStartedfromPlayStore, "get started from play store");
			
			Log.info("App downloaded from play store and installed in the device");
		} 
		catch (IOException e) {
			
			e.getMessage();
		}
	}
	
	/*
	 * search for the particular product which you want to search from the search bar
	 */
	public void SearchInEbay(String dataToSearch) throws Exception
	{
		try {
		By searchInEbay=obj1.getObjectLocatorFromPropertiesFile("searchInEbay");
		
		WebElement search=obj1.getElement(searchInEbay, "SearchInEbay");
		
		search.sendKeys(dataToSearch);
		
		Thread.sleep(10000);
		
		search.sendKeys(Keys.ENTER);
		
		Log.info("Searched for a particular product in Ebay");
		
		} 
		catch (IOException e) {
			
			e.getMessage();
		}
	}
	
	/*
	 * the product which is searched is added to cart if bought
	 */
	public void AddToCart() throws Exception
	{
		try {
		By searchResult=obj1.getObjectLocatorFromPropertiesFile("searchResult");
		
		
		obj1.click(searchResult, "Click on search result");
		
		
		Thread.sleep(10000);
		
		By addToCart=obj1.getObjectLocatorFromPropertiesFile("addToCart");
		obj1.click(addToCart, "Click on add to cart");
		
		Thread.sleep(3000);
		
		Log.info("Product successfully added to cart");
		} 
		catch (IOException e) {
			
			e.getMessage();
		}
	}
	
	/*
	 * Sign in to Ebay using valid credentials
	 * We get the username and password from the excel sheet
	 * And click on sign in button to sign in to your account
	 */
	public void SignInIntoEbay() throws Exception
	{
		try {
		By signInUsername=obj1.getObjectLocatorFromPropertiesFile("signInUsername");
		WebElement signIn=obj1.getElement(signInUsername, "SearchInEbay");
		ExcelUtils.setExcelFile();
			
		//Get the data from Excel Sheet
		String username=ExcelUtils.getCellData(2, 2);
		signIn.sendKeys(username);
		
		By signInPassword=obj1.getObjectLocatorFromPropertiesFile("signInPassword");
		WebElement signInPasswordEle=obj1.getElement(signInPassword, "SignInPassword");
		
		String password=ExcelUtils.getCellData(2, 3);
		signIn.sendKeys(password);
		signInPasswordEle.sendKeys(password);
		
		By signInButton=obj1.getObjectLocatorFromPropertiesFile("signInButton");
		obj1.click(signInButton, "SignInButton");
		
		Thread.sleep(5000);
		
		Log.info("Successfully signed into Ebay");
		}
		catch (IOException e) {
			
			e.getMessage();
		}
	}
	public void buyItNow() throws Exception
	{
		try{
			By buyItNowbtn=obj1.getObjectLocatorFromPropertiesFile("buyItNowbtn");
			obj1.click(buyItNowbtn, "BuyItNow");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
}
