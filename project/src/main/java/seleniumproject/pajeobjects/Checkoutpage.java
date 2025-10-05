package seleniumproject.pajeobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import seleniumprojectsource.Abstractcomponents;

public class Checkoutpage extends Abstractcomponents{

	WebDriver driver;
	
	public Checkoutpage(WebDriver driver) //Constructor
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
		
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class, 'ta-item')])[2]")
	WebElement selectcountry1;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results:nth-of-type(1)");
	
	public void selectcountry(String countryname) throws InterruptedException
	{
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		waitforelementtoappear(results);
		selectcountry1.click();
		
	}
	
	public confirmationpage submitbutton()
	{
		submit.click();
		return new confirmationpage(driver);
	}
	

	
}
