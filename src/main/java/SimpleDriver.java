import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Valera\\QA18\\TAF\\src\\test\\java\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
