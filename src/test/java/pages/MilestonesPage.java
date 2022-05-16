package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/overview/3";

    private By headerTitleLabelLocator = By.xpath("//div[contains(text(),'Milestones')]");
    private By addMilestoneButtonLocator = By.id("navigation-milestones-add");

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

    public WebElement getAddMilestoneButton() {
        return driver.findElement(addMilestoneButtonLocator);
    }

}
