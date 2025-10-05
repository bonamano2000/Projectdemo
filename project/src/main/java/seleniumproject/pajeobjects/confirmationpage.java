package seleniumproject.pajeobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumprojectsource.Abstractcomponents;

public class confirmationpage extends Abstractcomponents{

	WebDriver driver;
	
	public confirmationpage(WebDriver driver) //Constructor
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
		
	@FindBy(css=".hero-primary")
	WebElement sucess;
	
	public String getconfirmationpage()
	{
		return sucess.getText();
		
	}

}
