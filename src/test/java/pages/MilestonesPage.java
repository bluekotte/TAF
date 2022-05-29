package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/overview/1";

    private By headerTitleLabelLocator = By.xpath("//div[contains(text(),'Milestones')]");
    private By addMilestoneButtonLocator = By.id("navigation-milestones-add");
    private By acceptConfirmationButtonLocator = By.xpath("//div[@id='deleteDialog']/div/a[contains(text(),'OK')]");
    private By cancelConfirmationButtonLocator = By.xpath("//div[@id='deleteDialog']/div/a[contains(text(),'Cancel')]");
    private By messageLocator = By.xpath("//div[contains(@class,'message-success')]");

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

    public WebElement editMilestoneButton(String milestoneName) {
        return driver.findElement(By.xpath("//div/a[text()='" + milestoneName + "']/following::div/a[text()='Edit']"));
    }

    public WebElement deleteMilestoneButton(String milestoneName) {
        return driver.findElement(By.xpath("//div/a[text()='" + milestoneName + "']/following::a[@class='deleteLink']"));
    }

    public WebElement getMessage() {
        return driver.findElement(messageLocator);
    }

    public WebElement getAcceptConfirmationButton() {
        return driver.findElement(acceptConfirmationButtonLocator);
    }

    public WebElement getCancelConfirmationButton() {
        return driver.findElement(cancelConfirmationButtonLocator);
    }

}
