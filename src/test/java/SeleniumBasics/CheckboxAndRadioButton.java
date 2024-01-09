package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxAndRadioButton {
	WebDriver driver;

	public void launch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.findElement(By.xpath("//div[@id='j_idt87:j_idt91']//div[starts-with(@class,'ui-chkbox-box')]")).click();
		String className = driver.findElement(By.xpath("//div[@id='j_idt87:j_idt91']//div[starts-with(@class,'ui-chkbox-box')]")).getAttribute("class");
		System.out.println(className);
		if(className.contains("ui-state-active"))
		{
			System.out.println("Checkbox is checked");
		}

		//toggle
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		String toggleName=driver.findElement(By.id("j_idt87:j_idt100")).getAttribute("class");
		if(toggleName.contains("ui-toggleswitch-checked"))
		{
			System.out.println("Toggle is enabled");
			String text = driver.findElement(By.className("ui-growl-title")).getText();

			System.out.println(text);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-growl-message")));



			driver.findElement(By.className("ui-toggleswitch-slider")).click();
			String toggleuncheckName=driver.findElement(By.id("j_idt87:j_idt100")).getAttribute("class");
			System.out.println(toggleuncheckName);
			String unchecktoasttext = driver.findElement(By.className("ui-growl-title")).getText();

			System.out.println(unchecktoasttext);
		}
	}

	public void Radiobutton()
	{

		driver.manage().window().maximize();
		driver.get("https://leafground.com/radio.xhtml");
		driver.findElement(By.xpath("//*[@id='j_idt87:console1']//td[3]//div[starts-with(@class,'ui-radiobutton-box')]")).click();
		String radioclassName = driver.findElement(By.xpath("//*[@id='j_idt87:console1']//td[3]//div[starts-with(@class,'ui-radiobutton-box')]")).getAttribute("class");
		System.out.println(radioclassName);
		if(radioclassName.contains("ui-state-active"))
		{
			System.out.println("Radio button is checked");
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckboxAndRadioButton c = new CheckboxAndRadioButton();
		c.launch();
		c.Radiobutton();
	}

}
