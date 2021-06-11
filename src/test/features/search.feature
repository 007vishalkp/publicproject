@SearchOnGoogle
Feature: Searching on google

  Background:
    Given User is on "Google search engine" page

  Scenario Outline: Searching cars in Bangalore in cardekho or carwale websites
    When User searches for the "<text>"
    Then User is shown with cardekho or carwale results
    And User checks the links for appropriate search "<text>"
    Examples:
      | text              |
      | cars in bangalore |