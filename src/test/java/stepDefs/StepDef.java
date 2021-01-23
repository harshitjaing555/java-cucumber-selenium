package stepDefs;

import io.cucumber.java.en.Given;		
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import tdg.task1.TestSessionInitiator;		

public class StepDef {				

	@Given("I navigate to the application UI")
public void i_navigate_to() {
		TestSessionInitiator.addBook.launchURL();
}
     
    @When("I enter {word} of the book")				
    public void enterTitle(String title) throws Throwable							
    {		
    	TestSessionInitiator.addBook.enterTitle(title);				
    }		

    @When("I enter {int} of respective book")				
    public void enterPrice(String price) throws Throwable							
    {		
    	TestSessionInitiator.addBook.enterPrice(price);		
    }
    
    @When("I enter {} in which book has been published")				
    public void enterPubDate(String pubDate) throws Throwable							
    {		
    	TestSessionInitiator.addBook.enterPubDate(pubDate);				
    }
    
    @When("I select the {word} of the book")				
    public void selectCategory(String category) throws Throwable							
    {		
    	TestSessionInitiator.addBook.selectCategory(category);			
    }
    
    @When("I submit the above details")				
    public void selectAdd() throws Throwable							
    {		
    	TestSessionInitiator.addBook.selectAdd();				
    }

    @Then("I should be able to successfully submit the details")					
    public void verifyBookIsAdded(String msg) throws Throwable 							
    {    		
    	TestSessionInitiator.addBook.bookIsSuccessfullyAdded(msg);
    }	

	@Then("Error message should be displayed")					
    public void verifyErrorMsg(String errorMsg) throws Throwable 							
    {    		
		TestSessionInitiator.addBook.errorMsgIsDisplayed(errorMsg);				
    }	


}