package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage navigateToProjectsPage() {
        projectsPage.openPageByUrl();
        return projectsPage;
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
