package com.pages;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
		private WebDriver driver;
		private WebDriverWait wait;
		private By flightLink = By.linkText("Flights");
		private By departingCity = By.xpath("//button[@aria-label=\"Leaving from\"]");		
		private By arrivingCity = By.xpath("//button[@aria-label=\"Going to\"]");
		private By departingDate = By.xpath("//button[@id='d1-btn']");
		private By selectArrDate = By.xpath("//button[starts-with(@aria-label , 'Aug 12')]");
		private By selectDepDate = By.xpath("//button[starts-with(@aria-label , 'Aug 18')]");
		private By done = By.xpath("//button[contains(.,'DoneSave changes')]");
		private By searchButton = By.xpath("//button[@data-testid = \"submit-button\"]");
		private By departingCityInput = By.xpath("//input[@id='location-field-leg1-origin']");
		private By arrivingCityInput = By.xpath("//input[@id='location-field-leg1-destination']");
		
		private By listOfDepartingCities = By.xpath("//button[@data-stid='location-field-leg1-origin-result-item-button']");
		private By listOfArrivingCities = By.xpath("//button[@data-stid='location-field-leg1-destination-result-item-button']");
		
		public SearchPage(WebDriver driver) {
			this.driver = driver;
			this.wait =new WebDriverWait(this.driver, 30);
		}
		public void clickFlight() {
			driver.findElement(flightLink).click();
		}
		public void enterDepartureCity() {
			WebElement departingCityElement = driver.findElement(departingCity);
			if (departingCityElement.isDisplayed() && departingCityElement.isEnabled()) {
				departingCityElement.click();
			}
			WebElement departingInputElem = driver.findElement(departingCityInput);
			departingInputElem.sendKeys("San Francisco (SFO - San Francisco Intl.)");
			this.wait.until(ExpectedConditions.elementToBeClickable(listOfDepartingCities));
			List<WebElement> elemList = driver.findElements(listOfDepartingCities);
			elemList.get(0).click();
		}
		public void enterArrivalCity() {
			WebElement arrivingCityElement = driver.findElement(arrivingCity);
			if (arrivingCityElement.isDisplayed() && arrivingCityElement.isEnabled()) {
				arrivingCityElement.click();
			}
			WebElement arrivingInputElem = driver.findElement(arrivingCityInput);
			arrivingInputElem.sendKeys("New York (NYC - All Airports)");
			this.wait.until(ExpectedConditions.elementToBeClickable(listOfArrivingCities));
			List<WebElement> arrList = driver.findElements(listOfArrivingCities);
			arrList.get(1).click();
		}
		
		public void selectDepartingDate() {
			WebElement departingDateElement = driver.findElement(departingDate);
			departingDateElement.click();
		}
		
		public void selectArrivingDate() {
				this.wait.until(ExpectedConditions.elementToBeClickable(selectArrDate));
				WebElement arrDate = driver.findElement(selectArrDate);
				arrDate.click();
				WebElement depDate = driver.findElement(selectDepDate);
				depDate.click();		
				WebElement doneElement = driver.findElement(done);
				doneElement.click();
				driver.findElement(searchButton).click();			
		}
		
		public void clickOnSearch() {	
		     	driver.findElement(flightLink).click();
		     	WebElement departingCityElement = driver.findElement(departingCity);
				if (departingCityElement.isDisplayed() && departingCityElement.isEnabled()) {
					departingCityElement.click();
				}
				WebElement departingInputElem = driver.findElement(departingCityInput);
				departingInputElem.sendKeys("San Francisco (SFO - San Francisco Intl.)");
				this.wait.until(ExpectedConditions.elementToBeClickable(listOfDepartingCities));
				List<WebElement> elemList = driver.findElements(listOfDepartingCities);
				elemList.get(0).click();
				WebElement arrivingCityElement = driver.findElement(arrivingCity);
				if (arrivingCityElement.isDisplayed() && arrivingCityElement.isEnabled()) {
					arrivingCityElement.click();
				}
				WebElement arrivingInputElem = driver.findElement(arrivingCityInput);
				arrivingInputElem.sendKeys("New York (NYC - All Airports)");
				this.wait.until(ExpectedConditions.elementToBeClickable(listOfArrivingCities));
				List<WebElement> arrList = driver.findElements(listOfArrivingCities);
				arrList.get(1).click();
				WebElement departingDateElement = driver.findElement(departingDate);
				departingDateElement.click();
				this.wait.until(ExpectedConditions.elementToBeClickable(selectArrDate));
				WebElement arrDate = driver.findElement(selectArrDate);
				arrDate.click();
				this.wait.until(ExpectedConditions.elementToBeClickable(selectDepDate));
				WebElement depDate = driver.findElement(selectDepDate);
				depDate.click();		
				WebElement doneElement = driver.findElement(done);
				doneElement.click();
				driver.findElement(searchButton).click();
		}
		
}
