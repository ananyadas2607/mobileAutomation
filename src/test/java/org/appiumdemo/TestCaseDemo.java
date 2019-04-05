package org.appiumdemo;

import org.testng.annotations.Test;

import utility.ExcelUtils;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestCaseDemo {
  
  @Test
  public void buyproductfromEbay() throws MalformedURLException {
	  
	  CommonFunctions obj1= new CommonFunctions();
	  TestCase_Action obj2=new TestCase_Action();
	  
  	try{
  			DOMConfigurator.configure("log4j.xml");
  		
  			obj1.connectToPerfectoAndroidApp();//Connect to android device specified through perfecto
  			
  			obj2.searchForEbayInPlayStore();//Search for an app in play store
  			
  			obj2.installAppfromAppStore();//Install the app from Play store
  			
  			//SetExcel Sheet Location
  			ExcelUtils.setExcelFile();
  			
  			//Get the data from Excel Sheet
  			String dataToSearch=ExcelUtils.getCellData(2, 4);
  			obj2.SearchInEbay(dataToSearch);//Search in Ebay App the desired product 
  			
  			obj1.swipeUp();//Swipe up the screen 
  			
  			obj2.AddToCart();//add to cart the product which you wish to buy
  			
  			obj2.SignInIntoEbay();//Sign in to ebay using valid credentials
  			
  			obj2.buyItNow();//Click on buy it now
  		}
  	
  	catch(Exception e){
  		
  		System.out.println(e.getMessage());
  	}
      
    
  }
  

}
