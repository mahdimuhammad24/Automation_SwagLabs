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

public class cart {
    WebDriver driver;
    String baseUrl =  "https://www.saucedemo.com/";

    @Given("User Berada Dalam Halaman Products")
    public void user_berada_dalam_halaman_products() throws InterruptedException {

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

    @When("User klik Tombol Add to Cart Dalam Produk Yang Dipilih")
    public void user_klik_tombol_add_to_cart_dalam_produk_yang_dipilih() throws Exception {
        driver.findElement(By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']")).click();
        Thread.sleep(1000);
    }

    @And("User Klik Ikon Cart")
    public void user_klik_ikon_cart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        Thread.sleep(1000);
    }

    @Then("Dalah Halaman Cart, Menampilkan Produk Yang Dipilih")
    public void dalah_halaman_cart_menampilkan_produk_yang_dipilih() {
        Assert.assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Menambahankan Produk Kedalam Keranjang");
        System.out.println("You can see product name" + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + "  in the cart page");
        driver.quit();
    }
}
