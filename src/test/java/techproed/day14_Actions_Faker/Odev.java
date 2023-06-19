package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev extends TestBase {
    @Test
    public void test01() {


 //   1- "http://webdriveruniversity.com/Actions" sayfasina gidin
     driver.get("http://webdriveruniversity.com/Actions");

 //   2- Hover over  Me First" kutusunun ustune gelin

        WebElement box= driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(box).perform();


 //   3- Link 1" e tiklayin

        WebElement link1 = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        link1.click();


 //   4- Popup mesajini yazdirin

        System.out.println(driver.switchTo().alert().getText());


        //   5- Popup'i tamam diyerek kapatin

        alertAccept();

 //   6- “Click and hold" kutusuna basili tutun

     WebElement clickHold=   driver.findElement(By.xpath("//*[@id='click-box']"));
        action.clickAndHold(clickHold).perform();
 //   7-“Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(driver.findElement(By.xpath("//*[@id='click-box']")).getText());

        wait(3);

        //   8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin

       WebElement doubleClick= driver.findElement(By.xpath("//*[@id='double-click']"));
       action.doubleClick(doubleClick).perform();

      WebElement green= driver.findElement(By.xpath("//*[@class='div-double-click double']"));

      Assert.assertTrue(green.isDisplayed());








    }
}
