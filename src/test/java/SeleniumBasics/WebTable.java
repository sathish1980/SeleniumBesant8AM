package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	WebDriver driver;
	String indentify="notdone";
	public void tableconcept(String expectedcountry) throws InterruptedException
	{

		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		List<WebElement> AllRows  = driver.findElements(By.xpath("//*[@id='form:j_idt89']//table//tbody//tr"));
		for(int i=1;i<=AllRows.size();i++)
		{
			String actualCountry = driver.findElement(By.xpath("//*[@id='form:j_idt89']//table//tbody//tr["+i+"]//td[2]//span[3]")).getText();
			if(expectedcountry.equalsIgnoreCase(actualCountry))
			{
				String Name = driver.findElement(By.xpath("//*[@id='form:j_idt89']//table//tbody//tr["+i+"]//td[1]")).getText();
				System.out.println(Name);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable w = new WebTable();
		w.tableconcept("Germany");
	}

}
