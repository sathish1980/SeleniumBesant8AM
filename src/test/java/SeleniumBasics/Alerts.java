package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	WebDriver driver;

	public void launch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		// al.accept();
		al.dismiss();
		String alertText = driver.findElement(By.id("simple_result")).getText();
		if(alertText.equalsIgnoreCase("You have successfully clicked an alert"))
		{
			System.out.println("Matched");
		}

		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Alert al1 = driver.switchTo().alert();
		al1.sendKeys("Besant Tambaram");
		al1.accept();
		String alertText1 = driver.findElement(By.id("confirm_result")).getText();
		if(alertText1.contains("Besant Tambaram"))
		{
			System.out.println("Matched-Besant Tambaram");
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alerts A = new Alerts();
		A.launch();
	}

}
