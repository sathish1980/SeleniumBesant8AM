package ElementUtils;

import org.openqa.selenium.WebElement;

public class CommonElements {

	public void EnterValueInTextBox(WebElement element,String text)
	{
		element.clear();
		element.sendKeys(text);
	}

}
