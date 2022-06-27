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

    // Блок комплексных методов

    public MilestonesPage updateMilestone(String nameMilestone, String references, String description,
                                          boolean MilestoneCompletedCheckBoxButton) {
        fillMilestone(nameMilestone, references, description, MilestoneCompletedCheckBoxButton);
        return new MilestonesPage(driver);
    }


    public MilestonesPage deleteMilestone(String nameMilestone) {
        MilestonesPage.deleteMilestoneButton(nameMilestone).click();
        milestonesPage.getAcceptConfirmationButton().click();
        return new MilestonesPage(driver);
    }


    private void fillMilestone(String nameMilestone, String references, String description,
                               boolean MilestoneCompletedCheckBoxButton) {
        getNameMilestone().clear();
        getNameMilestone().sendKeys(nameMilestone);
        getReferences().clear();
        getReferences().sendKeys(references);
        editMilestonePage.getDescription().clear();
        editMilestonePage.getDescription().sendKeys(description);
        if (MilestoneCompletedCheckBoxButton) {
            editMilestonePage.getMilestoneCompletedCheckBoxButton().click();
        }
        editMilestonePage.getSaveButton().click();
    }

    public String getMilestoneName() {

        return getNameMilestone().getAttribute("value");
    }

    public String getReference() {
        return getReferences().getText();
    }

    public String getDescription() {
        return getDescription().getText();
    }

}
