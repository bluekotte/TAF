package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;

public class EditMilestonesStep extends BaseStep {

    public EditMilestonesStep(WebDriver driver) {
        super(driver);
    }


    public MilestonesPage updateMilestone(String nameMilestone, String references, String description,
                                          boolean MilestoneCompletedCheckBoxButton) {
        fillMilestone(nameMilestone, references, description, MilestoneCompletedCheckBoxButton);
        return milestonesPage;
    }


    public MilestonesPage deleteMilestone(String nameMilestone) {
        milestonesPage.deleteMilestoneButton(nameMilestone).click();
        milestonesPage.acceptConfirmationButtonLocator.click();
        return milestonesPage;
    }


    private void fillMilestone(String nameMilestone, String references, String description,
                               boolean MilestoneCompletedCheckBoxButton) {
        editMilestonePage.nameMilestoneLocator.clear();
        editMilestonePage.nameMilestoneLocator.sendKeys(nameMilestone);
        editMilestonePage.referencesLocator.clear();
        editMilestonePage.referencesLocator.sendKeys(references);
        editMilestonePage.descriptionLocator.clear();
        editMilestonePage.descriptionLocator.sendKeys(description);
        if (MilestoneCompletedCheckBoxButton) {
            editMilestonePage.milestoneCompletedCheckBoxButtonLocator.click();
        }
        editMilestonePage.saveButtonLocator.click();
    }

    public String getMilestoneName() {
        return editMilestonePage.nameMilestoneLocator.getAttribute("value");
    }

    public String getReference() {
        return editMilestonePage.referencesLocator.getText();
    }

    public String getDescription() {
        return editMilestonePage.descriptionLocator.getText();
    }

}
