import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Random;

public class exercise12 {

    private WebDriver driver;
    private String articleName;

    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public String createArticleName(){
        Random random = new Random();
        int randomNumber = random.nextInt(99999);
        articleName = "Product_" + randomNumber;
        return articleName;
    }

    @Test
    public void addNewArticle(){
        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Catalog')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add New Product')]")).click();
        createArticleName();

        //general
        List<WebElement> radioButton = driver.findElements(By.name("status"));
        radioButton.get(0).click();
        driver.findElement(By.name("name[en]")).sendKeys(articleName);
        driver.findElement(By.name("code")).sendKeys("12345678");
        List<WebElement> checkBoxCategories = driver.findElements(By.name("categories[]"));
        checkBoxCategories.get(1);
        driver.findElement(By.cssSelector("[name='product_groups[]'][value='1-2']")).click();
        driver.findElement(By.name("product_groups[]")).getAttribute("value");
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("11,5");
        driver.findElement(By.name("date_valid_from")).sendKeys("01012019");
        driver.findElement(By.name("date_valid_to")).sendKeys("01012021");


        //information
        driver.findElement(By.xpath("//a[contains(text(),'Information')]")).click();
        driver.findElement(By.cssSelector("select[name=manufacturer_id]")).sendKeys("ACME" + Keys.ENTER);
        driver.findElement(By.name("keywords")).sendKeys("keyword test");
        driver.findElement(By.name("short_description[en]")).sendKeys("short description test");
        driver.findElement(By.xpath("//div[@class='trumbowyg-editor']")).sendKeys("description test");
        driver.findElement(By.name("head_title[en]")).sendKeys("head title test");
        driver.findElement(By.name("meta_description[en]")).sendKeys("meta description test");

        //prices
        driver.findElement(By.xpath("//a[contains(text(),'Prices')]")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("11,99");
        driver.findElement(By.xpath("//option[contains(text(),'US Dollars')]")).click();
        driver.findElement(By.name("prices[USD]")).sendKeys("10");
        driver.findElement(By.name("prices[EUR]")).sendKeys("10");

        driver.findElement(By.name("save")).click();
        checkNewArticle();
    }

    //check new article
    public void checkNewArticle(){
        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Catalog')]")).click();
        String foundArticleName = driver.findElement(By.linkText(articleName)).getText();
        Assert.assertEquals(foundArticleName, articleName);
        System.out.println(foundArticleName);
    }

    @After
    public void after(){
        driver.quit();
    }
}
