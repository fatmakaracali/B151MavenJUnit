package techproed.day12_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {


    /*
    Authentication, kimlik dogrulama yöntemidir
    -Sözkonusu sisteme dahil olup olunmayacagini belirleyen formu ifade eder
    -Authentication uzerinde sag click yapip locate alinamaz
    -Authentication bir alert degildir
    -Authentication yapabilmek icin uygulamanin kullanicilara, Authentication'i nasil yapilacagina dair bilgilendirme
    yapmis olmasi gerekir
    -https://username:password@URL

     */

    // Aşağıdaki bilgileri kullanarak authentication yapınız:

// Url: https://the-internet.herokuapp.com/basic_auth
// Username: admin
// Password: admin

//Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız

    @Test
    public void basicAuthentication() {

        // Aşağıdaki bilgileri kullanarak authentication yapınız:

    // Url: https://the-internet.herokuapp.com/basic_auth
    // Username: admin
    // Password: admin


      /*
      https://the-internet.herokuapp.com/basic_auth
      Yukaridaki belirtilen formata uygun kimlik dogrulamasi yapilacaktir

      */

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


      //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız

        String text= driver.findElement(By.xpath("//p")).getText();

        Assert.assertTrue(text.contains("Congratulations"));

        //Elemental Selenium yazısına tıklayalım

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());


        //Başlığın Elemental Selenium olmadigini doğrulayın

        System.out.println(driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());

        //Language dropdownindan Java seciniz

        WebElement ddm= driver.findElement(By.xpath("//select[@class='dropdown-language']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");







    }


}
