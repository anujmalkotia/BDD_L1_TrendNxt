package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_wishlistpage {
	public WebDriver driver;
	
	public OpenCart_wishlistpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"form-currency\"]/div/button")
	WebElement currency;
	
	@FindBy(css = "button[name='GBP']")
	WebElement pound_sterling;
	
	@FindBy(css = "button[name='EUR']")
	WebElement euro;
	
	@FindBy(css="button[name='USD']")
	WebElement dollar;
	
	@FindBy(css=".price")
	WebElement price;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")
	WebElement add_to_cart;
	
	@FindBy(xpath = "//*[@id=\"account-wishlist\"]/div[1]/button")
	WebElement success_msg_close;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")
	WebElement remove_product;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
	WebElement continue_btn;

	public WebElement getCurrency() {
		return currency;
	}

	public WebElement getPound_sterling() {
		return pound_sterling;
	}

	public WebElement getEuro() {
		return euro;
	}

	public WebElement getDollar() {
		return dollar;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getAdd_to_cart() {
		return add_to_cart;
	}

	public WebElement getSuccess_msg_close() {
		return success_msg_close;
	}

	public WebElement getRemove_product() {
		return remove_product;
	}

	public WebElement getContinue_btn() {
		return continue_btn;
	}

}
