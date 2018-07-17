package com.atmecs.htg.implementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class TestSample {
	
	WebDriver driver;
	
	@Test(enabled=false)
	public void launchBrowser() throws Exception{
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Google");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
	}
	
	@DataProvider(name="PostServiceData")
	public static Object[][] sendPostServiceData(){
		return new Object[][] {{"GTM","GTM","GTM"},{"VISA","VISA","VISA"}};
	}
	
	@Test(priority=0)
	public void test(){
		
		int status = 
		given().
		get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		statusCode();
		
		System.out.println(status);
		
		RequestSpecification req_spec=given();
		Response res=req_spec.get("http://110.110.112.231:8000/users");
		System.out.println(res.statusCode());
    	//System.out.println(res.getHeaders());
		System.out.println(res.asString());
		System.out.println(res.getBody().asString());
	}
	
	
	@Test(priority=1,dataProvider="PostServiceData")
	public void postService(String uname,String pwd,String otp){
		//driver.get("http://110.110.112.231:8000/user/add");
		System.out.println(uname);
	}

}
