package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationandValidation {



	WebDriver driver;

	public void launch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		//verification

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		String t =driver.findElement(By.xpath("(//*[@class='card']//h5)[1]")).getText();
		System.out.println(t);
		String c = driver.findElement(By.xpath("(//*[text()='Show'])[1]")).getAttribute("class");
		System.out.println(c);

		//validation
		/*isSelected()
		isDisplayed()
		isEnabled()*/

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificationandValidation v = new VerificationandValidation();
		v.launch();
	}

}
