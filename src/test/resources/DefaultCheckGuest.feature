Feature: This feature is to check the default no of guests of the application

  Scenario: DefaultGuestCheck

    Given Application is launched with all required desired capabilities
    And User clicks on arrow button of MyTrips Screen
    And User clicks on arrow button of WishList Screen
    And User clicks on arrow button of Explore Screen
    And User clicks on done  button of HostelSpeak Screen
    Then Search screen is displayed
    When User checks the default guest
    Then User verifies that default guest number is displayed as "2"
