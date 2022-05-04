package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestonesPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/overview/1";
    private By headerTitleLabelLocator = By.className(".content-header-title");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
