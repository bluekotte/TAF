package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllProjectsPage extends BasePage {
    private By headerTitleLabelLocator = By.xpath("//div[contains(text(),'All Projects')]");


    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getProjectNameButton(String projectName) {
        return waitsService.waitForExists(By.xpath("//a[contains(text(),'"+projectName+"')]"));
    }

}
