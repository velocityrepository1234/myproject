package baseclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass
{

	WebDriver driver;
	public WebDriver initializeBrowser() throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver",
				PathConfiguration.driverPath);
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		driver.get(Utility.readPropertyFileData("URL"));
		System.out.println("-----------Reading property file 11------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}