Feature: This feature is to implement the search functionality in the app

  Scenario: To search the availabilities of hotels in the app
    Given Application is launched with all required desired capabilities
    And User clicks on arrow button of MyTrips Screen
    And User clicks on arrow button of WishList Screen
    And User clicks on arrow button of Explore Screen
    And User clicks on done  button of HostelSpeak Screen
    Then Search screen is displayed
    When User searches for a particular city
    Then Search results are displayed
