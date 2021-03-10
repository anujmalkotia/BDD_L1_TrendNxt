package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.OpenCart_contactuspage;
import PageObjects.OpenCart_homepage;
import PageObjects.OpenCart_registerpage;
import PageObjects.OpenCart_samsungtabpage;
import PageObjects.OpenCart_wishlistpage;
import Resources.base;
import Utils.ReusableComponents;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//TC01 - Registration and Add to Cart

public class TC01 extends base {
	public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@Given("Launch site")
	public void launch_site() throws IOException 
	{
		driver = driverSetup();
		driver.get(rc.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@When("Register {string} {string} {string} {string} {string}")
	public void register(String fname, String lname, String email, String tele, String pswd) 
	{
	    //Creating Objects of Class
		OpenCart_homepage ohp = new OpenCart_homepage(driver);
		OpenCart_registerpage orp  = new OpenCart_registerpage(driver);
	    
	    ohp.getMy_act().click();
	    ohp.getRegister().click();
	    
	    //RegisterPage
	    orp.getFname().sendKeys(fname);
	    orp.getLname().sendKeys(lname);
	    orp.getEmail().sendKeys(email);
	    orp.getTelephone().sendKeys(tele);
	    orp.getPassword().sendKeys(pswd);
	    orp.getC_password().sendKeys(pswd);
	    orp.getChck_box1().click();
	    orp.getButton1().click();
	    
	    //After Registering
	   orp.getContinue_btn().click();
	    
	}
	
	@When("Enquiry {string}")
	public void enquiry(String enquiry) 
	{
	    OpenCart_homepage ohp = new OpenCart_homepage(driver);
	    OpenCart_contactuspage ocp = new OpenCart_contactuspage(driver);
	    
	    ohp.getContact_us().click();
	    ocp.getEnquiry_box().sendKeys(enquiry);
	    ocp.getSubmit_enquiry_btn().click();
	    ocp.getContinue_btn().click();
	    
	}
	
	@When("Samsung Tab {string} {string}")
	public void samsung_tab(String review, String rating) throws InterruptedException 
	{
	    
	    OpenCart_homepage ohp = new OpenCart_homepage(driver);
	    OpenCart_samsungtabpage ostp = new OpenCart_samsungtabpage(driver);
	   
	    
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.elementToBeClickable(ohp.getSamsung_tab_jpg()));
	    
	    
	    ohp.getSamsung_tab_jpg().click();
	    
	    ostp.getReview_tab().click();
	    ostp.getReview_text().sendKeys(review);
	    
	    driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input["+rating+"]")).click();
	    
	    ostp.getWishlist_btn().click();
	    
	    Thread.sleep(3000);
	    ostp.getSuccess_banner_close().click();
	    
	    ostp.getWishlist_btn_header().click();
	    
	}
	
	@When("Currency")
	public void currency() 
	{
	    OpenCart_wishlistpage owlp = new OpenCart_wishlistpage(driver);
	    
	    owlp.getCurrency().click();
	    owlp.getPound_sterling().click();
	    System.out.println(owlp.getPrice().getText());
	    
	    owlp.getCurrency().click();
	    owlp.getEuro().click();
	    System.out.println(owlp.getPrice().getText());
	    
	    owlp.getCurrency().click();
	    owlp.getDollar().click();
	    System.out.println(owlp.getDollar().getText());
	}
	
	@When("Wish List")
	public void wish_list() throws InterruptedException 
	{
	    OpenCart_wishlistpage owlp = new OpenCart_wishlistpage(driver);
	    
	    owlp.getAdd_to_cart().click();
	    
	    Thread.sleep(3000);
	    owlp.getSuccess_msg_close().click();
	    owlp.getRemove_product().click();
	    owlp.getContinue_btn().click();
	}
	
	@Then("Logout")
	public void logout() 
	{
	    OpenCart_homepage ohp = new OpenCart_homepage(driver);
	    
	    ohp.getMy_act().click();
	    ohp.getLogout().click();
	    driver.close();
	}

}
