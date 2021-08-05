Feature: Flight Review Feature
 Scenario: Verify the flight details shown
  Given I see the flight details page
  Then I should the see flight details as "Selected fare to San Francisco"
  And I should the see the price as "$909.91"
  