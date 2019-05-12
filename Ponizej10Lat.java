package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class Ponizej10Lat {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://www.katalon.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPonizej10Lat() throws Exception {
		selenium.open("https://lamp.ii.us.edu.pl/~mtdyd/zawody/");
		selenium.type("id=inputEmail3", "Testimie");
		selenium.type("id=inputPassword3", "Testnazwisko");
		selenium.type("id=dataU", "01-01-2010");
		selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Data urodzenia'])[1]/following::label[1]");
		selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Data urodzenia'])[1]/following::label[2]");
		selenium.click("//button[@type='button']");
		assertEquals("Brak kwalifikacji", selenium.getAlert());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
