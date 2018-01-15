package com.axl.practice.stepdefintions;

import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.axl.practice.base.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberContext extends TestBase
{
	@Before
	public void bef()
	{
		TestBase.openBrowser();
	}
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable 
	{
		driver.get("http://automationpractice.com/index.php");
	}

	@When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_fill_in_with(String locator, String value) throws Throwable 
	{
		TestBase.getElementType(locator).sendKeys(value);
	  
	}

	@When("^I press \"([^\"]*)\"$")
	public void i_press(String locator) throws Throwable 
	{
		TestBase.getElementType(locator).click();
	}
	

	@Then("^I hover over the element \"([^\"]*)\"$")
	public void i_hover_over_the_element(String locator) throws Throwable 
	{
			 
        Actions action = new Actions(driver);
 
        action.moveToElement(TestBase.getElementType(locator)).build().perform();
	}
	
	@When("^I follow \"([^\"]*)\"$")
	public void i_follow(String locator) throws Throwable 
	{
		driver.findElement(By.linkText(locator)).click();
	}

	
	@When("^I wait for Ajax to load$")
	public void i_wait_for_Ajax_to_load() throws Throwable 
	{
		
		
		 WebDriverWait wait = new WebDriverWait(driver, 30);

		    // wait for jQuery to load
		    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver driver) {
		        try {
		          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
		        }
		        catch (Exception e) {
		          // no jQuery present
		          return true;
		        }
		      }
		    };

		  

		  wait.until(jQueryLoad);
	
	}
	
	@When("^I wait for JavaScript to load$")
	public void i_wait_for_JavaScript_to_load() throws Throwable 
	{
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 
		// wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };
	    
	    wait.until(jsLoad);
	    
	    
	}

	@Then("^I Wait for \"([^\"]*)\" milliseconds$")
	public void i_Wait_for_milliseconds(String time) throws Throwable 
	{
	 Thread.sleep(Integer.parseInt(time));   
	}
	
	@After
	public void Aft()
	{
		driver.quit();
	}

}
