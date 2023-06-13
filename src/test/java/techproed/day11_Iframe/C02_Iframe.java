package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
    //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
    //==>  textBox içindeki yazıyı siliniz.
    //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
    //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.


    @Test
    public void iframe() {

        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz

        driver.get("https://the-internet.herokuapp.com/iframe  ");


        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz

       WebElement text= driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assert.assertTrue(text.getText().contains("Editor"));

        wait(2);

        //==>  textBox içindeki yazıyı siliniz.

        WebElement iframe= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement textBox=  driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();

      //  driver.switchTo().parentFrame();


        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.

        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        wait(2);

         driver.switchTo().parentFrame();



        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.

        WebElement textSelenium= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(textSelenium.isDisplayed());
    }
}
