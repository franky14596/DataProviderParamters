package com.amaz.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginValidation {
	
  static WebDriver driver;
  static long start;
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
	  driver.quit();
  }
  
  @BeforeMethod
  public void beforemethod() {
	 start = System.currentTimeMillis();
  }
  
  @AfterMethod
  public void aftervoid() {
	  long end = System.currentTimeMillis();
	  System.out.println("endtime:" +(end - start));
	  
  }
  @Parameters({"email"})
  @Test (priority =1)
  public void signin(String a) throws Exception {
	
	  driver.findElement(By.xpath("//span[text()='Account & Lists']")).click();
	  Thread.sleep(3000);
	  
	  WebElement email = driver.findElement(By.id("ap_email"));
	  email.sendKeys(a);
  }
  @Test (priority =2)
  public void nextpage () {
	  driver.findElement(By.id("continue")).click();
  }
  
  @Parameters({"key"})
  @Test (priority = 3)
  public void password (String a) {
	  WebElement password = driver.findElement(By.name("password"));
	  password.sendKeys(a);
	  
  }
}
