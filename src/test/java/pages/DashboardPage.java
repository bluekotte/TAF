package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    public TopMenuPage topMenuPage;

    // Блок описания селекторов для элементов
    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");
    private By addProjectLocator = By.cssSelector(".sidebar-button");

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return waitsService.waitForExists(headerTitleLabelLocator);
    }

    public WebElement addProject() {
        return waitsService.waitForExists(addProjectLocator);
    }

    public WebElement getProjectByName(String projectName) {
        return waitsService.waitForExists(By.xpath("//a[contains(text(),'" + projectName + "')]"));
    }

    // Блок комплексных методов
    public ProjectPage projectSelection(String projectName) {
        getProjectByName(projectName).click();
        return new ProjectPage(driver);
    }
}
