package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MilestonesTest extends BaseTest {

    @Test(description = "add Milestone Test")
    @Description("Add Milestone")
    public void addMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddMilestonePage();
        Assert.assertEquals(addMilestoneStep.createMilestone("Test_1", "reference_1",
                        "description_1",
                        false).getMessage().getText(),
                "Successfully added the new milestone.");
    }


    @Test(dependsOnMethods = "addMilestoneTest", description = "read Milestone After Create Test")
    @Description("read after create")
    public void readMilestoneAfterCreateTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone("Test_1");
        Assert.assertEquals(editMilestonesStep.getMilestoneName(), "Test_1");
        Assert.assertEquals(editMilestonesStep.getDescription(), "description_1");
    }

    @Test(dependsOnMethods = "addMilestoneTest", description = "update Milestone Test")
    @Description("update")
    public void updateMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone("Test_1");

        Assert.assertEquals(editMilestonesStep.updateMilestone("Test_2", "reference_2",
                "description_2",
                false).getMessage().getText(), "Successfully updated the milestone.");


    }

    @Test(dependsOnMethods = "updateMilestoneTest", description = "read Milestone After Update Test")
    @Description("read after update")
    public void readMilestoneAfterUpdateTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        navigationStep.editMilestone("Test_2");
        Assert.assertEquals(editMilestonesStep.getMilestoneName(), "Test_2");
        Assert.assertEquals(editMilestonesStep.getDescription(), "description_2");
    }

    @Test(dependsOnMethods = "readMilestoneAfterUpdateTest", description = "delete Milestone Test")
    @Description("delete Milestone")
    public void deleteMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonePage();
        Assert.assertEquals(editMilestonesStep.deleteMilestone("Test_2").getMessage().getText(),
                "Successfully deleted the milestone (s).");
    }
}
