package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
		//public WebDriver driver;
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		
		/**
		 * add comments
		 **/
		public WebDriver init_driver(String browser) {
			System.out.println("browser value is " + browser);
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver()); 
			}
			return getDriver();
		}
		
		/**
		 * add comments
		 * @return
		 */
		public static synchronized WebDriver getDriver() {
			return tlDriver.get(); 
		}
		
}
