import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class exercise17 {

    private WebDriver driver;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new ChromeDriver(options);
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void login() {
        List<WebElement> categories = driver.findElements(By.xpath("//tr/td/a[contains(@href,'catalog&category')]"));
        for (int a = 0; a < categories.size(); a++) {
            categories.get(a).click();

            List<WebElement> links = driver.findElements(By.xpath("//tr//td[3]"));
            for (int b = 0; b < links.size(); b++) {
                links = driver.findElements(By.xpath("//tr//td[3]"));
                links.get(b).click();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                for (LogEntry log : driver.manage().logs().get("browser").getAll()) System.out.println(log);
                for (LogEntry log : driver.manage().logs().get("performance").getAll()) {
                    System.out.println(log);
                    driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
                }
            }
        }
    }

    @After
    public void after() {
        driver.quit();
    }
}