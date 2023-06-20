package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ExplicitWait extends TestBase {
    @Test
    public void TEST01() {


        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //==>  Remove tuşuna basın

       WebElement remove= driver.findElement(By.xpath("(//*[@type='button'])[1]"));
       remove.click();




        //==>  "It's gone!" yazısının görünür oldugunu test edin.

       WebElement itsGone= driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsGone.isDisplayed());
    }
}