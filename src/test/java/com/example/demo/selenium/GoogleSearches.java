package com.example.demo.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleSearches {
	
	private static RemoteWebDriver driver;
	private static WebElement targ;
	private final String URL = "http://www.google.com";

	@BeforeAll
	public static void Beforall() {
		//system.property
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterAll
	public static void Afterall() {
		driver.quit();

	}

	@Test
	public void GoogleKitten() {
		
		//GIVEN: that I can access google.com
		driver.get(URL);
		
		//WHEN: I search kittens using the search bar
		targ = driver.findElement(By.name("q"));
		targ.sendKeys("Kittens");
		targ.submit();
		
		//THEN: I should get the results of kittens images
		String result = driver.getTitle();
		
		//ASSERTIONS
		assertEquals("Kittens - Google Search", result);

	}

}
