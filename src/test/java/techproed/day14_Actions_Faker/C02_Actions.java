package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {


    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
     wait(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        wait(3);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //release() --> methodu mouse'i birakir

    }

  /*  @Test
    public void test03() {
        @Test
        public void test03() {
            driver.get("https://techproeducation.com");
            driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
            wait(3);
            //sayfanin altina dogru gidelim
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 1500).perform();

            //sayfanin ustune dogru gidelim
            actions.scrollByAmount(0, -1500).perform();
        }
    }*/
}