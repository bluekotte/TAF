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
        editMilestonePage.getNameMilestone().clear();
        editMilestonePage.getNameMilestone().sendKeys(nameMilestone);
        editMilestonePage.getReferences().clear();
        editMilestonePage.getReferences().sendKeys(references);
        //addMilestonePage.getParent().sendKeys(parent);
        editMilestonePage.getDescription().clear();
        editMilestonePage.getDescription().sendKeys(description);
        if (MilestoneCompletedCheckBoxButton) {
            editMilestonePage.getMilestoneCompletedCheckBoxButton().click();
        }
        editMilestonePage.getSaveButton().click();
    }

    public String getMilestoneName(){
        return editMilestonePage.getNameMilestone().getAttribute("value");
    }

    public String getParent(){
        return editMilestonePage.getParent().getAttribute("value");
    }

    public String getReference(){
        return editMilestonePage.getReferences().getText();
    }

    public String getDescription(){
        return editMilestonePage.getDescription().getText();
    }

}
