package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test
    public void addMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddMilestonePage();
        addMilestoneStep.createMilestone("TestName", "Test", "1", "SomeText", false);
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void updateMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone("TestName");
        editMilestonesStep.updateMilestone("TestName", "Test", "1", "SomeText", false);
    }

    @Test(dependsOnMethods = "editMilestoneTest")
    public void readMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone("TestName");
    }

    @Test(dependsOnMethods = "readMilestoneTest")
    public void deleteMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        editMilestonesStep.deleteMilestone("TestName");
    }
}
