package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_specialpage {
	
	public WebDriver driver;
	
	public OpenCart_specialpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".fa.fa-th-list")
	WebElement list;
	
	@FindBy(id="grid-view")
	WebElement grid;

	public WebElement getList() {
		return list;
	}

	public WebElement getGrid() {
		return grid;
	}

}
