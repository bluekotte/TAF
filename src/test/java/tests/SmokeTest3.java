package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTest3 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void electric_floor_heating_calculator() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement width = driver.findElement(By.id("el_f_width"));
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        WebElement selectWebElement1 = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(selectWebElement1);
        selectRoomType.selectByVisibleText("Кухня или спальня");
        WebElement selectWebElement2 = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElement2);
        selectHeatingType.selectByVisibleText("Подогрев для комфорта");
        WebElement heatLosses = driver.findElement(By.id("el_f_losses"));
        WebElement calculateButton = driver.findElement(By.cssSelector("[value = 'Рассчитать']"));

        width.sendKeys("3");
        length.sendKeys("5");
        heatLosses.sendKeys("20");
        calculateButton.click();

        Thread.sleep(2000);

        WebElement floorCablePower = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(floorCablePower.getAttribute("value"), "11");
        WebElement specFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(specFloorCablePower.getAttribute("value"), "1");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
