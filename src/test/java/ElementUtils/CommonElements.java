package ElementUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonElements {

	public void EnterTextInTextbox(WebElement textBox,String textToBeEnter)
	{
		if(textBox.isDisplayed())
		{
			textBox.clear();
			textBox.sendKeys(textToBeEnter);
		}
	}

	public String RetriveTextFromTextbox(WebElement textBox,String attribute)
	{
		if(textBox.isDisplayed())
		{
			String actualText;
			if(attribute==null)
			{
				actualText = textBox.getText();
			}
			else
			{
				actualText = textBox.getAttribute(attribute);
			}
			if(actualText!=null)
				return actualText;
		}
		return null;
	}

	public void ClickOnBrowserBackButton(WebDriver driver)
	{
		driver.navigate().back();
	}

	public void WaitForElementToBeVisible(WebDriver driver, By WaitForElement, int secondsToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(secondsToWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(WaitForElement));
	}

	public void WaitForElementToBeClickable(WebDriver driver, By WaitForElement, int secondsToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(secondsToWait));
		wait.until(ExpectedConditions.elementToBeClickable(WaitForElement));
	}

	public void SelectTheValueFromList(WebDriver driver, By AllListelement,String expectedloaction)
	{
		List<WebElement> AllValues = driver.findElements(AllListelement);
		for (WebElement eachElement : AllValues )
		{
			String actualFromLocation = eachElement.findElement(By.cssSelector("div[class*='makeFlex']>div[class*='pushRight']")).getText();
			if(expectedloaction.equalsIgnoreCase(actualFromLocation))
			{
				eachElement.click();
				break;
			}
		}
	}


	public void ClickOnButton(WebElement buttonElement)
	{
		if (buttonElement.isEnabled())
			buttonElement.click();
	}

	public void CloseCreateAccountPopup(WebElement buttonElement)
	{
		try
		{
			if (buttonElement.isEnabled())
				buttonElement.click();
		}
		catch(Exception e)
		{

		}
	}

	public boolean SelectValueinCalender(WebDriver driver,String expectedDay)
	{
		List<WebElement> totalWeekRows = driver.findElements(By.xpath("(//*[@class='DayPicker-Months']//div)[1]//div[@class='DayPicker-Week']"));
		for(WebElement eachWeekRow : totalWeekRows)
		{
			List<WebElement> totalDaysInWeek = eachWeekRow.findElements(By.cssSelector("div[class^='DayPicker-Day']"));
			for(WebElement eachDays : totalDaysInWeek)
			{
				String checkItsDisabled = eachDays.getAttribute("class");
				if (!checkItsDisabled.contains("disabled"))
				{
					String eachDayValue =eachDays.findElement(By.cssSelector("[class='dateInnerCell']>p:nth-of-type(1)")).getText();
					if(eachDayValue.equalsIgnoreCase(expectedDay))
					{
						eachDays.click();
						return true;
					}

				}
			}
		}
		return false;
	}

	public void clickOnButton(WebElement buttonElement)
	{

		if (buttonElement.isDisplayed())
		{
			buttonElement.click();
		}
	}

	public String GetTextOfelement(WebElement getTextElement)
	{
		if(getTextElement.isDisplayed())
			return getTextElement.getText();
		return null;
	}

	public String GetAttributeOfelement(WebElement getElement,String attribute)
	{
		if(getElement.isDisplayed())
			return getElement.getAttribute(attribute);
		return null;
	}

	public void EnterText(WebElement getTextElement, String textToEnter)
	{
		if(getTextElement.isDisplayed())
			getTextElement.sendKeys(textToEnter);
	}

	public void ClickIfElementExist(WebDriver driver,String Elementpath) {
		List<WebElement>allframeelement = driver.findElements(By.tagName("iframe"));

		if (allframeelement.size()>0)
		{
			for(int i=0;i<allframeelement.size();i++)
			{
				driver.switchTo().frame(i);
				List<WebElement> AllElements = driver.findElements(By.xpath(Elementpath));
				if (AllElements.size() > 0) {
					for (WebElement eachElement : AllElements) {

						eachElement.click();
						driver.switchTo().defaultContent();
						break;
					}
				}
				else
				{
					driver.switchTo().defaultContent();
				}
			}
		}
	}

	public void ClickOnAddClose(WebDriver driver)
	{
		try
		{
			WaitForElementToBeClickable(driver,By.xpath("//*[@class='ic_circularclose_grey']"),60);
			driver.findElement(By.xpath("//*[@class='ic_circularclose_grey']")).click();
		}
		catch(Exception e)
		{

		}
	}

	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
		//This method returns the time in millis
		long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Destinationfile.toString();
	}

}
