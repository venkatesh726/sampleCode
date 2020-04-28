package com.test.methods.TestProjectSelenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
	WebDriver driver;

	@BeforeTest
	public void setUp() {

		WebDriverManager.chromedriver().version("2.41").setup();

		driver = new ChromeDriver();

		driver.get("https://www.zoopla.co.uk");
		driver.manage().window().maximize();

	}

	@Test
	public void testValidation() {

		driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
		driver.findElement(By.id("search-input-location")).sendKeys("London");
		driver.findElement(By.id("search-submit")).click();

		List<WebElement> propertyElements = driver
				.findElements(By.xpath("//a[@class='listing-results-price text-price']"));
		List<String> propertyElementValues = new ArrayList<String>();
		System.out.println(propertyElements.size());

		String fifthElementValue = propertyElements.get(7).getText();

		System.out.println("Fifth: " + fifthElementValue);

		for (int i = 3; i < propertyElements.size(); i++) {

			propertyElementValues.add(propertyElements.get(i).getText());
		}

		System.out.println("Before sorting");

		System.out.println(propertyElementValues);

		Collections.sort(propertyElementValues, Collections.reverseOrder());

		System.out.println("After sorting");

		System.out.println(propertyElementValues);

		String xpath1 = "//*[contains(text(),'";
		String xpath2 = "')]";

		// System.out.println(driver.findElement(By.xpath(xpath1+fifthElementValue+xpath2)).getText());

		System.out.println(driver.findElement(By.linkText(fifthElementValue)).getText());

		driver.findElement(By.linkText(fifthElementValue)).click();

		System.out.println(driver.findElement(By.className("ui-agent__text")).getText());

		System.out.println(driver.findElement(By.xpath("//*[@id='dp-sticky-element']/div/div[1]/p/a")).getText());

		String agentName = driver.findElement(By.className("ui-agent__name")).getText();

		driver.findElement(By.className("ui-agent__name")).click();

		Assert.assertEquals(agentName, driver.findElement(By.xpath("//*[@id='content']/div/h1/b[1]")).getText());

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
