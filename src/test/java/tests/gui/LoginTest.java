package tests.gui;

import configuration.ReadProperties;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

@Epic("login")
public class LoginTest extends BaseTest{



    @Test(description = "success login")
    public void loginTest() {

        new LoginPage().successLogin(ReadProperties.username(), ReadProperties.password())
                .getNavigationMenu()
                .shouldBe(exist);
    }

    @Test(description = "login with incorrect email")
    public void incorrectEmail() throws InterruptedException {

        new LoginPage().inCorrectLogin("test", ReadProperties.password())
                .getIncorrectEmail()
                .shouldHave(text("Invalid email address"));
    }

    @Test(description = "login with incorrect password")
    public void incorrectPSW() throws InterruptedException {

        new LoginPage().inCorrectLogin(ReadProperties.username(), "test")
                .getIncorrectPsw()
                .shouldHave(text("Your email or password is wrong"));
    }
}
