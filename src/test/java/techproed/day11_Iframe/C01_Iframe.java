package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {


    //==>   https://testcenter.techproeducation.com/index.php?page=iframe
//==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
//==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
//==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin


    @Test
    public void iframe() {

        //==>   https://testcenter.techproeducation.com/index.php?page=iframe

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe ");

        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin

       WebElement anIframeYazisi= driver.findElement(By.xpath("(//p)[1]"));

        Assert.assertTrue(anIframeYazisi.getText().contains("black border"));

        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim

        WebElement iframe= driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iframe);

           /*
        Applications lists yazısını dogru locate edip,
        dogru sekilde görünür oldugunu test etmemize ragmen Faild oldu
        bunun üzerine HTML kodlarını inceleyince
        Applications lists yazısının aslında bir iframe icerisinde oldugunu gördük
        bu durumda once iframe'i locate edip
        switchTo() ile iframe'e gecmeliyiz
         */

        WebElement aplicationsYazisi= driver.findElement(By.xpath("//h1[text()='Applications lists']"));

        Assert.assertTrue(aplicationsYazisi.isDisplayed());
        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin

        driver.switchTo().defaultContent();
        //parentFrame()-->bir ust seviyedeki iframe cikmak icin kullanilir
        //defaultContent()-->en ustteki iframe'e cikmak icin kullanilir

       WebElement powerYazisi= driver.findElement(By.xpath("(//p[text()='Povered By'])[1]"));
       Assert.assertTrue(powerYazisi.getText().contains("Povered By"));


    }
}
