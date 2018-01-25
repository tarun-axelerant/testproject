package com.axl.practice.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public static WebDriver driver;
	
	public static void openBrowser()
	{
		String browser = "Chrome";
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_EXE);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("Firefox"))
		{
			
		}
		else if(browser.equals("IE"))
		{
			
		}
			
	}
	
	public static WebElement getElementType(String locator)
	{
		WebElement element;
		
		String pageSource = driver.getPageSource();
		
		if(pageSource.contains("id=\""+locator +"\""))
            element = driver.findElement(By.id(locator));
        else if(pageSource.contains("name=\""+locator +"\""))
            element = driver.findElement(By.name(locator));
        else if(locator.contains("@"))
            element = driver.findElement(By.xpath(locator));
        else
            element = driver.findElement(By.cssSelector(locator));

		return element;
		
	}
}
