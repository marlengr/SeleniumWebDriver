import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
        for (int j = 0 ; j < 3; j++) {
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebDriverWait wait1 = new WebDriverWait(driver, 10);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Purple Duck')]")));
            driver.findElement(By.xpath("//div[contains(text(),'Purple Duck')]")).click();
            driver.findElement(By.name("add_cart_product")).click();
            String actualCartQuantity = driver.findElement(By.cssSelector("span.quantity")).getText();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), actualCartQuantity));
            driver.get("http://localhost/litecart/");
        }
        removeProduct();
    }

    public void removeProduct() {
        for (int i = 2; i >= 0; i++) {
            driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
            driver.findElement(By.xpath("//input[@name='quantity']")).clear();
            String iString = new Integer(i).toString();
            driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(iString);
            driver.findElement(By.name("update_cart_item")).click();
            String removeQuantity = iString;
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='box-checkout-summary']")), removeQuantity));
            System.out.println(removeQuantity);

        }
    }

    @After
    public void after(){
        driver.quit();
    }
}
