import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Valera\\QA18\\TAF\\src\\test\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(getChromeOptions());
        return driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(ReadProperties.isHeadless());
        chromeOptions.addArguments("--disable-gpu");
        //chromeOptions.addArguments("--window-size=1920,1200");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }
}
