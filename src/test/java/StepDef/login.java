package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User masuk ke halaman saucedemo login")
    public void user_masuk_ke_halaman_saucedemo_login(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @When("User input username")
    public void user_input_username(String username) throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(1000);
    }

    @And("User input password")
    public void user_input_password(String password) throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
    }

    @And("User klik tombol login")
    public void user_klik_tombol_login() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @Then("User masuk ke halaman dashboard saucedemo")
    public void user_masuk_ke_halaman_dashboard_saucedemo() {
        Assert.assertEquals("Products", driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login with valid usernames and passwords");
        System.out.println("You successfully log in, if you can see the title page name " + driver.findElement(By.className("title")).getText());
        driver.quit();
    }

}
