package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/1";

    private By headerTitleLabelLocator = By.xpath("//div[contains(text(),'Add Milestone')]");
    private By nameMilestoneLocator = By.xpath("//input[@id='name']");
    private By referencesLocator = By.xpath("//input[@id='reference']");
    private By descriptionLocator = By.xpath("//div[@id='description_display']");
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
        return waitsService.waitForExists(nameMilestoneLocator);
    }
    public WebElement getReferences() {
        return waitsService.waitForExists(referencesLocator);
    }
    public WebElement getDescription() {
        return waitsService.waitForExists(descriptionLocator);
    }
    public WebElement getMilestoneCompletedCheckBoxButton() {
        return waitsService.waitForExists(milestoneCompletedCheckBoxButtonLocator);
    }
    public WebElement getAddMilestoneButton() {
        return waitsService.waitForExists(addMilestoneButtonLocator);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок комплексных методов


    public MilestonesPage createMilestone(String nameMilestone, String references,
                                          String description, boolean MilestoneCompletedCheckBoxButton) {
        fillMilestone(nameMilestone, references, description, MilestoneCompletedCheckBoxButton);
        return new MilestonesPage(driver);
    }

    @Step("add milestone with name {nameMilestone}")
    private void fillMilestone(String nameMilestone, String references,
                               String description, boolean MilestoneCompletedCheckBoxButton) {
        getNameMilestone().sendKeys(nameMilestone);
        getReferences().sendKeys(references);
        getDescription().sendKeys(description);
        if (MilestoneCompletedCheckBoxButton) {
            getMilestoneCompletedCheckBoxButton().click();
        }
        getAddMilestoneButton().click();
    }

}
