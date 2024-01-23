package SeleniumBasics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	WebDriver driver;
	public void windowshandlingimplementation()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		String ParentWindow =driver.getWindowHandle();
		driver.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindow = driver.getWindowHandles();

		for(String eachwindow : allWindow)
		{
			if(!eachwindow.equals(ParentWindow))
			{
				driver.switchTo().window(eachwindow);
				List<WebElement> elementExist = driver.findElements(By.id("menuform:j_idt40"));
				if(elementExist.size()>0)
				{
					driver.findElement(By.id("menuform:j_idt40")).click();
					driver.findElement(By.id("menuform:m_input")).click();
					driver.findElement(By.id("j_idt88:name")).sendKeys("sathish");
				}
				driver.switchTo().window(ParentWindow);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsHandling w = new WindowsHandling();
		w.windowshandlingimplementation();
	}

}
