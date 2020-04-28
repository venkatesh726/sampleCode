package com.test.methods.TestProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveTest {
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		
		WebDriverManager.chromedriver().version("2.41").setup();
    	
		driver = new ChromeDriver();
    	
    	driver.get("https://www.makemytrip.com");
    	driver.manage().window().maximize();
    	
		
	}
	

@Test
public void Test3() throws Throwable{
	
	WebElement source=driver.findElement(By.id("fromCity"));
	
	source.clear();
	source.sendKeys("DEL");
	source.sendKeys(Keys.ENTER);
   
	}


}
