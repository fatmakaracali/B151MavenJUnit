package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void test() {


//==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın

        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //helloWorld yazisinin görunurlugunu test et

        WebElement helloWorldYazisi= driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        visiableWait(helloWorldYazisi,100);

        Assert.assertTrue(helloWorldYazisi.isDisplayed());
    }
}