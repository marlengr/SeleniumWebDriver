import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exercise13 {

    private WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 10);

    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void addProduct(){
        for (int j = 0 ; j <= 3; j++) {
            driver.findElement(By.xpath("//div[@id='box-most-popular']//li[10]//a[1]//div[3]")).click();
            driver.findElement(By.name("add_cart_product")).click();
            String actualCartQuantity = driver.findElement(By.cssSelector("span.quantity")).getText();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), actualCartQuantity));
            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
        }
    }

    public void removeProduct() {
        for (int i = 0; i <= 3; i++) {
            driver.findElement(By.name("remove_cart_item")).click();
            
        }
    }

    @After
    public void after(){
        driver.quit();
    }
}
