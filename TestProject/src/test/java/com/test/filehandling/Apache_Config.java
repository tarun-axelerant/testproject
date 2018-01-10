package com.test.filehandling;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
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
		

		System.setProperty("webdriver.chrome.driver", "/home/goswami/eclipse-workspace/TestProject/exe/"+"chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("http://google.com");
		
		
		config = new PropertiesConfiguration("/home/goswami/eclipse-workspace/TestProject/src/test/java/com/test/filehandling/samplefile.properties");	
		
		System.out.print(config.getString("Browser"));
	}

}
