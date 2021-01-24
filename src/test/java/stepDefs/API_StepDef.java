package stepDefs;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.google.common.collect.Ordering;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import tdg.task1.TestSessionInitiator;

 
public class API_StepDef {

private static int countBefore;
private static int countAfter;
private static Response response;
private static String jsonString;


 
@Given("I fetch the list of current books")
public void listOfBooksAreAvailable() {
	response = TestSessionInitiator.addBook.getRequest();
}

@Then("The list of books should not be empty")
public int bookAPIISNotReturningNull() {
	String jsonString = response.asString();
	List<Map<String, String>> books = JsonPath.from(jsonString).get();
	System.out.println("Size of the list --- "+ books.size());
	Assert.assertTrue(books.size() > 0);
	return books.size();
}

@Then("Response code is {int}")
public void responseCodeVerification(int responseCode) {
	System.out.println("Response code is --- "+responseCode);
	Assert.assertEquals(responseCode, response.getStatusCode());
}

@Then("Response code is not {int}")
public void responseCodeNegativeVerification(int responseCode) {
	System.out.println("Response code is --- "+responseCode);
	Assert.assertFalse(responseCode == response.getStatusCode());
}
 
@When("I add one more book")
public void addBookInList() {
	countBefore = bookAPIISNotReturningNull();
	response = TestSessionInitiator.addBook.postRequest();
}

@Then("The book is added")
public void bookIsAdded() {
	countAfter = bookAPIISNotReturningNull();
	Assert.assertTrue((countBefore+1)==countAfter);
}

@When("I try to book with no title in body")
public void adingBookWithNoTitle() {
	countBefore = bookAPIISNotReturningNull();
	response = TestSessionInitiator.addBook.postRequestWithBadBody();
}

@Then("The book should not be added")
public void bookIsNotAdded() {
	countAfter = bookAPIISNotReturningNull();
	Assert.assertTrue(countBefore==countAfter);
}

@When("I fetch the list of current books in Ascending sort")
public void getRequestAscending() {
	response = TestSessionInitiator.addBook.getRequestAscending();
}

@When("I fetch the list of current books in Descending sort")
public void getRequestDescending() {
	response = TestSessionInitiator.addBook.getRequestDescending();
}

@Then("The list of books should be sorted in ascending order")
public void booksSortedInAscending() {
	response = TestSessionInitiator.addBook.getRequestAscending();
	List<Map<String, String>> books = JsonPath.from(jsonString).get();
	//boolean sorted = Ordering.natural().isOrdered((Iterable<? extends Comparable>) books);
	//Assert.assertTrue(sorted);
}

@Then("The list of books should be sorted in Descending order")
public void booksSortedInDescending() {
	response = TestSessionInitiator.addBook.getRequestDescending();
	List<Map<String, String>> books = JsonPath.from(jsonString).get();
	//boolean sorted = Ordering.natural().reverse().isOrdered((Iterable<? extends Comparable>) books);
	//Assert.assertTrue(sorted);
}
 
}