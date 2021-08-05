package stepdefinition;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.ChooseReturningFlight;
import com.pages.SearchPage;
import com.pages.SearchResults;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChooseReturningFlightSteps {
	private ConfigReader configReader;
	private Properties prop;
	private WebDriver driver;
	SearchPage searchObj;
	SearchResults searchResultsObj;
	ChooseReturningFlight returningObj;
	
	public ChooseReturningFlightSteps() {
		// TODO Auto-generated constructor stub
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driver = DriverFactory.getDriver();
		searchObj = new SearchPage(driver);
		searchResultsObj = new SearchResults(driver);
		returningObj = new ChooseReturningFlight(driver);
	}
	
	@Given("I choose the returning flight")
	public void i_choose_the_returning_flight() {
		driver.get(prop.getProperty("url"));
		searchObj.clickOnSearch();
		searchResultsObj.selectFlight();
		returningObj.chooseSortHighestPrice();
		returningObj.chooseReturningFlight();
	
	}
	@When("I click on Continue")
	public void i_click_on_continue() {
	     returningObj.selectContinue();
	}

	@Then("I should a new window popup with title {string}")
	public void i_should_a_new_window_popup_with_title(String string) {
	  
	}
}
