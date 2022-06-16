package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

public class AddProjectStep extends BaseStep {

    public AddProjectStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage createProject(String projectName, String announcement, boolean announcementCheckBoxButton,
                                      String suiteMode, boolean projectCompletedCheckBoxButton) {
        fillProject(projectName, announcement, announcementCheckBoxButton,
                suiteMode, projectCompletedCheckBoxButton);
        return projectsPage;
    }

    private void fillProject(String projectName, String announcement, boolean announcementCheckBoxButton,
                             String suiteMode, boolean projectCompletedCheckBoxButton) {
        addProjectPage.nameInputLocator.sendKeys(projectName);
        addProjectPage.announcementInputLocator.sendKeys(announcement);
        if (announcementCheckBoxButton) {
            addProjectPage.announcementCheckBoxLocator.click();
        }
        switch (suiteMode) {
            case ("suite_mode_single"):
                addProjectPage.singleSuiteModeRadioButtonLocator.click();
            case ("suite_mode_single_baseline"):
                addProjectPage.baselineSuiteModeRadioButtonLocator.click();
            case ("suite_mode_multi"):
                addProjectPage.multiSuiteModeRadioButtonLocator.click();
        }
        if (projectCompletedCheckBoxButton) {
            addProjectPage.projectCompletedCheckBoxButtonLocator.click();
        }
        addProjectPage.addProjectButtonLocator.click();
    }


}
