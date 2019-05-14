import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class exercise9 {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void checkListOfCountries() {
        List<WebElement> getCountries = driver.findElements((By.xpath("//tr/td[5]/a[contains(@href,'countries')]")));
        //convert to list<string>
        List<String> listOfCountries = getCountries.stream().map(WebElement::getText).collect(Collectors.toList());
        //convert to ArrayList
        Collections.sort(listOfCountries);
        List<String> sortedCountries = new ArrayList<String>(listOfCountries);
        //assercja porównuje posortowane alfabetycznie kraje z tymi na stronie
        Assert.assertEquals(listOfCountries, sortedCountries);

        //zapisanie do listy webElementow strefy dla państw, parsowanie na string, parsowanie na int, pobranie panstw jeszcze raz
        List<WebElement> numberOfZone = driver.findElements((By.xpath("//tr/td[6]")));
        List<String> listOfZones = numberOfZone.stream().map(WebElement::getText).collect(Collectors.toList());
        List<Integer> intListOfZones = listOfZones.stream().map(Integer::parseInt).collect(Collectors.toList());


        // sprawdzenie liczby zone dla danego kraju, klikniecie w kraj jeśli liczba stref > 0, sprawdzenie czy strefy sa alfabetycznie
        for (int i = 0; i < intListOfZones.size(); i++) {
            List<WebElement> getCountriesForZone = driver.findElements((By.xpath("//tr/td[5]/a[contains(@href,'countries')]")));

            if (intListOfZones.get(i) > 0) {
                getCountriesForZone.get(i).click();
                // POPRAWIC BO CHYBA NIE DZIALA
                List<WebElement> numberOfZoneInCountry = driver.findElements((By.cssSelector("[id=table-zones] > tbody > tr > td:nth-child(3) > input[type=hidden]")));
                //List <String> numberOfZoneInCountryString =  numberOfZoneInCountry.stream().map(WebElement::getText).collect(Collectors.toList());
                List<String> numberOfZoneInCountryString = new ArrayList<String>();

                for (int j = 0; j < numberOfZoneInCountry.size(); j++) {
                    numberOfZoneInCountryString.add(numberOfZoneInCountry.get(j).getAttribute("textContent"));
                }
                System.out.println(numberOfZoneInCountryString);
                List<String> sortedNumberOfZone = new ArrayList<String>(numberOfZoneInCountryString);
                Assert.assertEquals(numberOfZoneInCountryString, sortedNumberOfZone);
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }

    }

    @After
    public void after() {
        driver.quit();
    }
}
