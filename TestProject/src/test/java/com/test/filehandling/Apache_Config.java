package com.test.filehandling;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Apache_Config 
{
	
	public PropertiesConfiguration config;
	 public static WebDriver driver;
	
	@Test
	public void readApacheConfig() throws ConfigurationException
	{
		

		System.setProperty("webdriver.chrome.driver", "/home/goswami/git/TestProject/exe/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		
		String locator = "//input[@id=\"search_query_top\"]";
		String value = "xyz";
		fillField(locator, value);

		
		
	}
	
	public void fillField(String locator, String value)
	{
		String pageSource = driver.getPageSource();
		
		if(pageSource.contains("id=\""+locator +"\""))
			driver.findElement(By.id(locator)).sendKeys(value);
		else if(pageSource.contains("name=\""+locator +"\""))
			driver.findElement(By.name(locator)).sendKeys(value);
		else if(locator.contains("@"))
			driver.findElement(By.xpath(locator)).sendKeys(value);
		else
			driver.findElement(By.cssSelector(locator)).sendKeys(value);
	}

}
