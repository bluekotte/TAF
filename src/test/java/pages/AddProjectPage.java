package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Add Project')]")
    public WebElement headerTitleLabelLocator;

    @FindBy(css = "input.form-control#name")
    public WebElement nameInputLocator;

    @FindBy(css = "textarea#announcement")
    public WebElement announcementInputLocator;

    @FindBy(css = "input#show_announcement")
    public WebElement announcementCheckBoxLocator;

    @FindBy(css = "input#suite_mode_single")
    public WebElement singleSuiteModeRadioButtonLocator;

    @FindBy(css = "input#suite_mode_single_baseline")
    public WebElement baselineSuiteModeRadioButtonLocator;

    @FindBy(css = "input#suite_mode_multi")
    public WebElement multiSuiteModeRadioButtonLocator;

    @FindBy(css = "is_completed")
    public WebElement projectCompletedCheckBoxButtonLocator;

    @FindBy(css = "#accept")
    public WebElement addProjectButtonLocator;

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelLocator;
    }
}
