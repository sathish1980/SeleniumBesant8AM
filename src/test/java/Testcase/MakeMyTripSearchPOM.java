package Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.Browserlaunch;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utils.PropertyFile;

public class MakeMyTripSearchPOM extends Browserlaunch {

	@BeforeSuite
	public void lauchBrowser() throws IOException
	{
		Launch();
	}

	@BeforeTest
	public void EnterUrlAndMaximize() throws IOException
	{
		driver.get(PropertyFile.GetProperty().getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public void ValidSearch()
	{
		/*
		 * Select From location
		 * Select To Location
		 * Select Depature date
		 * Click on Search
		 * Verify the selected from and to location is dispalyed
		 */

		SearchPage sp = new SearchPage(driver);
		// Select From Location
		sp.ClickOnFromLocation();
		sp.SelectTheValueFromList("MAA");
		//Select To Location
		sp.ClickOnToLocation();
		sp.SelectTheValueFromList("PNQ");
		//Select DepatureDate
		sp.SelectValueinCalender("25");
		String expected =sp.GetExpectedSearchResult();
		//clickOnSearchButton
		sp.ClickOnSearchButton();
		// Wait until the popup exit
		SearchResultPage srp = new SearchResultPage(driver);
		srp.WaitAndClickOnOKGOTITPopup();
		String actual =srp.GetSearchResultText();
		Assert.assertEquals(expected, actual);
		sp.ClickOnBrowserBackButton(driver);
	}


	@Test(priority=1)
	public void ValidatesameCityError()
	{
		/*
		 * Select the TO location as same as From location
		 * Validate the error
		 */

		SearchPage sp = new SearchPage(driver);
		sp.ClickOnToLocation();
		sp.SelectTheValueFromList("MAA");
		Assert.assertEquals(sp.RetriveAnSameCityError(), sp.GetExpectedSameCityError());

	}
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}

}
