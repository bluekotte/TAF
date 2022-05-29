package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();
    }

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String resourceName = "download.png";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        String pathToFile = file.getAbsolutePath();

        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();
        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.xpath("//div/h3[text()='File Uploaded!']")).isDisplayed());
    }

    @Test
    public void contextMenuText() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement box = wait.waitForExists(By.id("hot-spot"));
        actions.moveToElement(box)
                .contextClick()
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();

        Thread.sleep(2000);
    }

    @Test
    public void dynamicControlsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Actions actions = new Actions(driver);

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement checkBox = wait.waitForExists(By.xpath("//div/input"));
        actions.moveToElement(checkBox)
                .click()
                .build()
                .perform();
        WebElement removeButton = wait.waitForExists(By.xpath("//button[text()='Remove']"));
        actions.moveToElement(removeButton)
                .click()
                .build()
                .perform();

        WebElement loading = wait.waitForExists(By.xpath("//div[text()='Wait for it... ']"));

        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(wait.waitForElementInvisible(loading));
        Assert.assertTrue(wait.waitForElementInvisible(checkBox));
        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.xpath("//form/p")).isDisplayed());


        WebElement input = wait.waitForExists(By.xpath("//form/input"));
        Assert.assertFalse(input.isEnabled());
        actions.moveToElement(input)
                .click()
                .build()
                .perform();

        WebElement enableButton = wait.waitForExists(By.xpath("//*[text()='Enable']"));
        enableButton.click();

        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.xpath("//form/p")).isDisplayed());
        Assert.assertTrue(input.isEnabled());
    }
}
