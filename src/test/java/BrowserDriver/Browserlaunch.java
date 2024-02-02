package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utils.PropertyFile;

public class Browserlaunch {

	public static WebDriver driver;
	public void Launch() throws IOException
	{
		String browserName = PropertyFile.GetProperty().getProperty("browser");
		if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

}
