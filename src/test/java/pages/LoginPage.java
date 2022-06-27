package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {


    // Locators
    private SelenideElement email = $("[type='text']");
    private SelenideElement psw = $("[type='password']");
    private SelenideElement loginButton = $(".button.is-vcentered");

    private SelenideElement incorrectEmail = $(".notification.is-danger.is-small");
    private SelenideElement incorrectPsw = $(".notification.is-danger");


    // corpuscular methods
    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getPsw() {
        return psw;
    }

    public SelenideElement getButton() {
        return loginButton;
    }

    public SelenideElement getIncorrectEmail() {
        return incorrectEmail;
    }

    public SelenideElement getIncorrectPsw() {
        return incorrectPsw;
    }


    //complex methods
    public LoginPage inCorrectLogin(String inCorrectEmail, String incorrectPsw) {
        login(inCorrectEmail, incorrectPsw);
        return this;
    }


    public FeedPage successLogin(String email, String psw) {
        login(email, psw);
        return new FeedPage();
    }

    public void login(String email, String psw){
        open(ReadProperties.getUrl());
        getEmail().setValue(email);
        getPsw().setValue(psw);
        loginButton.click();
    }
}
