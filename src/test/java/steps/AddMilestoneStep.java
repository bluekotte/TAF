package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;

public class AddMilestoneStep extends BaseStep {
    public AddMilestoneStep(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage createMilestone(String nameMilestone, String references, String parent,
                                          String description, boolean MilestoneCompletedCheckBoxButton) {
        fillMilestone(nameMilestone, references, parent,
                description, MilestoneCompletedCheckBoxButton);
        return milestonesPage;
    }

    private void fillMilestone(String nameMilestone, String references, String parent,
                               String description, boolean MilestoneCompletedCheckBoxButton) {
        addMilestonePage.getNameMilestone().sendKeys(nameMilestone);
        addMilestonePage.getReferences().sendKeys(references);
        //addMilestonePage.getParent().sendKeys(parent);
        addMilestonePage.getDescription().sendKeys(description);
        if (MilestoneCompletedCheckBoxButton) {
            addMilestonePage.getMilestoneCompletedCheckBoxButton().click();
        }
        addMilestonePage.getAddMilestoneButton().click();
    }
}
