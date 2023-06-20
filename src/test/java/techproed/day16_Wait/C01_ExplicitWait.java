package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    //implicitlyWait() sayfadaki tüm elementlerin max bekleme süresidir. bizim isimizi %80 halleder
//bu method ile cogu yerde isimizi halleder.
//islem daha önce biterse sürenin bitmesi beklenmez, genelde TestBase class inda kullanilir.

//explicitlywait() %20 oraninda kullaniriz. Sadece belirli bir webelement icin kullanilir.Belirli bir
//kosul gerceklesene kadar max süre boyunca bekletir. Max süreyi biz belirleriz.
// Default olarak kontrol etme süresi 500 ms'dir ~ yaklasik 0,5 saniye. Bu sürede sürekli kontrol eder.
//webdriverwait defult olarak 500 ms atanir ve degistirilemez
//fluentwait istedigimiz ms atayabiliriz.
//beklenen bir durum, bir sart olmali. Örnegin webelement görünür oluncaya kadar bekle.
//explicitlywait()'de bir kosul belirtiriz. Belirli webelementler icin kullanilir.

//ÖRNEK: WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); objesini kullaniriz. *********''''

//Webelementi locate etmek icin wait object kullanma:(explicitlywait() icin)
// WebElement element = wait.until(ExpectedCondition.visibilityOfElemetLocated(By.xpath("")));
//explicitlywait()'de sartlar methodlarla belirtilir. Methodlarin 17sini gördük.

//implicitlyWait() ile halledebiliyorsak explicitlywait() kullanmayiz.

//Bir webelement max bekleme sürelerinde yüklenemezse NoSuchElementException aliriz

    @Test
    public void test01() {



        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın

        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //==> Hello World! yazısının görünürlügünü test edin

        /*

        WebElement helloWorldYazisi= driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Assert.assertTrue(helloWorldYazisi.isDisplayed());

        Hello World! yazisinin gorunurlugunu implicitylywait ile cozemedik**************
         */

        WebElement helloWorldYazisi= driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));

       wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));

        //2.yol

        //  WebElement helloWorldYazisi= wait.until((ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Hello World!']"));

      Assert.assertTrue(helloWorldYazisi.isDisplayed());


}

                 /*
SELENIUM WAIT:
        IMPLICITLY WAIT --> Driver'i oluşturduktan sonra sayfadaki tüm webelementlerin etkileşime girebilmesi için
     belirtmiş olduğumuz max. (Duration.ofSecond(20)) süre kadar bekler.
        EXPLICIT WAIT / WebDriverWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
     max. belirtmiş olduğumuz süre kadar default(varsayılan) olarak yarım saniyelik aralıklarla bekler. Örneğin bir
     webelemente tıkladık ve bir alert'ün çıkması zaman alabilir, internet yoğunluğundan yada sayfanın
     performansından kaynaklı bu süreyi normalde kullandığımız Thread.sleep() ile de çözebiliriz fakat testimizi
     her çalıştırdığımızda Thread.sleep() için kaç saniye beklemesi gerektiğini kestiremeyebiliriz. Bu gibi
     durumlar için explicit wait kullanırız.
        EXPLICIT WAIT / FluentWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
     max. belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda (saniye/salise) bekler
 */
}