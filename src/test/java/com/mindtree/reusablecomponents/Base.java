package com.mindtree.reusablecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mindtree.exception.UtilityException;
import com.mindtree.utilities.GetProperties;
import com.mindtree.utilities.ResponsiveWeb;

public class Base extends GetProperties {

	public Base() throws UtilityException, Exception {
		super();
	}

	static public WebDriver driver;

	public static WebDriver initialize() throws Exception {
		if (driver == null) {
			if (get.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + get.getProperty("path"));
				driver = new ChromeDriver(ResponsiveWeb.setDevice());
				ResponsiveWeb rwd=new ResponsiveWeb(driver);
				rwd.setDimension();
			} else if (get.getProperty("browser").equals("firefox")) {

			} else if (get.getProperty("browser").equals("IE")) {

			}
		}
		return driver;
	}
}
