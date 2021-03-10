package Resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import Utils.ReusableComponents;

public class base {
	public WebDriver driver;
	ReusableComponents rc = new ReusableComponents();
		
		public WebDriver driverSetup() throws IOException
		{
			String browserName = rc.getProperty("browser");
			
			if(browserName.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("ie"))
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			else if(browserName.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

			
			return driver;
			
			
		}
		
		public void closedriver() {
			driver.close();
		}

}
