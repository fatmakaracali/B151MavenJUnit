package techproed.SSG;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import utilities.TestBase;

public class C04_RelativeLocators2 extends TestBase {
    @Test
    public void relativeLocatorsTesti() {

        driver.get("https://theautomationzone.blogspot.com/2022/01/calculator.html");

        WebElement inputKutusu = driver.findElement(By.cssSelector("[colspan='3']"));
        WebElement c = driver.findElement(with(By.tagName("input")).toRightOf(inputKutusu));
        WebElement bolme = driver.findElement(with(By.tagName("input")).near(c));
        WebElement uc = driver.findElement(with(By.tagName("input")).toLeftOf(bolme));
        WebElement iki = driver.findElement(with(By.tagName("input")).toLeftOf(uc));
        WebElement bir = driver.findElement(with(By.tagName("input")).toLeftOf(iki));
        WebElement dort = driver.findElement(with(By.tagName("input")).below(bir));
        WebElement bes = driver.findElement(with(By.tagName("input")).toRightOf(dort));
        WebElement alti = driver.findElement(with(By.tagName("input")).toRightOf(bes));
        WebElement eksi = driver.findElement(with(By.tagName("input")).toRightOf(alti));
        WebElement arti = driver.findElement(with(By.tagName("input")).below(eksi));
        WebElement dokuz = driver.findElement(with(By.tagName("input")).toLeftOf(arti));
        WebElement sekiz = driver.findElement(with(By.tagName("input")).toLeftOf(dokuz));
        WebElement yedi = driver.findElement(with(By.tagName("input")).toLeftOf(sekiz));
        WebElement nokta = driver.findElement(with(By.tagName("input")).below(yedi));
        WebElement sifir = driver.findElement(with(By.tagName("input")).toRightOf(nokta));
        WebElement esit = driver.findElement(with(By.tagName("input")).toRightOf(sifir));
        WebElement carpi = driver.findElement(with(By.tagName("input")).toRightOf(esit));

        iki.click();
        bes.click();
        arti.click();
        wait(3);
        dokuz.click();
        sekiz.click();
        esit.click();

       wait(5);


    }
}
