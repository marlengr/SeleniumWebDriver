import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class exercise9b {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void checkSortOfGeoZones(){

        List<WebElement> getGeoZones = driver.findElements((By.xpath("//tr/td[3]/a[contains(@href,'geo')]")));
        List<String> listOfGeoZonesString = getGeoZones.stream().map(WebElement::getText).collect(Collectors.toList());
        //List<Integer> listOfGeoZonesInt = listOfGeoZonesString.stream().map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i <= listOfGeoZonesString.size(); i++){
            List<WebElement> getGeoZonesFor = driver.findElements((By.xpath("//tr/td[3]/a[contains(@href,'geo')]")));
            getGeoZonesFor.get(i).click();
            List<WebElement> listOfZonesInGeoZones = driver.findElements((By.cssSelector("#table-zones [name*=zone_code]")));
            List<String> listOfZonesInGeoZonesString = listOfZonesInGeoZones.stream().map(WebElement::getText).collect(Collectors.toList());
            System.out.println(listOfZonesInGeoZonesString);
        }


    }

}
