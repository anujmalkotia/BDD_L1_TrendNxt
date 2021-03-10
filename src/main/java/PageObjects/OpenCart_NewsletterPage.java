package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_NewsletterPage {
	
	public WebDriver driver;
	
	public OpenCart_NewsletterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#content > form > fieldset > div > div > label:nth-child(1) > input[type=radio]")
	WebElement radio_btn;
	
	@FindBy(css="input[value=\"Continue\"]")
	WebElement continue_btn;

	public WebElement getRadio_btn() {
		return radio_btn;
	}

	public WebElement getContinue_btn() {
		return continue_btn;
	}
	
	

}
