package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    public TopMenuPage topMenuPage;

    // Блок описания селекторов для элементов
    @FindBy(xpath = "//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]")
    public WebElement headerTitleLabelLocator;
    @FindBy(css = ".sidebar-button")
    public WebElement addProjectLocator;

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return getHeaderTitleLabel();
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return headerTitleLabelLocator;
    }
}
