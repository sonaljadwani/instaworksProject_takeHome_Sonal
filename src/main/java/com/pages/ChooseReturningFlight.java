package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseReturningFlight {
	private WebDriver driver;
	private WebDriverWait wait;
	private By sortBy = By.xpath("//select[@id = 'listings-sort']");
	private By selectFlight = By.xpath("//ul[@data-test-id=\"listings\"]//button");
	//private By continueButton = By.xpath("//button[@data-test-id=\"select-button\"]");
	private By continueButton = By.xpath("//button[starts-with(@aria-label , 'Continue')]");
	private By noThanks = By.xpath("//a[@aria-label='No thanks. Opens in a new tab']");

	
	public ChooseReturningFlight(WebDriver driver) {
		this.driver = driver;	
		this.wait = new WebDriverWait(this.driver, 30);
		
	}
	
	public void chooseSortHighestPrice() {
			Select drpCountry = new Select(driver.findElement(sortBy));
			drpCountry.selectByIndex(1);
	}
	
	public void chooseReturningFlight() {
			//this.wait.until(ExpectedConditions.elementToBeClickable(selectFlight));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> flightList = driver.findElements(selectFlight);
			flightList.get(0).click();
	}
	
	public void selectContinue() {
		this.wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		driver.findElement(continueButton).click();
		driver.findElement(noThanks).click();
	}
	

}
