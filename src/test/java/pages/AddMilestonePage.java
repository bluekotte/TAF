package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/1";

    @FindBy(xpath = "//div[contains(text(),'Add Milestone')]")
    public WebElement headerTitleLabelLocator;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameMilestoneLocator;

    @FindBy(xpath = "//input[@id='reference']")
    public WebElement referencesLocator;

    @FindBy(xpath = "//div[@id='description_display']")
    public WebElement descriptionLocator;

    @FindBy(xpath = "//input[@id='is_completed']")
    public WebElement milestoneCompletedCheckBoxButtonLocator;

    @FindBy(xpath = "//button[@id='accept']")
    public WebElement addMilestoneButtonLocator;


    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
