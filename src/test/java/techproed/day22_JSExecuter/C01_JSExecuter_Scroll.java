package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter_Scroll extends TestBase {











    JavascriptExecutor js;


    @Test
    public void jsExecuterScrollTest() {

        //  https://techproeducation.com sayfasına gidin

        driver.get("https://techproeducation.com");

        wait(2);

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        wait(2);

        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)

        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));

       // js = (JavascriptExecutor) driver;

       // js.executeScript("arguments[0].scrollIntoView(true);",weOffer);

        scroll(weOffer);                    //methodu kullandik

        wait(4);

        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)

       WebElement enrollFree= driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));

       js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);

       wait(3);

        // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)

       WebElement whyUs=  driver.findElement(By.xpath("//*[text()='WHY US?']"));

       js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);",whyUs);

       wait(3);

        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);

        wait(3);

        // Sayfayi en üste scroll et (sayfayı kaydır)

        // js= (JavascriptExecutor) driver;
        //  js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        scrollHome();                         // methodla yaptik

        wait(3);


        // Sayfayı en alta scroll et (sayfayı kaydır)

         js= (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0,document.body.scrollHeight)");








    }
}
