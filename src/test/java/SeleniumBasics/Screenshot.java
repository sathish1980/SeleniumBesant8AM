package SeleniumBasics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	WebDriver driver;

	public void launch() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		TakesScreenshot t = (TakesScreenshot)driver;
		File sourceFile = t.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumBesant8AM\\Screenshot\\Test1.png");
		FileUtils.copyFile(sourceFile, destinationfile);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Screenshot s = new Screenshot();
		s.launch();
	}

}
