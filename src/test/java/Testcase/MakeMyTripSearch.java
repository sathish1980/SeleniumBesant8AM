package Testcase;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.Browserlaunch;
import Pages.SearchPage;
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
		/*
		 * Select From location
		 * Select To Location
		 * Select Depature date
		 * Click on Search
		 * Verify the selected from and to location is dispalyed
		 */

		SearchPage sp = new SearchPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@for='fromCity']")));

		// Select From location
		driver.findElement(By.xpath("//*[@for='fromCity']")).click();
		// select the value from dropdown or list
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@role='listbox']//li)[1]")));
		sp.SelectTheValueFromList(driver,By.xpath("(//ul[@role='listbox']//li)"),"MAA");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@for='toCity']")));

		// Select TO location
		driver.findElement(By.xpath("//*[@for='toCity']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@role='listbox']//li)[1]")));
		sp.SelectTheValueFromList(driver,By.xpath("(//ul[@role='listbox']//li)"),"PNQ");

		//Select Depature Date
		sp.SelectValueinCalender(driver,"15");

		String fromLocation = driver.findElement(By.xpath("//input[@id='fromCity']")).getAttribute("value");
		String toLocation = driver.findElement(By.xpath("//input[@id='toCity']")).getAttribute("value");

		//Click On Search Button
		driver.findElement(By.xpath("//*[@data-cy='submit']//a")).click();

		//Wait for Ok got it popup and click on it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='fareLockInfoContainer']//button")));
		driver.findElement(By.xpath("//*[@class='fareLockInfoContainer']//button")).click();

		String actualsearchResult = driver.findElement(By.xpath("//*[@class='listingRhs']//p[contains(@class,'journey')]//span")).getText();

		//Assert.assertEquals(actualsearchResult, GetExpectedSearchResult(fromLocation,toLocation));
	}

	@Test(priority=1)
	public void ValidatesameCityError()
	{
		//SearchPage sp = new SearchPage();
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@for='toCity']")));

		// Select to location

		driver.findElement(By.xpath("//*[@for='toCity']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@role='listbox']//li)[1]")));
		//sp.SelectTheValueFromList(driver,By.xpath("(//ul[@role='listbox']//li)"),"MAA");
		String actualerror = driver.findElement(By.xpath("//*[@data-cy='sameCityError']")).getText();
		String expectederro ="From & To airports cannot be the same";
		Assert.assertEquals(actualerror, expectederro);

	}



	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}

}
