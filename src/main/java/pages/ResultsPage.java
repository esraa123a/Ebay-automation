package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	private final WebDriver driver;
	private final By resultsUl = By.cssSelector("ul.srp-results");
	private final By heading = By.cssSelector("h1.srp-controls__count-heading");
	private final By manualFilter = By.xpath("//*[@id='x-refine__group_1__0']/ul/li[1]//a");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getResultsCount() {
		String text = driver.findElement(heading).getText();
		return Integer.parseInt(text.split(" ")[0].replaceAll("\\D", ""));
	}

	public void applyManualFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(manualFilter)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(resultsUl));
	}
}
