package tdg.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import utilities.PropFileHandler;

public class AddBook extends BasePage {

	public static By heatmapDefaultThumbnail = By.className("heatmap-thumb__default-heatmap");
	public static By viewHeatmap = By.xpath("//div[contains(text(),'View heatmap')]");

	public AddBook(WebDriver driver) {
		super(driver);
	}

	public void launchURL() {
		visit(PropFileHandler.readProperty("appURL"));
		Reporter.log("Launched the Application URL");
	}

	public void launchHeatMap() {
		hoverOnElement(heatmapDefaultThumbnail);
		Assert.assertEquals(clickOnElement(viewHeatmap), true, "VWO Home page is not launched successfully");
		Reporter.log("VWO Home page has been launched successfully");
	}
}
