package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditMilestonePage extends AddMilestonePage {
    private By headerTitleLabelLocator = By.cssSelector(".content-header-title.page_title");
    private By saveButtonLocator = By.cssSelector("button[id=accept]");
    private By cancelButtonLocator = By.xpath("//div[contains(@class,'form-buttons')]/a");


    public EditMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getSaveButton() {
        return waitsService.waitForExists(saveButtonLocator);
    }

    public WebElement getCancelButton() {
        return waitsService.waitForExists(cancelButtonLocator);
    }
}
