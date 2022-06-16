package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MilestonesPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/overview/1";

    @FindBy(xpath = "//div[contains(text(),'Milestones')]")
    public  WebElement headerTitleLabelLocator;

    @FindBy(id = "navigation-milestones-add")
    public WebElement addMilestoneButtonLocator;

    @FindBy(xpath = "//div[@id='deleteDialog']/div/a[contains(text(),'OK')]")
    public WebElement acceptConfirmationButtonLocator;

    @FindBy(xpath = "//div[@id='deleteDialog']/div/a[contains(text(),'Cancel')]")
    public WebElement cancelConfirmationButtonLocator;

    private By messageLocator = By.xpath("//div[contains(@class,'message-success')]");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement editMilestoneButton(String milestoneName) {
        return waitsService.waitForExists(By.xpath("//div/a[text()='" + milestoneName + "']/following::div/a[text()='Edit']"));
    }

    public WebElement deleteMilestoneButton(String milestoneName) {
        return waitsService.waitForExists(By.xpath("//div/a[text()='" + milestoneName + "']/following::a[@class='deleteLink']"));
    }

    public WebElement getMessage() {
        return waitsService.waitForExists(messageLocator);
    }

}
