import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertEquals;

public class exercise8 {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void checkStickers() {
        List<WebElement> ducksy;
        ducksy = driver.findElements(By.cssSelector("[class=image-wrapper]"));
        for (int i = 0; i < ducksy.size(); i++) {
            WebElement ducks;
            List<WebElement> sticker;
            ducks = driver.findElement(By.cssSelector("[class=image-wrapper]"));
            sticker = ducks.findElements(By.cssSelector("[class^=sticker]"));
            assertEquals(1, sticker.size());
            System.out.println("Number of stickers: " + sticker.size());
        }
    }

    @After
    public void after() {
        driver.quit();
    }

}