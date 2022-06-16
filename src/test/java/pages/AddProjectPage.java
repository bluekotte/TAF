package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private By headerTitleLabelLocator = By.xpath("//div[contains(text(),'Add Project')]");
    private By nameInputLocator = By.cssSelector("input.form-control#name");
    private By announcementInputLocator = By.cssSelector("textarea#announcement");
    private By announcementCheckBoxLocator = By.cssSelector("input#show_announcement");
    private By singleSuiteModeRadioButtonLocator = By.cssSelector("input#suite_mode_single");
    private By baselineSuiteModeRadioButtonLocator = By.cssSelector("input#suite_mode_single_baseline");
    private By multiSuiteModeRadioButtonLocator = By.cssSelector("input#suite_mode_multi");
    private By projectCompletedCheckBoxButtonLocator = By.cssSelector("is_completed");
    private By addProjectButtonLocator = By.cssSelector("#accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getNameInput() {
        return waitsService.waitForExists(nameInputLocator);
    }

    public WebElement getAnnouncementInput() {
        return waitsService.waitForExists(announcementInputLocator);
    }

    public WebElement getAnnouncementCheckBox() {
        return waitsService.waitForExists(announcementCheckBoxLocator);
    }

    public WebElement getSingleSuiteModeRadioButton() {
        return waitsService.waitForExists(singleSuiteModeRadioButtonLocator);
    }

    public WebElement getBaselineSuiteModeRadioButton() {
        return waitsService.waitForExists(baselineSuiteModeRadioButtonLocator);
    }

    public WebElement getMultiSuiteModeRadioButton() {
        return waitsService.waitForExists(multiSuiteModeRadioButtonLocator);
    }

    public WebElement getProjectCompletedCheckBoxButton() {
        return waitsService.waitForExists(projectCompletedCheckBoxButtonLocator);
    }

    public WebElement getAddProjectButton() {
        return waitsService.waitForExists(addProjectButtonLocator);
    }

}
