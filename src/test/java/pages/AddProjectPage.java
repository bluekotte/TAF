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
        return driver.findElement(nameInputLocator);
    }

    public WebElement getAnnouncementInput() {
        return driver.findElement(announcementInputLocator);
    }

    public WebElement getAnnouncementCheckBox() {
        return driver.findElement(announcementCheckBoxLocator);
    }

    public WebElement getSingleSuiteModeRadioButton() {
        return driver.findElement(singleSuiteModeRadioButtonLocator);
    }

    public WebElement getBaselineSuiteModeRadioButton() {
        return driver.findElement(baselineSuiteModeRadioButtonLocator);
    }

    public WebElement getMultiSuiteModeRadioButton() {
        return driver.findElement(multiSuiteModeRadioButtonLocator);
    }

    public WebElement getProjectCompletedCheckBoxButton() {
        return driver.findElement(projectCompletedCheckBoxButtonLocator);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }

}
