package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public void launch()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("sathish");
		username.clear();

		driver.findElement(By.id("email")).sendKeys("tutor");
		// By.Name
		driver.findElement(By.name("email")).sendKeys("kumar");
		// By.className // if there is space in the value then we should not consider this locator
		//driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("kumar");
		// By.linkText
		// driver.findElement(By.linkText("Forgotten password?")).click();
		// By.partialLinkText
		// driver.findElement(By.partialLinkText("word?")).click();
		// By.cssSelector - to identify the webelement by more than one attribute
		// tag # id
		// driver.findElement(By.cssSelector("input#email")).sendKeys("besant");
		// tag.class(when there is space in class attribute value then we should not use this locator
		// driver.findElement(By.cssSelector("input.inputtext _55r1 _6luy")).sendKeys("besant");
		// tag and attribute
		driver.findElement(By.cssSelector("input[data-testid='royal_email']")).sendKeys("today");
		// tag, class and attribute
		// driver.findElement(By.cssSelector("input.inputtext _55r1 _6luy[data-testid='royal_email']")).sendKeys("not work");
		// contains in css selector - *
		// e.g :button[id*='u_0_9']
		// driver.findElement(By.cssSelector("button[id*='u_0_9']")).sendKeys("not work");

		// Startswith in css selector - ^
		// e.g :button[id*='u_0_9']
		// endsswith in css selector - $
		// e.g :button[id$='u_0_9']
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locators L = new Locators();
		L.launch();
	}

}
