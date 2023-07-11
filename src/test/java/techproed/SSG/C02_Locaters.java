package techproed.SSG;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_Locaters extends TestBase {

  /*  https://www.kitapyurdu.com/ adresine gidiniz.
            “En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
    Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
            “Devamını Oku…” butonuna basınız.
    Ürünü sepete ekleyiniz.
    Sepete gidiniz.
    Ürüne ait kontrol kutusunu işaretleyiniz.
    Ürün miktarını değiştiriniz.*/

    @Test
    public void test() {

        //Web sitesine gidilir

        driver.get("https://www.kitapyurdu.com/");

        //"en cok satanlar" bölimundeki ilk urune tiklayiniz

        List<WebElement> enCokSatilanlarListesi= driver.findElements(By.className("bestseller-item"));
        String ilkKitap=  enCokSatilanlarListesi.get(0).getText().split("\n")[0];
        enCokSatilanlarListesi.get(0).click();


        //Seçilen ürüne ait sayfanın açıldığını doğrulayınız.

        WebElement kitapAdi= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(ilkKitap,kitapAdi.getText());

        // "Devamını Oku…" butonuna basınız.
        WebElement devaminiOku = driver.findElement(By.partialLinkText("Devamı"));
        devaminiOku.click();

        //  Ürünü sepete ekleyiniz.

        // Ürünü sepete ekleyiniz.
        WebElement sepeteEkle = driver.findElement(By.linkText("Sepete Ekle"));
        sepeteEkle.click();

       wait(3);

       //Sepete git

        WebElement sepeteGit = driver.findElement(By.linkText("sepetinize"));
        sepeteGit.click();

        // Ürüne ait kontrol kutusunu işaretleyiniz.

        WebElement urunKontrolKutusu = driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(urunKontrolKutusu.isSelected());

        if (!urunKontrolKutusu.isSelected()){
            urunKontrolKutusu.click();
        }

        // Ürün miktarını değiştiriniz.
        WebElement urunMiktari = driver.findElement(By.name("quantity"));
        Assert.assertEquals("1", urunMiktari.getAttribute("value"));
        urunMiktari.clear();
        urunMiktari.sendKeys("3");
        Assert.assertEquals("3", urunMiktari.getAttribute("value"));
    }




}

