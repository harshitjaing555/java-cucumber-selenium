Feature: Add a book to the store
  As a user, I should able to add the book

Background: User should be able to launch url
	Given I navigate to the application UI

  Scenario Outline: I am able to add book successfully
    When I enter <title> of the book
    And I enter <price> of respective book
    And I enter <pubDate> in which book has been published
    And I select the <category> of the book
    And I submit the above details
    Then I should be able to successfully submit the details
    
  Examples:
  	|title|price|pubDate|category|
  	|demo|99|01-10-2020|none|