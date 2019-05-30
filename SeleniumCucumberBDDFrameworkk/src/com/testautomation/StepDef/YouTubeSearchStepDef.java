package com.testautomation.StepDef;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YouTubeSearchStepDef {
	
	
	public static WebDriver driver;
	
	PropertiesFileReader obj = new PropertiesFileReader();
	
	@Given("^Open Chrome Browser and enter url$")
	
	public void open_chrome_browser_and_enter_url() throws Throwable{
		
		Properties properties = obj.getProperty();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Divya\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(properties.getProperty("browser.baseURL"));
		
		Thread.sleep(1000);
		
	}
	
	@When("^Enter search criteria$")
	
	public void enter_search_criteria() throws Throwable{
		
		
		driver.findElement(By.id("search")).sendKeys("arijit singh songs");
		Thread.sleep(1000);
			
	}
   @Then("^Click on search button$")
   
   public void click_on_search_button() throws Throwable{
	
	  driver.findElement(By.cssSelector("#search-icon-legacy")).click();	  
	  Thread.sleep(1000);
	  
	 driver.quit();
	   
	   
   }
   
}



 