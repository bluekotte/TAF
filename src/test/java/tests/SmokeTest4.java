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

public class SmokeTest4 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void laminateCalculator() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");


        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select selectLayingMethodLaminate = new Select(selectWebElement);
        selectLayingMethodLaminate.selectByVisibleText("с использованием отрезанного элемента");
        WebElement length = driver.findElement(By.id("ln_room_id"));
        length.clear();
        length.sendKeys("500");
        WebElement width = driver.findElement(By.id("wd_room_id"));
        width.clear();
        width.sendKeys("400");
        WebElement laminatePanelLength = driver.findElement(By.id("ln_lam_id"));
        laminatePanelLength.clear();
        laminatePanelLength.sendKeys("2000");
        WebElement laminatePanelWidth = driver.findElement(By.id("wd_lam_id"));
        laminatePanelWidth.clear();
        laminatePanelWidth.sendKeys("200");
        WebElement layingDirectionRadioButton = driver.findElement(By.id("direction-laminate-id1"));
        layingDirectionRadioButton.click();
        WebElement calculateButton = driver.findElement(By.xpath("//a[contains(text(),'Рассчитать')]"));
        calculateButton.click();

        Thread.sleep(2000);


        WebElement numberOfBoards = driver.findElement(By.xpath("//div[contains(text(),'Требуемое количество досок ламината: ')]"));
        Assert.assertEquals(numberOfBoards.getText(), "Требуемое количество досок ламината: 53");
        WebElement numberOfPackages = driver.findElement(By.xpath("//div[contains(text(),'Количество упаковок ламината: ')]"));
        Assert.assertEquals(numberOfPackages.getText(), "Количество упаковок ламината: 7");


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
