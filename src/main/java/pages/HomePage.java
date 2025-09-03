package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By searchBox = By.id("gh-ac");
	private final By searchButton = By.id("gh-search-btn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open(String url) {
        driver.get(url);
        return this;
    }

    public void search(String term) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(term);
        driver.findElement(searchButton).click();
    }
}
