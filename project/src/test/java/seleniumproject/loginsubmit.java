package seleniumproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumproject.pajeobjects.Landingpage;

public class loginsubmit {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String shoes = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		Landingpage landingpage = new Landingpage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("anshikaTest1234@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(shoes)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='toast-bottom-right']")));
		//.ng-animating -- loading locator
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartproducts = driver.findElements(By.xpath("//p[text()='#68a961719320a140fe1ca57c']/following-sibling::h3"));
		Boolean match = cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(shoes));
		Assert.assertTrue(true);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results:nth-of-type(1)")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2200)");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String success = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(success.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		
	}

}
