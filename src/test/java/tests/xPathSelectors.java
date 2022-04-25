package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class xPathSelectors {
    private WebDriver driver;

    @Test
    public void basicXpathSelectors() {

        driver.get(ReadProperties.getUrl());

        //Абсолютный xPath (так никогда не делать. Вообще никогда)
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[5]/div[2]/div/div[2]/div[2]/a[2]")).isDisplayed());


        //все элементы на странице начиная с HTML
        Assert.assertTrue(driver.findElement(By.xpath("//*")).isDisplayed());

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // поиск родительского div и на один уровень ниже h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());


        // поиск родительского div и на любом уровень ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());


        // поиск элемента с тэгом div, у которого есть атрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // поиск элемента, у которого есть атрибут id со значением top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());


        // поиск элемента, у которого есть атрибут method со значением и атрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target = '_blank']")).isDisplayed());


        // поиск элемента, у которого значение атрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id,'new')]")).isDisplayed());


        // поиск элемента, у которого значение атрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'Template')]")).isDisplayed());

        // поиск элемента, у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'All Projects']")).isDisplayed());

        // поиск элемента, у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Projects')]")).isDisplayed());

    }

    @Test
    public void axesXPathTest() {
        driver.get(ReadProperties.getUrl());


        //поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        //поиск всех предков с тэго div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэгом a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());


        // Использование following - выбирает всЁ в документу после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());



        // Использование preceding - выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding::form")).isDisplayed());


        // Использование following-sibling - выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath(" //*[@class='dialog-title']/following-sibling::form")).isDisplayed());


    }
}
