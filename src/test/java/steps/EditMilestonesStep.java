package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;

public class EditMilestonesStep extends BaseStep {

    public EditMilestonesStep(WebDriver driver) {
        super(driver);
    }


    public MilestonesPage updateMilestone(String nameMilestone, String references, String parent, String description, boolean MilestoneCompletedCheckBoxButton) {
        fillMilestone(nameMilestone, references, parent, description, MilestoneCompletedCheckBoxButton);
        return milestonesPage;
    }


    public MilestonesPage deleteMilestone(String nameMilestone) {
        milestonesPage.deleteMilestoneButton(nameMilestone).click();
        milestonesPage.getAcceptConfirmationButton().click();
        return milestonesPage;
    }


    private void fillMilestone(String nameMilestone, String references, String parent, String description, boolean MilestoneCompletedCheckBoxButton) {

        //editMilestonePage.getNameMilestone().sendKeys(nameMilestone);
        editMilestonePage.getReferences().sendKeys(references);
        //addMilestonePage.getParent().sendKeys(parent);
        editMilestonePage.getDescription().sendKeys(description);
        if (MilestoneCompletedCheckBoxButton) {
            editMilestonePage.getMilestoneCompletedCheckBoxButton().click();
        }
        editMilestonePage.getSaveButton().click();
    }

}
