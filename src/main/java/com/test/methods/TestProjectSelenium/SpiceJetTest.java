package com.test.methods.TestProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetTest {
	
	WebDriver driver;
	int i=1;
	
	@BeforeTest
	public void setUp()
	{
		
		WebDriverManager.chromedriver().version("2.41").setup();
    	
		driver = new ChromeDriver();
       	driver.get("https://www.spicejet.com");
    	driver.manage().window().maximize();
    	
		
	}
	
   @Test
	public void Test1() throws Throwable{
       
    	driver.findElement(By.id("divpaxinfo")).click();
    	Thread.sleep(2000L);
    	
    	
    	while(i<5){
    		driver.findElement(By.id("hrefIncAdt")).click();
    	i++;
    	}
    	
    	driver.findElement(By.id("btnclosepaxoption")).click();
	}
   
   @Test
   public void Test2()
   {
	   driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	   driver.findElement(By.xpath("//a[@value='MAA']")).click();
	   driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
   }

}
