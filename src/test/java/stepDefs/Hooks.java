package stepDefs;

import io.cucumber.java.Scenario;
import tdg.task1.TestSessionInitiator;
import io.cucumber.java.After;

public class Hooks {
	@After
	public void afterScenario(Scenario scenario) {
//		System.out.println("In hooks");
//		System.out.println(scenario.getName());
//		System.out.println(scenario.getStatus());
		TestSessionInitiator.addBook.driver.quit();
	}
}
