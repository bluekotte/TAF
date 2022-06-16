package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;

public class AddMilestoneStep extends BaseStep {
    public AddMilestoneStep(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage createMilestone(String nameMilestone, String references,
                                          String description, boolean MilestoneCompletedCheckBoxButton) {
        fillMilestone(nameMilestone, references, description, MilestoneCompletedCheckBoxButton);
        return milestonesPage;
    }

    @Step("add milestone with name {nameMilestone}")
    private void fillMilestone(String nameMilestone, String references,
                               String description, boolean MilestoneCompletedCheckBoxButton) {
        addMilestonePage.getNameMilestone().sendKeys(nameMilestone);
        addMilestonePage.getReferences().sendKeys(references);
        addMilestonePage.getDescription().sendKeys(description);
        if (MilestoneCompletedCheckBoxButton) {
            addMilestonePage.getMilestoneCompletedCheckBoxButton().click();
        }
        addMilestonePage.getAddMilestoneButton().click();
    }
}
