Feature: Search page feature
  Scenario: Go to home page of the website
    Given I see the opened web browser
    When I visit the home page of the web application
    Then I should see the title of the page is "Orbitz Hotel Deals, Flights, Cheap Vacations & Rental Cars"
    
   Scenario: Go to flights tab
    Given I visit the home page
    When I click on flights tab 
    Then I should see Roundtrip, One-way and Multi-city tabs 
    
   Scenario: Search for a flight
    Given I visit the flight tab on the home page
    When I type "San Francisco" in the Leaving From field
    And  I type "New York" in the Going To field
    And I select Departing date two weeks from today
    And I select Returning date three weeks from today
    Then I should see the title "SFO to JFK flights" 