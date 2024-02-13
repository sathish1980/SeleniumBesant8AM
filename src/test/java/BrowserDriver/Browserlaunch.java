package BrowserDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.PropertyFile;

public class Browserlaunch {

	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;

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
		StartReport();
	}


	public void StartReport()
	{
		reports= new ExtentReports(System.getProperty("user.dir")+"//Reports//Automation.html",true);
	}

	public void StartReports(String name)
	{
		test = reports.startTest(name);
	}

	public void closeReport()
	{
		reports.flush();
	}
}
