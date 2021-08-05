package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {
	private WebDriver driver;
	
	private By sortBy = By.xpath("//select[@id = 'listings-sort']");
	private By selectFlight = By.xpath("//ul[@data-test-id=\"listings\"]//button");
	private By continueButton = By.xpath("//button[@data-test-id=\"select-button\"]");
	//private By sortBy= By.xpath("//label[@for = 'listings-sort']");
	private WebDriverWait wait; 
	
	public SearchResults(WebDriver driver) {
		this.driver = driver;
		this.wait =new WebDriverWait(this.driver, 10);
	}
	
	public void chooseSortHighestPrice() {
			this.wait.until(ExpectedConditions.presenceOfElementLocated(sortBy));
			Select drpCountry = new Select(driver.findElement(sortBy));
			drpCountry.selectByIndex(1);		
	}
	
	public void selectFirstFlight() {
			this.wait.until(ExpectedConditions.presenceOfElementLocated(selectFlight));
			List<WebElement> flightList = driver.findElements(selectFlight);
			flightList.get(0).click();
	}
	
	public void selectContinue() {
		this.wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		driver.findElement(continueButton).click();
	}
	
	public void selectFlight() {
		this.wait.until(ExpectedConditions.presenceOfElementLocated(sortBy));
		Select drpCountry = new Select(driver.findElement(sortBy));
		drpCountry.selectByIndex(1);
		//this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selectFlight, 1));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> flightList = driver.findElements(selectFlight);
		flightList.get(0).click();
		this.wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		driver.findElement(continueButton).click();
	}
	

}
