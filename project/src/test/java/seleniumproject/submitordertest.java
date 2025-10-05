package seleniumproject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumproject.pajeobjects.Cartpage;
import seleniumproject.pajeobjects.Checkoutpage;
import seleniumproject.pajeobjects.Productcatalogue;
import seleniumproject.pajeobjects.confirmationpage;
import seleniumproject.pajeobjects.orderpage;
import testcomponents.Basetest;

public class submitordertest extends Basetest{
	
	String shoes = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getdata", groups = {"purchase"})
	public void submitorder(String email, String password) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub	
		Productcatalogue productcatalogue = landingpage.loginapplication(email, password);
		
		List<WebElement> products = productcatalogue.getproductlist();
		productcatalogue.addproducttocart(shoes);
		Cartpage cartpage = productcatalogue.gotocart();
		
		Boolean match = cartpage.verifyproductdisplay(shoes);
		Assert.assertTrue(true);
		Checkoutpage checkoutpage = cartpage.checkoutbutton();
		
		cartpage.windowsrolldown();
		
		checkoutpage.selectcountry("india");
		confirmationpage confirmationpage = checkoutpage.submitbutton();
		String confirmmessage = confirmationpage.getconfirmationpage();
		
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));	
	}
	@Test(dependsOnMethods={"submitorder"})
	public void orderhistorytest()
	{
		Productcatalogue productcatalogue = landingpage.loginapplication("manoharbonamukkala1234@gmail.com", "Test@1234");
		orderpage orderpage = landingpage.gotoorderspage();
		Assert.assertTrue(orderpage.verifyorderdisplay(shoes));
	}
	
	public String getscreenshots(String Testscreenshot) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+Testscreenshot + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+Testscreenshot + ".png";
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		return new Object[][] {{"anshikaTest1234@gmail.com", "Test@1234"},{"manoharbonamukkala1234@gmail.com", "Test@1234"}};
	}

}
