package org.appiumdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
  @Test
  public void f() {
	  
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Mortal\\workspace\\appiumdemo\\res\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com");
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
