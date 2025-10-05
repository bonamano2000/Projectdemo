package seleniumproject.pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumprojectsource.Abstractcomponents;

public class Landingpage extends Abstractcomponents{

		WebDriver driver;
		
		public Landingpage(WebDriver driver) //Constructor
		{
			super(driver);
			//Initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		//WebElement useremail = driver.findElement(By.id("userEmail"));
		
		@FindBy(id="userEmail")
		WebElement useremail;
		
		@FindBy(id="userPassword")
		WebElement password;
		
		@FindBy(id="login")
		WebElement submit;	
		
		@FindBy(css="[class*='toast-message']")
		WebElement forgotpass;	
		
		public Productcatalogue loginapplication(String email, String passwordi)
		{
			useremail.sendKeys(email);
			password.sendKeys(passwordi);
			submit.click();
			Productcatalogue productcatalogue = new Productcatalogue(driver);
			return productcatalogue;
		}
		
		public String errormessage()
		{
			waitforwebelementtoappear(forgotpass);
			return forgotpass.getText();
		}
		
		public void gotolink()
		{
			driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		}
		
		
	

}
