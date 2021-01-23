package tdg.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import utilities.PropFileHandler;

public class AddBook extends BasePage {

	public static By title = By.className("");
	public static By price = By.xpath("");
	public static By pubDate = By.className("");
	public static By cateory = By.className("");
	public static By add = By.className("");
	public static By bookSuccessfullyAdded = By.className("");
	public static By errorMsg = By.className("");

	public AddBook(WebDriver driver) {
		super(driver);
	}

	public void launchURL() {
		visit(PropFileHandler.readProperty("appURL"));
		Reporter.log("Launched the Application URL");
	}

	public void enterTitle(String text) {
		sendKeysOnElement(title,text);
	}
	
	public void enterPrice(String text) {
		sendKeysOnElement(price,text);
	}
	
	public void enterPubDate(String text) {
		sendKeysOnElement(pubDate,text);
	}
	
	public void selectCategory(String text) {
		selectByValueInList(cateory,text);
	}
	
	public void selectAdd() {
		clickOnElement(add);
	}
	
	public void bookIsSuccessfullyAdded(String text) {
		Assert.assertEquals(matchText(bookSuccessfullyAdded,text), true,"Book is not successfully added");
		Reporter.log("Book has been successfully added");
	}
	
	public void errorMsgIsDisplayed(String text) {
		Assert.assertEquals(matchText(bookSuccessfullyAdded,text), true,"Book is not successfully added");
		Reporter.log("Error appears on adding a book");
	}
	
	
	
	
	
}
