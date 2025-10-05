package seleniumproject.pajeobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import seleniumprojectsource.Abstractcomponents;

public class Productcatalogue extends Abstractcomponents{

		WebDriver driver;
		
		public Productcatalogue(WebDriver driver) //Constructor
		{
			super(driver);
			//Initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);	
		}
		
			
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
		@FindBy(css=".ngx-spinner-overlay")
		WebElement spinner1;
				
		
		By productsBy= By.cssSelector(".mb-3");
		By addtocart = By.cssSelector(".card-body button:last-of-type");
		By toastmsg = By.cssSelector("[class*='toast-bottom-right']");
		
				
		public List<WebElement> getproductlist()
		{
			waitforelementtoappear(productsBy);
			return products;
		}
		
		public WebElement getproductbyname(String shoes)
		{
			WebElement prod = getproductlist().stream().filter(product-> 
			product.findElement(By.cssSelector("b")).getText().equals(shoes)).findFirst().orElse(null);
			return prod;
		}
		
		public void addproducttocart(String shoes)
		{
			WebElement prod = getproductbyname(shoes);
			prod.findElement(addtocart).click();
			waitforelementtoappear(toastmsg);
			waitforelementtodisappear(spinner);
			waitforelementtodisappear(spinner1);
			
		}
	
		
		
		
		
		
		
	
}
