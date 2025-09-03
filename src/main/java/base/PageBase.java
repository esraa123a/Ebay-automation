package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
	protected final WebDriver driver;
	protected final WebDriverWait wait;

	protected PageBase(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	protected WebElement visible(By loc) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}


}
