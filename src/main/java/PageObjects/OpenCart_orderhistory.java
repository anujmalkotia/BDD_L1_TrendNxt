package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_orderhistory {
	
	public WebDriver driver;
	
	public OpenCart_orderhistory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#column-right > div > a:nth-child(12)")
	WebElement newsletter;

	public WebElement getNewsletter() {
		return newsletter;
	}

}
