import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logIn {

    private WebDriver driver;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C://Users/Kordian/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/login.php");
    }

    @Test
    public void test(){
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void after(){
        driver.quit();
        driver = null;
    }
}
