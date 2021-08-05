package stepdefinition;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.SearchPage;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageSteps {
	private ConfigReader configReader;
	private Properties prop;
	private WebDriver driver;
	SearchPage sObj;
	public SearchPageSteps() {
		// TODO Auto-generated constructor stub
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driver = DriverFactory.getDriver();
		sObj = new SearchPage(driver);
	}
	
	@Given("I see the opened web browser")
	public void i_open_the_browser() { 
	    sObj = new SearchPage(driver);
	}

	@When("I visit the home page of the web application")
	public void i_visit_the_web_application() {
		driver.get(prop.getProperty("url"));
	}

	@Then("I should see the title of the page is {string}")
	public void i_see_the_title_of_the_page_is(String expectedValue) {
		String actualTitle = driver.getTitle();
		assertEquals(expectedValue, actualTitle);
	}
	@Given("I visit the home page")
	public void i_visit_the_home_page() {
		driver.get(prop.getProperty("url"));
	}

	@When("I click on flights tab")
	public void i_click_on_flights_tab() {
	    sObj.clickFlight();
	}

	@Then("I should see Roundtrip, One-way and Multi-city tabs")
	public void i_should_see_roundtrip_one_way_and_multi_city_tabs() {
		String text = driver.findElement(By.linkText("Roundtrip")).getText();
	    assertEquals("Roundtrip",text);
	}

	@Given("I visit the flight tab on the home page")
	public void i_visit_the_flight_tab_on_the_home_page() {
	   driver.get(prop.getProperty("url"));
	   sObj.clickFlight();
	}

	@When("I type {string} in the Leaving From field")
	public void i_type_in_the_leaving_from_field(String string) {
		sObj.enterDepartureCity();
	}

	@When("I type {string} in the Going To field")
	public void i_type_in_the_going_to_field(String string) {
		sObj.enterArrivalCity();	  
	}

	@When("I select Departing date two weeks from today")
	public void i_select_departing_date_two_weeks_from_today() {
		sObj.selectDepartingDate(); 
	}

	@When("I select Returning date three weeks from today")
	public void i_select_returning_date_three_weeks_from_today() {
	   sObj.selectArrivingDate();
	}

	@Then("I should see the title {string}")
	public void i_should_see_the_title(String string) {
	   String actualValue = driver.getTitle();
	   assertEquals(string,actualValue);
	}

}
