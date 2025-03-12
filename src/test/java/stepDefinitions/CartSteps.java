package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps 
{
	private WebDriver driver;

    public CartSteps()
    {
        driver = new ChromeDriver();
    }

    @Given("User opens the Sauce Demo login page")
    public void user_opens_the_sauce_demo_login_page() {
        driver.get("https://www.saucedemo.com");
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("User clicks the login button")
    public void user_clicks_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User is logged in successfully")
    public void user_is_logged_in_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Given("User is on the inventory page")
    public void user_is_on_inventory_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @When("User adds the {string} to the cart")
    public void user_adds_the_to_the_cart(String productName) {
        WebElement addButton = driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"));
        addButton.click();
    }

    @Then("The cart should have {int} item")
    public void the_cart_should_have_item(int expectedCount) {
        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(String.valueOf(expectedCount), cartCount);
    }

    @Then("The {string} should be in the cart")
    public void the_should_be_in_the_cart(String productName) {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement cartItem = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
        Assert.assertTrue(cartItem.isDisplayed());
        driver.navigate().back();
    }

    @Given("Log the start of the step")
    public void log_the_start_of_the_step(){
        System.out.println("Starting step");
    }

    @Given("Log the end of the step")
    public void log_the_end_of_the_step(){
        System.out.println("Ending step");
    }

    @After
    public void tearDown()
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }

}
