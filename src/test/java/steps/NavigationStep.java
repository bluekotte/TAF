package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.ProjectsPage;

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

}
