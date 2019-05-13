import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class capabilities {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("unexpectedAlertBehaviour", "dismiss");
//        dc.setCapability(chromeOptions.CAPABILITY, options);
//        driver = new ChromeDriver(dc);
//        System.out.println(((HasCapabilities) driver).getCapabilities());
//        wait = new WebDriverWait(driver, 10);
        // przekazywanie informacji bezpośrednio do przeglądarki
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-fullscreen");
//        driver = new ChromeDriver(options);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Firefox Nightly/firefox.exe");
        driver = new FirefoxDriver(options);
    }
    @Test
    public void myFirstTest(){
        driver.get("http://www.facebook.com");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
