package Testcase;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.Browserlaunch;
import Utils.PropertyFile;
public class MakeMyTripSearch extends Browserlaunch {

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
		System.out.println("pass");
	}

	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}

}
