package stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factory.DriverFactory;
import com.pages.SearchPage;
import com.pages.SearchResults;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchResultsSteps {
	
	private ConfigReader configReader;
	private Properties prop;
	private WebDriver driver;
	SearchPage searchObj;
	SearchResults searchResultObj;
	public SearchResultsSteps() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driver = DriverFactory.getDriver();
		searchObj = new SearchPage(driver);	
		searchResultObj = new SearchResults(driver);
	}
	
	@Given("I visit the search results for flights page")
	public void i_visit_the_search_results_for_flights_page() {
		driver.get(prop.getProperty("url"));
		searchObj.clickOnSearch();
	}

	@When("I select Price\\(Highest) from the dropdown")
	public void i_select_price_highest_from_the_dropdown() {
		searchResultObj.chooseSortHighestPrice();
	}

	@Given("I visit the search results for flights")
	public void i_visit_the_search_results_for_flights() {
		driver.get(prop.getProperty("url"));
		searchObj.clickOnSearch();
	}

	@Given("I sort the flights by Price\\(Highest)")
	public void i_sort_the_flights_by_price_highest() {
		searchResultObj.chooseSortHighestPrice();
	}

	@When("I see click on the first flight")
	public void i_see_click_on_the_first_flight() {
	    searchResultObj.selectFirstFlight();
	}

	@Then("I should see {string}")
	public void i_should_see(String string) {
		String curr = driver.findElement(By.xpath("//h2[@class='uitk-heading-5']")).getText();
		assertEquals(string,curr);
	}
	
	
	@Given("I click on the first flight")
	public void i_click_on_the_first_flight() {
		driver.get(prop.getProperty("url"));
		searchObj.clickOnSearch();
		searchResultObj.chooseSortHighestPrice();
		searchResultObj.selectFirstFlight();
	}

	@When("I click in Continue")
	public void i_click_in_continue() {
	     searchResultObj.selectContinue();
	}
	@Then("I should see the text {string}")
	public void i_should_see_the_text(String string) {
		WebElement curr = driver.findElement(By.xpath("//span[contains(.,\"San Francisco\")]"));
		String actualValue = curr.getText();
		assertTrue(!actualValue.isEmpty());
	}
}
