package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/projects/overview/1";

    public SideMenuPage sideMenuPage;

    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Test Project')]");
    private By openMilestoneLocator = By.cssSelector("#navigation-milestones");
    public ProjectPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getOpenMilestone() {
        return waitsService.waitForExists(openMilestoneLocator);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок комплексных методов

    public MilestonesPage openMilestone() {
        getOpenMilestone().click();
        return new MilestonesPage(driver);
    }
}
