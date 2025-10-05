package seleniumproject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumproject.pajeobjects.Cartpage;
import seleniumproject.pajeobjects.Checkoutpage;
import seleniumproject.pajeobjects.Productcatalogue;
import seleniumproject.pajeobjects.confirmationpage;
import testcomponents.Basetest;

public class Errorvalidation extends Basetest{

	@Test(groups= {"errorvalidation1"})
	public void loginerrorvalidation() throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub

		String shoes = "ADIDAS ORIGINAL";	
		landingpage.loginapplication("anshikaTest12@gmail.com", "Tet@1234");
		Assert.assertEquals("Incorrect emails or password.", landingpage.errormessage());	
	}
	
	@Test
	public void producterrorvalidation() throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub

		String shoes = "ADIDAS ORIGINAL";	
		Productcatalogue productcatalogue = landingpage.loginapplication("anshikaTest1234@gmail.com", "Test@1234");
		
		List<WebElement> products = productcatalogue.getproductlist();
		productcatalogue.addproducttocart(shoes);
		Cartpage cartpage = productcatalogue.gotocart();
		
		Boolean match = cartpage.verifyproductdisplay("ADIDASA ORIGINAL");
		Assert.assertFalse(match);			
	}	

}
