import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ie.*;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        //System.setProperty("webdriver.ie.driver", "C://Users/Kordian/driver/IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
        //wait = new WebDriverWait(driver, 10);
        //System.setProperty("webdriver.chrome.driver", "C://Users/Kordian/driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
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
