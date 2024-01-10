package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

	WebDriver driver;
	public void launch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		driver.findElement(By.name("firstname")).sendKeys("sathish123#$");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("lastname")));

		// dropdown -select class
		// 2 types - single select dropdown , multiselect drodpdown
		// methods - selectByIndex, selectByValue(value),selectByVisibleText(text)
		Select dayDropdown = new Select(driver.findElement(By.id("day")));
		dayDropdown.selectByIndex(5);
		dayDropdown.selectByValue("10");

		Select monthDropdown = new Select(driver.findElement(By.id("month")));
		monthDropdown.selectByValue("6");

		Select yearDropdown = new Select(driver.findElement(By.id("year")));
		yearDropdown.selectByVisibleText("2015");


	}

	public void multiselectdropdown() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select foodDropdown = new Select(driver.findElement(By.xpath("//*[@class='col-lg-3' and @id='second']")));
		// isMultiple
		//if(foodDropdown.isMultiple()==true)
		if(foodDropdown.isMultiple())
		{
			foodDropdown.selectByIndex(1);
			Thread.sleep(2000);
			foodDropdown.selectByValue("bonda");
			Thread.sleep(2000);
			foodDropdown.selectByVisibleText("Pizza");
			Thread.sleep(2000);
			foodDropdown.deselectByIndex(1);
			Thread.sleep(2000);
			foodDropdown.deselectByValue("bonda");
			Thread.sleep(2000);
			foodDropdown.deselectByVisibleText("Pizza");
			Thread.sleep(2000);
			foodDropdown.deselectAll();

		}
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown d = new Dropdown();
		d.multiselectdropdown();
	}

}
