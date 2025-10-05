package testcomponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumproject.pajeobjects.Landingpage;

public class Basetest {

	public WebDriver driver;
	public Landingpage landingpage;
	
	public WebDriver initializedriver() throws IOException
	{
		//properties class
		
		Properties prop = new Properties();
		InputStream fis = getClass().getClassLoader().getResourceAsStream("globaldataproperties");
		prop.load(fis);
		
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		 //prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getscreenshots(String Testscreenshot, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+Testscreenshot + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+Testscreenshot + ".png";
	}	
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchapplication() throws IOException
	{
		driver = initializedriver();
		landingpage = new Landingpage(driver);
		landingpage.gotolink();
		return landingpage;
	}
	@AfterMethod(alwaysRun=true)
	public void closedriver()
	{
		driver.close();
	}
}
