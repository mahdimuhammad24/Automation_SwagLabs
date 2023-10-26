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

public class failedLogin {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User buka halaman saucedemo login")
    public void user_buka_halaman_saucedemo_login() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @When("User input invalid username")
    public void user_input_invalid_username() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("user_mahdi");
        Thread.sleep(1000);
    }

    @And("User input invalid password")
    public void user_input_invalid_password() throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys("mahdi123");
        Thread.sleep(1000);
    }

    @When("User input valid username")
    public void user_input_valid_username() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
    }

    @And("User input valid password")
    public void user_input_valid_password() throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
    }

    @And("Klik tombol login")
    public void klik_tombol_login() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @Then("User tidak masuk ke halaman dashboard saucedemo")
    public void user_tidak_masuk_ke_halaman_dashboard_saucedemo() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());
        System.out.println("Scenario : Login with invalid  usernames and passwords");
        System.out.println("You can see error " + driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());
        driver.quit();
    }


}
