package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;

public class DashboardStep extends BaseStep {
    public DashboardStep(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage successAddProject() {
        addProject();
        return addProjectPage;
    }

    private void addProject() {
        dashboardPage.addProject().click();
    }
}
