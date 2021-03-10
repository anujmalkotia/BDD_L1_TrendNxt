package TestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import PageObjects.OpenCart_homepage;
import PageObjects.OpenCart_loignpage;
import PageObjects.OpenCart_orderhistory;
import Resources.base;
import Utils.ReusableComponents;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObjects.OpenCart_Shopping_Page;
import PageObjects.Phone_page_1;
import PageObjects.OpenCart_product_comp;
import PageObjects.OpenCart_specialpage;
import PageObjects.OpenCart_NewsletterPage;
import PageObjects.OpenCart_Phone_pda;
import PageObjects.OpenCart_SearchPage;
import PageObjects.inlogin_page;

//TC02 - Product Comparison

public class TC02 extends base {
	
	public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@Given("Launching site1")
	public void launching_site1() throws IOException 
	{
		driver = driverSetup();
		driver.get(rc.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@When("Login {string} {string}")
	public void login(String email, String pswd) 
	{
	    OpenCart_homepage ohp = new OpenCart_homepage(driver);
	    OpenCart_loignpage olp = new OpenCart_loignpage(driver);
	    ohp.getMy_act().click();
	    ohp.getLogin().click();
	    
	    //LoginPage
	    olp.getEmail().sendKeys(email);
	    olp.getPasswd().sendKeys(pswd);
	    olp.getLogin_btn().click();
	}
	
	@When("Search {string}")
	public void search(String string) 
	{
		inlogin_page ilp = new inlogin_page(driver);
		OpenCart_SearchPage isp = new OpenCart_SearchPage(driver);
		OpenCart_Phone_pda ippp = new OpenCart_Phone_pda(driver);
		
		
		ilp.getSearch_box().sendKeys(Keys.ENTER);
		
		Select dropdown1 = new Select(isp.getDropdown1());
		dropdown1.selectByValue("28");
		isp.getChck_box1().click();
		isp.getSearch_btn().click();
		isp.getPhonePda().click();
		
		Select dropdown2 = new Select(ippp.getSort_by());
		dropdown2.selectByVisibleText("Price (High > Low)");

	}
	
	@When("Product Compare")
	public void product_compare() throws IOException, InterruptedException 
	{
		OpenCart_Phone_pda ippp = new OpenCart_Phone_pda(driver);
		OpenCart_product_comp pc = new OpenCart_product_comp(driver);
		Phone_page_1 pp1 = new Phone_page_1(driver);
		OpenCart_Shopping_Page sp = new OpenCart_Shopping_Page(driver);
		
		
		ippp.getAdd_t_c_1().click();
		ippp.getAdd_t_c_2().click();
		ippp.getAdd_t_c_3().click();
		System.out.println("Success");
		
		ippp.getCompare().click();
		
		if(driver.getTitle().equalsIgnoreCase("iPhone"))
		{
			driver.close();
		}
		
		pc.getProd1().click();
		
		String Flat_File = "./src\\main\\java\\Resources\\temp.txt";
		File FC = new File(Flat_File);
		FC.createNewFile();
		
		FileWriter FW = new FileWriter(Flat_File);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write(pp1.getTxt().getText());
		BW.close();
		
		pp1.getAdd_to_cart().click();
		
		pp1.getShopping_cart().click();
		
		Thread.sleep(3000);
		sp.getChckout().click();
		
	}
	
	@When("Checkout")
	public void checkout() throws IOException 
	{
		OpenCart_Shopping_Page sp = new OpenCart_Shopping_Page(driver);
		OpenCart_homepage ohp = new OpenCart_homepage(driver);
		OpenCart_orderhistory ooh = new OpenCart_orderhistory(driver);
		OpenCart_NewsletterPage onlp = new OpenCart_NewsletterPage(driver);
		OpenCart_specialpage osplp = new OpenCart_specialpage(driver);
		
		if(sp.getAlert_msg().isDisplayed()) {
			String Outofstock_error = null;
			rc.getss(Outofstock_error, driver);
		}
		String msg = "OUT OF STOCK, screenshot saved";
		System.out.println(msg);
		
		ohp.getMy_act().click();
		ohp.getOrder_history().click();
		
		ooh.getNewsletter().click();
		
		if(onlp.getRadio_btn().isSelected())
		{
			System.out.println("Already Checked");
		}
		else
		{
			onlp.getRadio_btn().click();
		}
		
		onlp.getContinue_btn().click();
		
		ohp.getSpecials().click();
		
		if(osplp.getGrid().isEnabled())
		{
			osplp.getList().click();
		}
		else
		{
			osplp.getGrid().click();
		}
	}
	
	@Then("Logout1")
	public void logout1() 
	{
		OpenCart_homepage ohp = new OpenCart_homepage(driver);
		
		ohp.getMy_act().click();
		ohp.getLogout().click();
		driver.close();
	}

}
