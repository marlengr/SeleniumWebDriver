import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class exercise14 {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void checkNewFrame() {
        driver.findElement(By.xpath(" //span[contains(text(),'Countries')]")).click();
        driver.findElement(By.xpath("//a[@class='button']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//td//i[@class='fa fa-external-link']"));
        String mainWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            for (String newHandle : driver.getWindowHandles()) {
                if (newHandle.equals(mainWindow)) {
                } else {
                    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
                    driver.switchTo().window(newHandle).close();
                    driver.switchTo().window(mainWindow);
                }
            }
        }
    }

    @After
    public void after() {
        driver.quit();
    }
}
