package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	WebDriver driver;
	public void frameconcpet()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'#ff7295')]")).click();
		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
		for(int i=0;i<allFrames.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> elementExist =	driver.findElements(By.xpath("//*[@id='Click' and contains(@style,'#ff7295')]"));
			if(elementExist.size()>0)
			{
				driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'#ff7295')]")).click();
			}
			driver.switchTo().defaultContent();
		}
	}

	public void nestedframeconcpet()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'#ff7295')]")).click();
		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
		for(int i=0;i<allFrames.size();i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> innerFrames = driver.findElements(By.tagName("iframe"));
			if(innerFrames.size()>0)
			{
				driver.switchTo().frame("frame2");
				List<WebElement> elementExist =	driver.findElements(By.xpath("//*[@id='Click' and contains(@style,'#4b7ecf')]"));
				if(elementExist.size()>0)
				{
					driver.findElement(By.xpath("//*[@id='Click' and contains(@style,'#4b7ecf')]")).click();
				}
			}

			driver.switchTo().defaultContent();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.nestedframeconcpet();
	}

}
