package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.factory.DriverFactory;
import com.util.ConfigReader;

public class FlightsReview {
	
    private WebDriver driver;
    private WebDriverWait wait;
	public FlightsReview(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 20);
	}
	private By flightPrice = By.xpath("//table[@class='uitk-table experimental-pricing']//span"); 
	private By flightDetails = By.xpath("//section[@class='uitk-layout-grid-item']//h2");
	
	
	public String flightPriceDetails() {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext()) {
		String child_window=I1.next();
	     	if(!parent.equals(child_window)) {
		     	driver.switchTo().window(child_window);
     		}
		}
		this.wait.until(ExpectedConditions.textToBePresentInElementLocated(flightPrice, "$"));
		WebElement flightPriceElem = driver.findElement(flightPrice);
		return flightPriceElem.getText();
	}
	
	public String flightDetails() {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext()) {
			String child_window=I1.next();
//	     	if(!parent.equals(child_window)) {
		     	driver.switchTo().window(child_window);
//			}
		}
		//this.wait.until(ExpectedConditions.elementToBeSelected(flightDetails));
		List<WebElement> flightDetailsElem = driver.findElements(flightDetails);
		return flightDetailsElem.get(0).getText();
		
	}

}
