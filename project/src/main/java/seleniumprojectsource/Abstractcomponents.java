package seleniumprojectsource;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumproject.pajeobjects.Cartpage;
import seleniumproject.pajeobjects.orderpage;

public class Abstractcomponents {

	WebDriver driver;
	
	public Abstractcomponents(WebDriver driver) 
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='/dashboard/myorders']")
	WebElement orders;
	

	public void waitforelementtoappear(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitforwebelementtoappear(WebElement findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public void waitforelementtodisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public Cartpage gotocart()
	{
		cart.click();
		Cartpage cartpage = new Cartpage(driver);
		return cartpage;
	}
	
	public orderpage gotoorderspage()
	{
		orders.click();
		orderpage orderpage = new orderpage(driver);
		return orderpage;
	}
	
	public void windowsrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2200)");
	}
	



}


