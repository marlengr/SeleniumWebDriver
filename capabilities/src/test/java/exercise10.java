import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class exercise10 {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void checkCathegory() {
        String firstPageName = driver.findElement(By.xpath("//div[@id='box-campaigns']//a[@class='link']")).getAttribute("title");
        String firstPageCampaignPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getAttribute("textContent");
        String firstPageRegularPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getAttribute("textContent");
        String colorOfFirstPageCampaignPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getCssValue("color");
        String colorOfFirstPageRegularPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getCssValue("color");
        String fontOfFirstPageCampaignPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getCssValue("font-weight");
        String fontOfFirstPageRegularPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getCssValue("text-decoration");
        String StyleOfFirstPageRegularPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']")).getCssValue("style");


        driver.findElement(By.xpath("//div[@id='box-campaigns']//a[@class='link']")).click();

        String secondPageName = driver.findElement(By.xpath("//a[@class='main-image fancybox zoomable shadow']//img[@class='image']")).getAttribute("title");
        String secondPageCampaignPrice = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getAttribute("textContent");
        String secondPageRegularPrice = driver.findElement(By.xpath("//s[@class='regular-price']")).getAttribute("textContent");
        String colorOfSecondPageCampaignPrice = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("color");
        String colorOfSecondPageRegularPrice = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("color");
        String fontOfSecondPageCampaignPrice = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getCssValue("font-weight");
        String fontOfSecondPageRegularPrice = driver.findElement(By.xpath("//s[@class='regular-price']")).getCssValue("text-decoration");


        Assert.assertEquals(firstPageName, secondPageName);
        Assert.assertEquals(firstPageCampaignPrice, secondPageCampaignPrice);
        Assert.assertEquals(firstPageRegularPrice, secondPageRegularPrice);
        Assert.assertEquals(colorOfFirstPageCampaignPrice, colorOfSecondPageCampaignPrice);
        Assert.assertEquals(colorOfFirstPageRegularPrice, colorOfSecondPageRegularPrice);
        Assert.assertEquals(fontOfFirstPageCampaignPrice, fontOfSecondPageCampaignPrice);
        Assert.assertEquals(fontOfFirstPageRegularPrice, fontOfSecondPageRegularPrice);
    }

    @After
    public void After() {
        driver.quit();
    }

}
