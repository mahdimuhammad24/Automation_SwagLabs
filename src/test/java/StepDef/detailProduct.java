package StepDef;

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

public class detailProduct {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User berhasil login ke saucedemo")
    public void user_berhasil_login_ke_saucedemo() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);

    }

    @When("Klik nama product di halaman Products")
    public void klik_nama_product_di_halaman_products() throws InterruptedException {
        driver.findElement(By.id("item_4_title_link")).click();
        Thread.sleep(1000);
    }

    @Then("Menampilkan halaman detail product")
    public void menampilkan_halaman_detail_product() {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario : Show Product Detail");
        System.out.println("You can see product detail" + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        driver.quit();
    }
}
