package seleniumproject.pajeobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumprojectsource.Abstractcomponents;

public class orderpage extends Abstractcomponents{

	WebDriver driver;
	
	public orderpage(WebDriver driver) //Constructor
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productname;
	
	public Boolean verifyorderdisplay(String shoes)
	{
		Boolean match = productname.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(shoes));
		return match;
	}
	
	
	
	
	
	
	
	
	
	

}
