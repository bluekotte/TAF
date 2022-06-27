package tests.gui;

import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("logout")
public class LogoutTest extends BaseTest {
    @Test(description = "logout Test")
    public void logoutTest() {
        new LoginPage().successLogin(ReadProperties.username(), ReadProperties.password())
                .logout().getButton().shouldBe(Condition.exist);
    }
}
