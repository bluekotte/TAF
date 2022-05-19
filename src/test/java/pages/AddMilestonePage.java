package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/1";

    private By headerTitleLabelLocator = By.xpath("//div[contains(text(),'Add Milestone')]");
    private By nameMilestoneLocator = By.xpath("//input[@id='name']");
    private By referencesLocator = By.xpath("//input[@id='reference']");
    private By parentLocator = By.xpath("//div[@id='parent_id_chzn']");
    private By descriptionLocator = By.xpath("//div[@id='description_display']");
    private By startDateLocator = By.id("start_on");
    private By endDateLocator = By.id("due_on");
    private By milestoneCompletedCheckBoxButtonLocator = By.xpath("//input[@id='is_completed']");
    private By addMilestoneButtonLocator = By.xpath("//button[@id='accept']");




    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getNameMilestone() {
        return driver.findElement(nameMilestoneLocator);
    }
    public WebElement getReferences() {
        return driver.findElement(referencesLocator);
    }
    public WebElement getParent() {
        return driver.findElement(parentLocator);
    }
    public WebElement getDescription() {
        return driver.findElement(descriptionLocator);
    }
    public WebElement getStartDate() {
        return driver.findElement(startDateLocator);
    }
    public WebElement getEndDate() {
        return driver.findElement(endDateLocator);
    }
    public WebElement getMilestoneCompletedCheckBoxButton() {
        return driver.findElement(milestoneCompletedCheckBoxButtonLocator);
    }
    public WebElement getAddMilestoneButton() {
        return driver.findElement(addMilestoneButtonLocator);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
