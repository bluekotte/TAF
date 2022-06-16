package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditMilestonePage extends AddMilestonePage {

    @FindBy(css = ".content-header-title.page_title")
    public WebElement headerTitleLabelLocator;

    @FindBy(css = "button[id=accept]")
    public WebElement saveButtonLocator;

    @FindBy(xpath = "//div[contains(@class,'form-buttons')]/a")
    public WebElement cancelButtonLocator;


    public EditMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelLocator;
    }
}
