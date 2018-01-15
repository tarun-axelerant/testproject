Feature: Cart

  Scenario: Add From Search Result Page & Remove From Cart Modal
    Given I am on the homepage
    When I fill in "search_query" with "Printed Dress"
    And I press "submit_search"
    Then I hover over the element "(//div[@class='product-container'])[1]"
    When I follow "Add to cart"
    And I wait for Ajax to load
    And I press "//span[@class='cross']"
    Then I hover over the element "//a[@title='View my shopping cart']"
    And I press "//span[@class='remove_link']"
    And I Wait for "5000" milliseconds
