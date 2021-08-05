Feature: Flights search result feature
 Scenario: User sorts the flights by Price(Highest)
  Given I visit the search results for flights page
  When I select Price(Highest) from the dropdown
 
  
 Scenario: User select the first flight option
  Given I visit the search results for flights
  And I sort the flights by Price(Highest)
  When I see click on the first flight
  Then I should see "Selected fare to New York"
  
 Scenario: User clicks on Continue
  Given I click on the first flight
  When I click in Continue
  Then I should see the text "San Francisco" 
  

  
  
 