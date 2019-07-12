package Cucumber.Casestudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UtilityClass 
{

	static WebDriver driver;

	public static WebDriver startBrowser(String browsername,String url)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Training_c2a.04.30\\Desktop\\manoj'\\selenium\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_c2a.04.30\\Desktop\\manoj'\\selenium\\Drivers\\chromedriver.exe");
	        driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}