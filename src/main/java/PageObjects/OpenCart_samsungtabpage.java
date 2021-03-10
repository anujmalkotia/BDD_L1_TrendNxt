package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_samsungtabpage {
	public WebDriver driver;
	
	public OpenCart_samsungtabpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")
	WebElement review_tab;
	
	@FindBy(css="#input-review")
	WebElement review_text;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")
	WebElement wishlist_btn;
	
	@FindBy(xpath="//*[@id=\"product-product\"]/div[1]/button")
	WebElement success_banner_close;
	
	@FindBy(css="#wishlist-total")
	WebElement wishlist_btn_header;

	public WebElement getReview_tab() {
		return review_tab;
	}

	public WebElement getReview_text() {
		return review_text;
	}

	public WebElement getWishlist_btn() {
		return wishlist_btn;
	}

	public WebElement getSuccess_banner_close() {
		return success_banner_close;
	}

	public WebElement getWishlist_btn_header() {
		return wishlist_btn_header;
	}

}
