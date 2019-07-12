package Cucumber.Casestudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Case4 
{
	WebDriver driver;
	int cart,cart1;
	
	@Given("^Alex has registered into TestMeApp and do login$")
	public void alex_has_registered_into_TestMeApp_and_do_login() throws Throwable 
	{
		driver = UtilityClass.startBrowser("Chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		WebElement signin= driver.findElement(By.linkText("SignIn"));
		signin.click();
	}

	@When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_username_as_and_password_as(String arg1, String arg2) throws Throwable 
	{
		WebElement uname= driver.findElement(By.name("userName"));
		uname.sendKeys(arg1);
		WebElement pwd= driver.findElement(By.name("password"));
		pwd.sendKeys(arg2);
	}

	@When("^user clicks submit button$")
	public void user_clicks_submit_button() throws Throwable
	{
		WebElement log= driver.findElement(By.name("Login"));
		log.click();
	}

	@When("^user search a particular product like headphones$")
	public void user_search_a_particular_product_like_headphones() throws Throwable 
	{
		  Actions act = new Actions(driver);
		  act.moveToElement(driver.findElement(By.linkText("All Categories"))).build().perform();
		  driver.findElement(By.linkText("Electronics")).click();
		  // EXPLICIT WAIT
		  WebDriverWait wait= new WebDriverWait(driver ,100);			
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Head Phone")));
		  driver.findElement(By.linkText("Head Phone")).click();
	}

	@When("^user tries to access cart page$")
	public void user_tries_to_access_cart_page() throws Throwable 
	{	
		cart=driver.findElements(By.partialLinkText("Cart")).size();
		System.out.println("Cart has " + cart +" no of Items");
	}

	@Then("^Testme app doesn't display the cart icon$")
	public void testme_app_doesn_t_display_the_cart_icon() throws Throwable 
	{
		if(cart==0)
		{	
			System.out.println("cart icon is not displayed ");
			driver.findElement(By.linkText("Add to cart")).click();
			Assert.assertEquals(driver.getTitle(),"Search");
			cart1=driver.findElements(By.partialLinkText("Cart")).size();
			System.out.println("Cart has " + cart1 +" no of Items");
			if (cart1>0)
			{
				driver.findElement(By.xpath("//a [@href='displayCart.htm']")).click();
				Assert.assertEquals(driver.getTitle(),"View Cart");
				System.out.println("Item is now Added to Cart");
			}	
			else
			{ 
				System.out.print("Cart is empty");
			}
		}
		else
		{
			driver.findElement(By.xpath("//a [@href='displayCart.htm']")).click();
			Assert.assertEquals(driver.getTitle(),"View Cart");
			System.out.println("Item Added to Cart");
		}
		driver.close();
	}

	
}
