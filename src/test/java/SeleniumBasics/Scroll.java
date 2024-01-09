package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	WebDriver driver;
	public void scrollimplementation() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		//vertical scroll down
		js.executeScript("window.scrollBy(0,-100)", "");
		Thread.sleep(2000);
		//Horizontal scroll right
		js.executeScript("window.scrollBy(200,0)", "");
		Thread.sleep(2000);
		//Horizontal scroll left
		js.executeScript("window.scrollBy(-100,0)", "");
		Thread.sleep(2000);

		//verticallly down
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(2000);

		// vertically up
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		Thread.sleep(2000);

		// scroll to a specific element
		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);


	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scroll s= new Scroll();
		s.scrollimplementation();
	}

}
