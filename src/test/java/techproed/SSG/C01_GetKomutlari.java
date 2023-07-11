package techproed.SSG;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_GetKomutlari extends TestBase {


    /*

    https://www.kitapyurdu.com/ adresine gidiniz.
    Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
    Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.
    Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
    Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
    “Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
    Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
    quit() ve close() metotları arasındaki farkı inceleyelim.
     */

    @Test
    public void getKomutlariTesti() {

       // Websitesine git
        driver.get("https://www.kitapyurdu.com/");

       //URL ile dogrulayiniz
        String expectedUrl= "https://www.kitapyurdu.com/" ;
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //Title ile dogrulama

        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Anasayfada bazı başlıkların bulunduğunun doğrulanması
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

        // Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunun doğrulanması
        WebElement girisButonu = driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        String girisButonuMetni = girisButonu.getText();
        Assert.assertEquals("Giriş Yap", girisButonuMetni);

        // "Üye Ol" butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunun doğrulanması
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlHref = uyeOlButonu.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlHref);

        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunun doğrulanmasi
        List<WebElement> yazarIsmiListesi = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));

        for (WebElement each: yazarIsmiListesi) {

            Assert.assertEquals("span",each.getTagName());
        }


        for (WebElement each: yazarIsmiListesi) {
            Assert.assertEquals("Arial, Helvetica, sans-serif",each.getCssValue("font-family"));
        }

       WebElement kitapYayin= driver.findElement(By.xpath("(//a[@class='pr-img-link'])[1]"));
        int height= kitapYayin.getSize().getHeight();
        System.out.println(height);
        int width= kitapYayin.getSize().getWidth();
        System.out.println(width);
        int expectedHeight = 174;
        int expectedWeight = 120;
        Assert.assertEquals(expectedHeight,height);
        Assert.assertEquals(expectedWeight,width);








    }
}
