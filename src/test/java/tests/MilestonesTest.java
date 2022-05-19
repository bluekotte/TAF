package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test
    public void addMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddMilestonePage();
        addMilestoneStep.createMilestone("TestName", "Test", "1", "SomeText", false);
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void editMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone("TestName");
        milestonesStep.editMilestone("TestName", "Test", "1", "SomeText", false);
    }

    @Test(dependsOnMethods = "editMilestoneTest")
    public void readMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone("TestName");
        milestonesStep.cancel();
    }

    @Test(dependsOnMethods = "readMilestoneTest")
    public void deleteMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        milestonesStep.deleteMilestone("TestName");


    }
}
