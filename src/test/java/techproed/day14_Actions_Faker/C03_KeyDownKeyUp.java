package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {


    @Test
    public void test01() {

        // Google anasayfasina gidelim

        driver.get("https://google.com");

        //Arama kutusunda Shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim

        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

       WebElement searchBox= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT).                    //Arama kutusunda shift tusuna bastik
                sendKeys("selenium").                              ////-->selenium metnini shift tuşuna basılı kaldığı için büyük yazdı
                keyUp(Keys.SHIFT).                                 // shift tusunu serbest biraktik
                sendKeys("-java",Keys.ENTER).                       //shift'i serbest biraktigimiz icin kucuk yazdi
                perform();

    }

    @Test
    public void test02() {

        // Google anasayfasina gidelim

        driver.get("https://google.com");

        //Arama kutusunda Shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak Java yazdiralim

        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        WebElement searchBox= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);


    }

      /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */

    @Test
    public void test03() {

        //google sayfasına gidelim

        driver.get("https://google.com");

        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın

        WebElement searchBox= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Selenium",Keys.ENTER);

        // Sayfayı bekleyin

        wait(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim

        driver.findElement(By.xpath("//*[@class='gLFyf']")).  //sayfa yenilendigi icin tekrar locate aldik

        sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir

        wait(3);

        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.CONTROL,"x"); //secilen
        //metni ctrl + x ile kestik

        wait(3);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

        driver.navigate().to("https://google.com");

        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.CONTROL,"v",Keys.ENTER);
    }















}
