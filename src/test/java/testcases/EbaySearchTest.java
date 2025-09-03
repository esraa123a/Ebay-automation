package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.ResultsPage;
import utils.TestDataLoader;

@Epic("eBay")
@Feature("Search & Filter")
public class EbaySearchTest extends TestBase {

	@DataProvider(name = "ebayData")
	public Object[][] data() throws Exception {
		JsonNode data = TestDataLoader.loadJson("testDataFiles/search.json");
		return new Object[][] { { data.get("baseUrl").asText(), data.get("searchTerm").asText(),
				data.get("filterSection").asText(), data.get("filterValue").asText() } };
	}

	@Test(dataProvider = "ebayData", description = "Search Mazda MX-5 and filter Transmission Manual")
	@Severity(SeverityLevel.CRITICAL)
	public void search_filter_count(String baseUrl, String searchTerm, String filterSection, String filterValue) {
		HomePage home = new HomePage(driver).open(baseUrl);
		ResultsPage results = new ResultsPage(driver);

		home.search(searchTerm);
		int before = results.getResultsCount();
		System.out.println("Initial results count:" + before);
		Allure.step("Initial results count: " + before);

		results.applyManualFilter();
		int after = results.getResultsCount();
		System.out.println("Filtered results count:" + after);		
		Allure.step("Filtered results count: " + after);

		Assert.assertTrue(after <= before, "Filtered results should not increase");
	}
}
