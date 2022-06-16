package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public ProjectPage navigateToProjectsPage() {
        projectPage.openPageByUrl();
        return projectPage;
    }
    public DashboardPage navigateToDashboardPage() {
        dashboardPage.openPageByUrl();
        return dashboardPage;
    }
    public AddMilestonePage navigateToAddMilestonePage() {
        addMilestonePage.openPageByUrl();
        return addMilestonePage;
    }

    public MilestonesPage navigateToMilestonePage() {
        milestonesPage.openPageByUrl();
        return milestonesPage;
    }

    public EditMilestonePage editMilestone(String nameMilestone){
        milestonesPage.editMilestoneButton(nameMilestone).click();
        return editMilestonePage;
    }

}
