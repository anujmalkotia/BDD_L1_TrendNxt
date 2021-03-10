package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_contactuspage {
	public WebDriver driver;
	
	public OpenCart_contactuspage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#input-enquiry")
	WebElement enquiry_box;
	
	@FindBy(css="input[type=\"submit\"]")
	WebElement submit_enquiry_btn;
	
	@FindBy(css="//*[@id=\"logo\"]/h1/a")
	WebElement home_url;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement continue_btn;

	public WebElement getEnquiry_box() {
		return enquiry_box;
	}

	public WebElement getSubmit_enquiry_btn() {
		return submit_enquiry_btn;
	}

	public WebElement getHome_url() {
		return home_url;
	}

	public WebElement getContinue_btn() {
		return continue_btn;
	}

}
