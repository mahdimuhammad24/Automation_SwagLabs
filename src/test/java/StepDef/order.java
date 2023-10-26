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

public class order {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User buka halaman saucedemo")
    public void user_buka_halaman_saucedemo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(1000);

    }

    @When("User login sebagai standard user")
    public void user_login_sebagai_standard_user() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @And("User pilih product Sauce Labs Backpack")
    public void user_pilih_product_sauce_labs_backpack() throws InterruptedException {
        driver.findElement(By.id("item_4_title_link")).click();
        Thread.sleep(1000);
    }

    @Then("User berada di halaman detail product")
    public void user_berada_di_halaman_detail_product() throws InterruptedException {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Product Matching");
        Thread.sleep(1000);
    }

    @And("User menambahkan product ke cart")
    public void user_menambahkan_product_ke_cart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
    }

    @And("User ke halaman cart")
    public void user_ke_halaman_cart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        Thread.sleep(1000);
    }

    @And("User memproses checkout")
    public void user_memproses_checkout() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
        Assert.assertEquals("Checkout: Your Information",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText());
        Thread.sleep(1000);
    }

    @And("User masuk dan mangikuti checkout information:")
    public void user_masuk_dan_mangikuti_checkout_information() throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys("Mahdi");
        driver.findElement(By.id("last-name")).sendKeys("M Bashir");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(1000);
    }

    @And("User melanjutkan checkout")
    public void user_melanjutkan_checkout() throws InterruptedException {
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
    }

    @And("User menyelesaiakn order")
    public void user_menyelesaiakn_order() throws InterruptedException {
        Assert.assertEquals("Checkout: Overview",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText());
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
    }

    @Then("User mendapatkan pesan konfirmasi THANK YOU FOR YOUR ORDER")
    public void user_mendapatkan_pesan_konfirmasi() {
        Assert.assertEquals("Thank you for your order!",driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText());
        System.out.println("Scenario : User successfully complete the order");
        System.out.println("You successfully complete your order");
        driver.quit();
    }
}
