package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ElementUtils.CommonElements;

public class SearchPage  extends CommonElements{

	WebDriver driver;
	@FindBy (xpath="//*[@for='fromCity']")
	WebElement from;
	@FindBy (xpath="//*[@for='toCity']")
	WebElement to;
	@FindBy (xpath="//*[@data-cy='submit']//a")
	WebElement button;
	@FindBy (xpath="//*[@data-cy='sameCityError']")
	WebElement error;
	@FindBy (xpath="//input[@id='fromCity']")
	WebElement fromLocation;
	@FindBy (xpath="//input[@id='toCity']")
	WebElement toLocation;

	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnFromLocation()
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);

		// Select From location
		//WebElement from = driver.findElement(By.xpath("//*[@for='fromCity']"));
		ClickOnButton(from);

	}

	public void ClickOnToLocation()
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[@for='toCity']"),60);

		// Select From location
		//WebElement to = driver.findElement(By.xpath("//*[@for='toCity']"));
		ClickOnButton(to);

	}

	public void SelectTheValueFromList(String expectedloaction)
	{
		By AllListelement= By.xpath("(//ul[@role='listbox']//li)");
		List<WebElement> AllValues = driver.findElements(AllListelement);
		for (WebElement eachElement : AllValues )
		{
			String actualFromLocation = eachElement.findElement(By.cssSelector("div[class*='makeFlex']>div[class*='pushRight']")).getText();
			if(expectedloaction.equalsIgnoreCase(actualFromLocation))
			{
				ClickOnButton(eachElement);
				//eachElement.click();
				break;
			}
		}
	}


	public boolean SelectValueinCalender(String expectedDay)
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
						ClickOnButton(eachDays);
						//eachDays.click();
						return true;
					}

				}
			}
		}
		return false;
	}


	public void ClickOnSearchButton()
	{
		//WebElement button = driver.findElement(By.xpath("//*[@data-cy='submit']//a"));
		ClickOnButton(button);

	}

	public String GetFromLocation()
	{
		//WebElement fromLocation = driver.findElement(By.xpath("//input[@id='fromCity']"));
		return GetAttributeOfelement(fromLocation,"value");
		//.getAttribute("value");

	}

	public String GetToLocation()
	{
		//WebElement toLocation = driver.findElement(By.xpath("//input[@id='toCity']"));
		return GetAttributeOfelement(toLocation,"value");

		//.getAttribute("value");

	}


	public String GetExpectedSearchResult()
	{
		return "Flights from "+GetFromLocation()+" to "+GetToLocation();
	}


	public String RetriveAnSameCityError()
	{
		//WebElement error =driver.findElement(By.xpath("//*[@data-cy='sameCityError']"));
		return GetTextOfelement(error);
	}

	public String GetExpectedSameCityError()
	{
		return "From & To airports cannot be the same";

	}
}
