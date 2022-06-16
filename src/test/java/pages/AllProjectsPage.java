package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProjectsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'All Projects')]")
    public WebElement headerTitleLabelLocator;


    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getProjectNameButton(String projectName) {
        return waitsService.waitForExists(By.xpath("//a[contains(text(),'"+projectName+"')]"));
    }

}
