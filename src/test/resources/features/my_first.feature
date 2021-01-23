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
    """
    Success message
    """
    
  Examples:
  	|title|price|pubDate|category|
  	|demo|99|01-23-2020|none|
	
	Scenario: An appropriate error message should be displayed if users submit without filling the mandatory fields
    When I enter DemoBook of the book
    And I submit the above details
	Then Error message should be displayed
	"""
	Error Message
	"""
	
	Scenario Outline: An error message should be displayed if Publish Date is greator then the current date
	When I enter <title> of the book
    And I enter <price> of respective book
    And I enter <pubDate> in which book has been published
    And I select the <category> of the book
    And I submit the above details
    Then Error message should be displayed
	"""
	Pub Date can't be greater then the current date
	"""
	
	Examples:
  	|title|price|pubDate|category|
  	|demo|99|01-23-2022|none|
	