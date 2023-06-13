package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_AlertMethod extends TestBase {

    @Test
    public void acceptAlert() throws InterruptedException {

        driver.get(" https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        //  Bir metod olusturun: acceptAlert
        //  1. butona tıklayın,

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

       wait(2);

        //   uyarıdaki OK butonuna tıklayın

        alertAccept();



        wait(2);

        //  ve result mesajının "You successfully clicked an alert" oldugunu test edin.



        wait(2);


        //    ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String actuelResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(expectedResult, actuelResult);

    }

    @Test
    public void dismissAlert() throws InterruptedException {

        driver.get(" https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        wait(2);

        // 2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

    wait(2);

        //  uyarıdaki Cancel butonuna tıklayın

        alertDismiss();

        wait(2);

        // ve result mesajının "successfuly" icermedigini test edin.

        String actualResult= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult= "successfuly ";

        Assert.assertFalse(actualResult.equals(expectedResult));

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {

        driver.get(" https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        wait(2);

        //  3. butona tıklayın,

        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();

        //  uyarıdaki mesajı konsolda yazdırın,

        alertText();


        //getText() uyaridaki mesaji bize String olarak getirir

        //  uyarıdaki metin kutusuna isminizi yazin,

        alertPrompt("hello world");




        //          OK butonuna tıklayın

       alertAccept();

        //  ve result mesajında isminizin görüntülendiğini doğrulayın.

        wait(2);

        String actualResult= driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(actualResult.contains("hello world"));



    }

}
