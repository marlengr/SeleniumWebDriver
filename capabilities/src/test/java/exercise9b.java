import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
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
    public void checkZonesSorting() {

        int countriesSize = driver.findElements((By.xpath("//tr/td[3]/a[contains(@href,'geo')]"))).size();
        for (int i = 0; i < countriesSize; i++) {

            List<WebElement> listOfCountries = driver.findElements((By.xpath("//tr/td[3]/a[contains(@href,'geo')]")));
            listOfCountries.get(i).getText();
            listOfCountries.get(i).click();
            List<WebElement> geoZones = driver.findElements(By.cssSelector("[name*=zone_code]"));
            List<String> sortedGeoZoneList = new ArrayList<String>();

            for (int j = 0; j < geoZones.size(); j++) {

                String geoZoneName = geoZones.get(j).getAttribute("value");
                sortedGeoZoneList.add(geoZoneName);
            }
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            List<String> geoZoneList = new ArrayList<String>(sortedGeoZoneList);
            Collections.sort(sortedGeoZoneList);
            Assert.assertEquals(sortedGeoZoneList, geoZoneList);
        }
    }

    @After
    public void after(){
        driver.quit();
    }

}
