package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconcpets {

	WebDriver driver;
	public void launch(String expectedCountryName)
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		driver.findElement(By.xpath("//*[@id='j_idt87:country']//div[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:country_items']//li[last()]")));

		List<WebElement> allCountry = driver.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
		int listSize = allCountry.size();
		for(WebElement eachCountry :allCountry)
		{
			String actualCountryNAme = eachCountry.getText();
			if(actualCountryNAme.equalsIgnoreCase(expectedCountryName))
			{
				eachCountry.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listconcpets L = new Listconcpets();
		L.launch("Germany");
	}

}
