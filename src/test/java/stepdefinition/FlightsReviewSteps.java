package stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.ChooseReturningFlight;
import com.pages.FlightsReview;
import com.pages.SearchPage;
import com.pages.SearchResults;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FlightsReviewSteps {
	
	private ConfigReader configReader;
	private Properties prop;
	private WebDriver driver;
	SearchPage searchObj;
	SearchResults searchResultsObj;
	ChooseReturningFlight returningObj;
	FlightsReview flightRecviewObj;
	
	public FlightsReviewSteps() {
		// TODO Auto-generated constructor stub
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driver = DriverFactory.getDriver();
		searchObj = new SearchPage(driver);
		searchResultsObj = new SearchResults(driver);
		returningObj = new ChooseReturningFlight(driver);
		flightRecviewObj = new FlightsReview(driver);
	}
	
	@Given("I see the flight details page")
	public void i_see_the_flight_details_page() {
		driver.get(prop.getProperty("url"));
		searchObj.clickOnSearch();
		searchResultsObj.selectFlight();
		returningObj.chooseSortHighestPrice();
		returningObj.chooseReturningFlight();
		returningObj.selectContinue();
	}

	@Then("I should the see flight details as {string}")
	public void i_should_the_see_flight_details_as(String string) {
		String actualValue = flightRecviewObj.flightPriceDetails();
		assertTrue(actualValue.contains("$"));
	}

	@Then("I should the see the price as {string}")
	public void i_should_the_see_the_price_as(String string) {
		String actualValue = flightRecviewObj.flightDetails();
		assertTrue(actualValue.contains("San Francisco"));
	}

}
