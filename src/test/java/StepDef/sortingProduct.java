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

public class sortingProduct {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User sukses login dan berada di halaman Products")
    public void user_sukses_login_dan_berada_di_halaman_products() throws InterruptedException {

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

    @When("User klik ikon dropdown sebelah kanan atas halaman")
    public void user_klik_ikon_dropdown_sebelah_kanan_atas_halaman() throws InterruptedException{
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(1000);
    }

    @And("User pilih price high to low")
    public void user_pilih_price_high_to_low() throws InterruptedException {
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        Thread.sleep(1000);
    }

    @Then("List product tersortir dari termahal ke termurah")
    public void list_product_tersortir_dari_termahal_ke_termurah() {
        Assert.assertEquals("$49.99",driver.findElement(By.xpath("//div[@class='inventory_container']/div/div[1]/div[2]/div[2]/div")).getText());
        System.out.println("Scenario : Sortir Harga Product Termahal ke Termurah");
        System.out.println("You can see the first product with the price " + driver.findElement(By.xpath("//div[@class='inventory_container']/div/div[1]/div[2]/div[2]/div")).getText());
        driver.quit();
    }
}
