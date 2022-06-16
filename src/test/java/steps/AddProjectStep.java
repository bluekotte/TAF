package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectPage;

public class AddProjectStep extends BaseStep {

    public AddProjectStep(WebDriver driver) {
        super(driver);
    }

    public ProjectPage createProject(String projectName, String announcement, boolean announcementCheckBoxButton,
                                     String suiteMode, boolean projectCompletedCheckBoxButton) {
        fillProject(projectName, announcement, announcementCheckBoxButton,
                suiteMode, projectCompletedCheckBoxButton);
        return projectPage;
    }

    private void fillProject(String projectName, String announcement, boolean announcementCheckBoxButton,
                             String suiteMode, boolean projectCompletedCheckBoxButton) {
        addProjectPage.getNameInput().sendKeys(projectName);
        addProjectPage.getAnnouncementInput().sendKeys(announcement);
        if (announcementCheckBoxButton) {
            addProjectPage.getAnnouncementCheckBox().click();
        }
        switch (suiteMode) {
            case ("suite_mode_single"):
                addProjectPage.getSingleSuiteModeRadioButton().click();
            case ("suite_mode_single_baseline"):
                addProjectPage.getBaselineSuiteModeRadioButton().click();
            case ("suite_mode_multi"):
                addProjectPage.getMultiSuiteModeRadioButton().click();
        }
        if (projectCompletedCheckBoxButton) {
            addProjectPage.getProjectCompletedCheckBoxButton().click();
        }
        addProjectPage.getAddProjectButton().click();
    }


}
