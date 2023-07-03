package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {


    /*
    Eger bir web sayfasinin HTML kodlari tamamen ya da kismen JavaScript kullanilarak olusturulduysa, o sayfayla
    etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir.
    Bu durumda sayfayla etkilesime gecebilmek icn JavaScriptExecuter arayuzu kullanmak gerekir.
    JavaScriptExecuter arayuzu sayfada dogrudan erisebilir

    Ancak, mümkünse WebDriver'ın sundugu standart yöntemlerle sayfayla etkilesime gecmek her zaman daha iyidir.
    Cünkü JS kullanımı sayfanın daha yavas yuklenmesine neden olabilir.  */

    @Test
    public void jsExecuterClick() {

        // amazon sayfasina gidelim

        driver.get("https://www.amazon.com");


        //return kismina tiklayiniz

       WebElement returns= driver.findElement(By.xpath("//a[@id='nav-orders']"));

       // returns.click();

       /*
        ilgili webElementin HTML kodu, JavaScript kullanilarak olusturulduysa , standart WebDriver komutu olan click()
       yetersiz kalabilir. boyle durumlarda JavaScriptExecuter kullanilarak sayfayla etkilesime gecilebilir
        */

        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();",returns);


        //ekran goruntusunu al

        screenShot();

    }

     /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz
     */
}
