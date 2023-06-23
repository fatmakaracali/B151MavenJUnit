package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {


    /*
    SCREENSHOT:
           Selenium'da tum ekran göruntusunu alabilmek icin TakesScreenShot arayuzunden bir
           obje olusturup driver'a esitleriz. Arayuzler farkli oldugu icin casting yapariz. ve bu olusturdugumuz o
           obje ile getScreenShot methodu ile sayfanin resmini aliriz. Almis oldugumuz resmi projemizde nereye
           kaydedeceksek oraninyolunu belirtiriz
    */
    @Test
    public void test01() throws IOException {

            //TechproEducation sayfasina gidelim

        driver.get("https://techproeducation.com");
        wait(2);

            //Çıkan reklamı kapatalım

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

           //Ve ekran görüntüsünü alalım

        /*
        1_ilk olarak screenshot aldigimizda nereye kaydetmek istiyorsak oranin yolunu belirtelim
        2_ İkinci olarak TakesScreenShot arayüzünden obje oluşturuz
        3_ Ucuncu olarak FileUtils class'indan copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
           dosya yolunu belirtecegiz

         */

        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/TumSayfaResmi.png";
        TakesScreenshot ts=(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {

        //TechproEducation sayfasina gidelim

        driver.get("https://techproeducation.com");
        wait(2);

        //Çıkan reklamı kapatalım

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım



        TakesScreenshot ts=(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("techproed/ScreenShot/screenShot.png"));

    }

    @Test
    public void test03() throws IOException {
        /*
        Kaydettigimiz ekran resmini her seferinde ayni dosya uzerine yazmamasi icin dosya isminden sonra
        String bir degiskene tarih formati atayabiliriz.
         */

        //TechproEducation sayfasina gidelim

        driver.get("https://techproeducation.com");
        wait(2);

        //Çıkan reklamı kapatalım

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım

        /*
        SimpleDateFormat kullanarak yeni bir tarih formati olusturup bir String'e assign ederiz
        Ve bunu dosya isminden once belirtiriz
         */

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot"+ date +".jpeg";
        TakesScreenshot ts=(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test04() throws IOException {


        //Amazon sayfasina gidelim

        driver.get("https://amazon.com");
        wait(2);



        //Ve ekran görüntüsünü alalım

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot"+ date +".jpeg";
        TakesScreenshot ts=(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));



    }















}