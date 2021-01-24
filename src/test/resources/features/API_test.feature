Feature: Add a book to the store
  I try to add book via API
  
  Scenario: User is able to fetch the list of already added books
  When I fetch the list of current books
  Then Response code is 200
  And The list of books should not be empty
  
  Scenario: Adding book via API
  Given I fetch the list of current books
  When I add one more book
  Then The book is added
  
  Scenario: User tries to add book with no title in body
  Given I fetch the list of current books
  When I try to book with no title in body
  Then The book should not be added
  And Response code is not 200
  
  Scenario: Adding the same book with new price
  Given I fetch the list of current books
  When I add one more book
  Then The book is added
  
  Scenario: User tries to fetch the books in Ascending sort
  When I fetch the list of current books in Ascending sort
  Then Response code is 200
  And The list of books should be sorted in ascending order
  
  Scenario: User tries to fetch the books in Descending sort
  When I fetch the list of current books in Descending sort
  Then Response code is 200
  And The list of books should be sorted in Descending order
  
  
  
  
   


	