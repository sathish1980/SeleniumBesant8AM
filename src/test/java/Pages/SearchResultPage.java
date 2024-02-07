package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ElementUtils.CommonElements;

public class SearchResultPage  extends CommonElements{

	WebDriver driver;

	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void WaitAndClickOnOKGOTITPopup()
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[@class='fareLockInfoContainer']//button"),60);

		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='fareLockInfoContainer']//button")));
		WebElement popup = driver.findElement(By.xpath("//*[@class='fareLockInfoContainer']//button"));
		ClickOnButton(popup);

	}

	public String GetSearchResultText()
	{
		WebElement textElement = driver.findElement(By.xpath("//*[@class='listingRhs']//p[contains(@class,'journey')]//span"));
		return GetTextOfelement(textElement);
	}
}
