package stepDefs;

import io.cucumber.java.en.Given;		
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import tdg.task1.TestSessionInitiator;		

public class LoginStepDef {				

	@Given("I navigate to the application UI")
public void i_navigate_to() {
		TestSessionInitiator.addBook.launchURL();
}
     
    @When("I enter {word} of the book")				
    public void enterTitle(String title) throws Throwable							
    {		
    	System.out.println("step 2");					
    }		

    @When("I enter {int} of respective book")				
    public void enterPrice(int price) throws Throwable							
    {		
    	System.out.println("step 3");					
    }
    
    @When("I enter {} in which book has been published")				
    public void enterPubDate(String pubDate) throws Throwable							
    {		
    	System.out.println("step 4");					
    }
    
    @When("I select the {word} of the book")				
    public void selectCategory(String category) throws Throwable							
    {		
    	System.out.println("step 5");					
    }
    
    @When("I submit the above details")				
    public void selectContinue() throws Throwable							
    {		
    	System.out.println("step 6");					
    }

    @Then("I should be able to successfully submit the details")					
    public void verifyBookIsAdded() throws Throwable 							
    {    		
    	System.out.println("step 7");					
    }	

	@Then("Error message should be displayed")					
    public void verifyBookIsAdded(String errorMsg) throws Throwable 							
    {    		
    	System.out.println("step 8");					
    }	


}