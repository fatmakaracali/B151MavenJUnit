package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_GetValue extends TestBase {
    @Test
    public void jsgetValue() {

        //  https://www.carettahotel.com/ sayfasına gidiniz

        driver.get("https://www.carettahotel.com/");

        driver.findElement(By.xpath("//button[@id='details-button']")).click();

        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        //Check-in Date kismini JS ile locate ediniz

        JavascriptExecutor js =(JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");

        /*
        CSS SELECTOR KULLANARAK DA LOCATE ALINABILIR ( 2. yol)

        JavascriptExecutor js =(JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");

         */

        //EGER HTML KODLARINDA SCRIPT ATTRIBUTU VARSA O HTML KODLAR JS ILE YAZILMISTIR. BU DURUMDA
        //JSEXECUTER ILE ISLEM YAPMALYIZ

          /*
        Eger bir web sayfasında webelementler olusturulurken JS kullanılmıssa, normal olarak locate almakta zorlanabiliriz.
        Bu gibi durumlarda JSExecuter kullanarak webelementi locate edebiliriz.
        */


        //Checkin Date kismina 5/25/2023 tarihini yaziniz


        date.clear();
        date.sendKeys("5/25/2023");

        //Checkin Date kisminin degerini yazdirin

        String valueAttribute = (String) js.executeScript("return document.getElementById('checkin_date').value");

        System.out.println(valueAttribute);






    }
}
