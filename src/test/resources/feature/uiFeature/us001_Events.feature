@UI @Login
Feature: US_001 - Events Information


  Scenario: TC_01 User is able to open Events Page
    Given User goes to Events Page
    And User verifies that Scheduled Events
    Then User verifies that Registered Events
    And User verifies that Attended Events
