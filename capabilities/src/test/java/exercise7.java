import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static junit.framework.TestCase.assertTrue;

public class exercise7 {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Test
    public void checkMenu() {

        List<WebElement> menu;
        List<WebElement> insideMenu;

        menu = driver.findElements(By.cssSelector("[id^=app-]"));
        for (int i = 0; i < menu.size(); i++) {
            menu = driver.findElements(By.cssSelector("[id^=app-]"));
            menu.get(i).click();
            menu = driver.findElements(By.cssSelector("[id^=app-]"));
            assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

            if (driver.findElements(By.cssSelector("[id^=doc-]")).size() > 0) {
                insideMenu = driver.findElements(By.cssSelector("[id^=doc-]"));
                for (int j = 0; j < insideMenu.size(); j++) {
                    insideMenu = driver.findElements(By.cssSelector("[id^=doc-]"));
                    insideMenu.get(j).click();
                    assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
                }
            }

        }
    }

    @After
    public void after() {
        driver.quit();
    }

}