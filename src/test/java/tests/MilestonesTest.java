package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test
    public void addMilestone() {
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationStep.navigateToAddMilestonePage();
        addMilestoneStep.createMilestone("1","1","1","1",false);
    }
}
