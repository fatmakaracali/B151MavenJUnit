package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;


public class C02_TimeOutException extends TestBase {


    @Test
    public void timeOutException() {

        /*
       TimeOutException:

       sayfada aradıgımız elementi wait ile belirttigimiz max. sürede
       bulamadıgı durumda TimeOutException hatası alırız.

         */





            driver.get("https://techproeducation.com");
            wait(2);


            //reklami kapatiniz


            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



            //searchBox görünür oluncaya kadar bekleyiniz

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); //15 yerine 2 yazinca hata aldik

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));



       /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */


        /*
            TimeOutException:
Explicit wait kullanildiginda, ve element bulunamadiginda
alinir.
Explicit wait & yanlis locator-> timeout
Explicit wait & doğru locator & sure yeterli degil -> timeout
Explicit wait & dogru locator & sure yeterli & iframe var ->
time out


            Solution:
-Sureyi arttirmak
-Farkli explicit kullanmak: wait visibilityOfElementLocated
YERINE presenceOfElementLocated. Yada javascript executor
da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
-Locatori tekrar kontrol etmek
-Frameworkunde hazir reusable method lar var Bu durumda
timeoutexception aldigimda hızlıca o metotlar yardımıyla
problemi cozebiliyoruz

 */

    }

    @Test
    public void timeOutExceptionTest02() {

        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız

        driver.findElement(By.xpath("//*[text()='Start']")).click();


        // Hello World! yazısının görünürlügünü test ediniz

        WebElement helloWorldYazisi= driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));  //hata almak icin parantez icine 15'i silip 1 yazdik

        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));

        Assert.assertTrue(helloWorldYazisi.isDisplayed());

    }

    /*
       gercekte Hello World! yazisi ortalama 6 saniyede gozukuyor
       TimeOutException alabilmek icin Explicit Wait'e max bekleme sureisni 1 saniye verdik.
       Bu sebeple TimeOutException hatasi aldik.
 */


    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldText = driver.findElement(By.xpath("yanlis locate"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("yanlisLocate")));

    }

    /*
     Yukaridaki örnekte max süreyi dogru vermemize ragmen yanlis locate aldigimiz icin yine TimeOutException hatasi aliriz
      Dolayısıyla bu exception'ı handle edebilmek için
     locate'i doğru almalıyız
    */




    @Test
    public void test04() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan buttona tıklayalım
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='ch']")));
    /*
    org.openqa.selenium.TimeoutException: yanlış method kullandığımız için bu hatayı aldık
     */

        //checkBox'ın seçili olduğunu doğrulayalım(CheckBox'ı locate etmeliyiz)
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='ch']"));
        Assert.assertTrue(checkBox.isSelected());


    }










}
