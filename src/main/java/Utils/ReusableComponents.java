package Utils;
import java.io.IOException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ReusableComponents {
	public static Properties prop;
	DataFormatter formatter = new DataFormatter();
	FileInputStream fis;
	
	public String getProperty(String key) throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream("./src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		
		String value = prop.getProperty(key);
		
		return value;
	}
	
	
	
	public FileInputStream getFis(String path) throws IOException {
		fis= new FileInputStream(path);
		return fis;
	}
	
	
	
	public String getss(String testcasename,WebDriver Driver) throws IOException
    {
        TakesScreenshot ts= (TakesScreenshot) Driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destinationfile="D:\\Selenium\\QET_CoE_Selenium_L2\\screenshots\\"+testcasename+".png";
        FileUtils.copyFile(source, new File(destinationfile));
        return destinationfile;
    }

}
