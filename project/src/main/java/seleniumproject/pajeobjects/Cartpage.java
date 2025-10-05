package seleniumproject.pajeobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumprojectsource.Abstractcomponents;

public class Cartpage extends Abstractcomponents{

	WebDriver driver;
	
	public Cartpage(WebDriver driver) //Constructor
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
		
	@FindBy(xpath="//p[text()='#68a961719320a140fe1ca57c']/following-sibling::h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkbutton;
	
	public Boolean verifyproductdisplay(String shoes)
	{
		Boolean match = cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(shoes));
		return match;
	}
	
	public Checkoutpage checkoutbutton()
	{
		checkbutton.click();
		return new Checkoutpage(driver);
		
	}
	
	
	
	
	
	
	
	

}
