Feature: Returning flight page 
 Scenario: User clicks on Continue
  Given I choose the returning flight
  When I click on Continue
  Then I should a new window popup with title "Flight details | Orbitz"