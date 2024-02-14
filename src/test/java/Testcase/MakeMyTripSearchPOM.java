package Testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.Browserlaunch;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utils.PropertyFile;

public class MakeMyTripSearchPOM extends Browserlaunch {

	String testCaseName =null;
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

	@BeforeMethod
	public void Report(Method method)
	{
		StartReports(method.getName());
		testCaseName = method.getName();
	}

	@AfterMethod
	public void Report(ITestResult result) throws IOException
	{
		SearchPage sp = new SearchPage(driver);
		String screenShotPath = sp.GetScreenShot(driver,testCaseName);

		if(result.getStatus()==0)
		{

			test.log(LogStatus.INFO, test.addBase64ScreenShot(screenShotPath));
			test.log(LogStatus.FAIL,"Testcase Failed");
		}
		else if(result.getStatus()==1)
		{
			test.log(LogStatus.INFO, test.addBase64ScreenShot(screenShotPath));

			test.log(LogStatus.PASS,"Testcase Passed");
		}
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
		sp.WaitForAdsAndclickIntoIt(driver);
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
		test.log(LogStatus.INFO, "Search with Valid Values are mathced");
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
		test.log(LogStatus.INFO, "Selected to location");

		sp.SelectTheValueFromList("MAA");
		test.log(LogStatus.INFO, "Selected MAA");
		Assert.assertEquals(sp.RetriveAnSameCityError(), sp.GetExpectedSameCityError());
		test.log(LogStatus.INFO, "Search with same city Error is validated");

	}
	@AfterSuite
	public void teardown()
	{
		driver.quit();
		closeReport();
	}

}
