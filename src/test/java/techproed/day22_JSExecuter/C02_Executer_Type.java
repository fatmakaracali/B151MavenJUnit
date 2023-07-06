package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Executer_Type extends TestBase {
    @Test
    public void TEST() {

        //  https://techproeducation.com sayfasına gidin

        driver.get("https://techproeducation.com");

        wait(2);

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        wait(2);


        // Arama kutusuna "QA" yazıp aratın

       WebElement searchBox= driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']"));

       //  JavascriptExecutor js = (JavascriptExecutor) driver;
       //  js.executeScript("arguments[0].value='QA'",searchBox);

        sendKeysJS(searchBox,"QA");                            //method olusturduk

        /*BASKA BIR YOL

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",searchBox);

        sendAttributeJS(searchBox,"QA");                            yukaridakinin method hali

         */

        searchBox.submit();


    }
}