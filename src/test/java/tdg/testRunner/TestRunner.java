package tdg.testRunner;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.PropFileHandler;
import io.cucumber.testng.CucumberOptions;
import tdg.task1.TestSessionInitiator;

//@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/resources/features",glue={"stepDefs"},plugin = { "pretty", "html:target/cucumber-reports"})						
public class TestRunner extends AbstractTestNGCucumberTests				
{		
	TestSessionInitiator test = new TestSessionInitiator(PropFileHandler.readProperty("browser"));

}