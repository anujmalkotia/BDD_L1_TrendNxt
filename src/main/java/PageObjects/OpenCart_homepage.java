package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_homepage {
	public WebDriver driver;
	
	public OpenCart_homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="body > footer > div > div > div:nth-child(3) > ul > li:nth-child(4) > a")
	WebElement specials;
	
	@FindBy(css ="#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
	WebElement order_history;
	
	@FindBy(css = ".list-inline > li:nth-child(2)")
	WebElement my_act;
	
	@FindBy(css = ".dropdown-menu.dropdown-menu-right >li:nth-child(1)") 
	WebElement register;
	
	@FindBy(css = ".dropdown-menu.dropdown-menu-right>li:nth-child(5)")
	WebElement logout;
	
	@FindBy(css = "#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
	WebElement login;
	
	@FindBy(css = "body > footer > div > div > div:nth-child(2) > ul > li:nth-child(1) > a")
	WebElement contact_us;
	
	@FindBy(xpath="//*[@id=\"slideshow0\"]/div/div[4]/a/img")
	WebElement samsung_tab_jpg;

	public WebElement getMy_act() {
		return my_act;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getContact_us() {
		return contact_us;
	}

	public WebElement getSamsung_tab_jpg() {
		return samsung_tab_jpg;
	}

	public WebElement getOrder_history() {
		return order_history;
	}

	public WebElement getSpecials() {
		return specials;
	}

}
