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
        addMilestoneStep.createMilestone(ReadProperties.milestoneName1(), ReadProperties.reference1(), ReadProperties.parent1(), ReadProperties.description1(), ReadProperties.competed1());
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void readMilestoneAfterCreateTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone(ReadProperties.milestoneName1());
        Assert.assertEquals(editMilestonesStep.getMilestoneName(),ReadProperties.milestoneName1());
        //Assert.assertEquals(editMilestonesStep.getParent(),ReadProperties.parent1());
        Assert.assertEquals(editMilestonesStep.getDescription(),ReadProperties.description1());
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void updateMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone(ReadProperties.milestoneName1());
        editMilestonesStep.updateMilestone(ReadProperties.milestoneName2(), ReadProperties.reference2(), ReadProperties.parent2(), ReadProperties.description2(), ReadProperties.competed2());
    }

    @Test(dependsOnMethods = "updateMilestoneTest")
    public void readMilestoneAfterUpdateTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone(ReadProperties.milestoneName2());
        Assert.assertEquals(editMilestonesStep.getMilestoneName(),ReadProperties.milestoneName2());
        //Assert.assertEquals(editMilestonesStep.getParent(),ReadProperties.parent1());
        Assert.assertEquals(editMilestonesStep.getDescription(),ReadProperties.description2());
    }

    @Test(dependsOnMethods = "readMilestoneAfterUpdateTest")
    public void deleteMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        editMilestonesStep.deleteMilestone(ReadProperties.milestoneName2());
    }
}
