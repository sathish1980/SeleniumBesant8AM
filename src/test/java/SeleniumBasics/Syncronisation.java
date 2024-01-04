package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Syncronisation {


	public void launch() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		driver.findElement(By.name("firstname")).sendKeys("sathish123#$");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("lastname")));

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Syncronisation s = new Syncronisation();
		s.launch();
	}

}
