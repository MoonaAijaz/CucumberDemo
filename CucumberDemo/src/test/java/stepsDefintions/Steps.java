package stepsDefintions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Steps {
	WebDriver driver;
	@Given("the user is on the nopCommerce login page")
	public void navigateToLoginPage() {
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fcustomer%2Finfo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); 
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
	}
	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void the_user_enters_valid_credentials_username_password(String user, String pwd) {
	   driver.findElement(By.id("Email")).sendKeys(user);
	   driver.findElement(By.id("Password")).sendKeys(pwd);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("the user should be redirected to My Account page")
	public void the_user_should_be_redirected_to_my_account_page() {
	    boolean status=driver.findElement(By.xpath("//div[@class='header-links']//a[text()='My account']")).isDisplayed();
	    Assert.assertEquals(status,true);
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
	boolean welcometext=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
	Assert.assertEquals(welcometext, true);
	driver.quit();
}

}