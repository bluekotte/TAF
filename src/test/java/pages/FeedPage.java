package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    //locators
    private SelenideElement navigationMenu = $("#navMenu");
    private SelenideElement logoutButton = $(".button.is-outlined.is-ligdht");


    //corpuscular method

    public SelenideElement getNavigationMenu() {
        return navigationMenu;
    }


    //complex method
    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage();
    }

}
