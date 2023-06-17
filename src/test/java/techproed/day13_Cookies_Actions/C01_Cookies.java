package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.sql.Array;
import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin

        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin

        // driver.manage().getCookies();   cookies listelemek istersek   driver.manage().getCookies() methoduyla bir Set
        // ya da ArrayList'e atarak listeleyebiliriz

        //  Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);  //Lambda ile cookies yazdirdik 1.yol

         Set<Cookie> cookieSet= driver.manage().getCookies();

         int sayac=1;

        for (Cookie w: cookieSet) {

            System.out.println(sayac +". cookie :"+w);

            System.out.println(sayac+". cookieName :"+w.getName());

            System.out.println(sayac+". cookieValue :"+w.getValue());
            sayac++;

        }




        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin

        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);



        //6-eklediginiz cookie’nin sayfaya eklendigini test
        cookieSet = driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(each);
        }
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println("Cookie'lerin sayisi = "+cookieSet.size());
        System.out.println("Cookie'lerin sayisi = "+Arrays.stream(driver.manage().getCookies().toArray()).count());


        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("Silinmeden Once Cookie Sayisi = "+silinmedenOnce);
      wait(2);

        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie'yi sildik
      wait(2);

        cookieSet = driver.manage().getCookies();//Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        int silindiktenSonra = cookieSet.size();
        System.out.println("Silindikten Sonra Cookie Sayisi = "+silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));


        //8-tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();            //tum cookies'leri sildik
        cookieSet= driver.manage().getCookies();       //tekrar cookieSet'i guncelledik
        Assert.assertTrue(cookieSet.isEmpty());        //ve cookieSet'in icinin bos oldugunu isEmpty() methoduyla test ettik

    }
}
