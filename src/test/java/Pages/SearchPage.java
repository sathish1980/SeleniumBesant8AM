package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {


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


}
