package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_6 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
    }


    public void login() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.cssSelector(".submit-button")).click();
        Thread.sleep(2000);
    }


    public void addToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//a/span")).click();
        Thread.sleep(2000);
    }

    public void validateCart() {
        WebElement product = driver.findElement(By.xpath("//a/div[contains(text(),'Sauce Labs Backpack')]"));
        Assert.assertEquals(product.getText(), "Sauce Labs Backpack");

        WebElement price = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(price.getText(), "$29.99");
    }

    @Test
    public void testShop() throws InterruptedException {
        login();
        addToCart();
        validateCart();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
