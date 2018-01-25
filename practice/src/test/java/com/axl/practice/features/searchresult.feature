Feature: Search Result Page
  This will contain all the test cases for Search

  Scenario: Keyword Search
    Given I am on the homepage
    When I fill in "search_query" with "Printed Dress"
    And I press "submit_search"
