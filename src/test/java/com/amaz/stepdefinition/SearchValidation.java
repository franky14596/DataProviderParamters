package com.amaz.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchValidation {
	 static WebDriver driver;
	  static long start;
	  
	  @DataProvider(name="mobilename")
	  public Object [][] getmobilename(){
		return new Object[][] {{"oneplus"}};
		  
	  }
	  
	  @BeforeClass
	  public static void beforeclass() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://www.amazon.in/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	  }
	  @AfterClass
	  public static void afterclass() {
		// driver.quit();
	  }
	  
	  @BeforeMethod
	  public void beforemethod() {
		  start = System.currentTimeMillis();
		 
	  }
	  
	  @AfterMethod
	  public void aftervoid() {
		   long end = System.currentTimeMillis();
		  System.out.println("TimeTaken:" +( end - start));
}
	  
	  @Test(priority =1,dataProvider = "mobilename")
	  public void search(String a) throws Exception {
		  WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
	     searchbar.sendKeys(a);
	     
	     Robot r = new Robot();
	     for (int i = 0; i < 7; i++) {
	    	 r.keyPress(KeyEvent.VK_DOWN);
	    	 r.keyRelease(KeyEvent.VK_DOWN);		
		}
	     r.keyPress(KeyEvent.VK_ENTER);
    	 r.keyRelease(KeyEvent.VK_ENTER);
	     
	  }
}
