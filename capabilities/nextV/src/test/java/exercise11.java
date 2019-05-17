import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class exercise11 {

    private WebDriver driver;
    private String email;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
    }

    public String randomEmail() {
        String randomString = Long.toHexString(Double.doubleToLongBits(Math.random()));
        email = randomString + "@test.pl";
        return email;

    }

    @Test
    public void createNewAccount() {
        randomEmail();
        //create Account
        driver.findElement(By.xpath("//a[contains(text(),'New customers click here')]")).click();
        driver.findElement(By.name("firstname")).sendKeys("Anna");
        driver.findElement(By.name("lastname")).sendKeys("Kowalska");
        driver.findElement(By.name("address1")).sendKeys("Jasna 11");
        driver.findElement(By.name("postcode")).sendKeys("44-100");
        driver.findElement(By.name("city")).sendKeys("Opole");
        Select select = new Select(driver.findElement(By.xpath("//select[@name='country_code']")));
        select.selectByVisibleText("Poland");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("500500500");
        driver.findElement(By.name("password")).sendKeys("test1234@");
        driver.findElement(By.name("confirmed_password")).sendKeys("test1234@");
        driver.findElement(By.name("create_account")).click();

        //logout and login
        driver.findElement(By.xpath("//div[@class='content']//a[contains(text(),'Logout')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("test1234@");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//div[@class='content']//a[contains(text(),'Logout')]")).click();
    }

    @After
    public void after() {
        driver.quit();
    }
}
