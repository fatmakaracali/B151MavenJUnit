package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEresmi extends TestBase {

    /*
        Bir webelementin resmini almak icin önce webelementi locate edip bir webelemente assign ederiz.
        ve bu webelementi direkt getScreenShotAs() methodunu kullanarak resmini belirttigimiz dosyaya kaydederiz
     */


    @Test
    public void test01() throws IOException {


       //Amazon sayfasina gidelim

        driver.get("https://amazon.com");
        wait(2);

        //iphone aratalim

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);



        //Ve cikan sonuc yazisiningörüntüsünü alalım

        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/WebElementResmi/WEscreenShot"+ date +".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new  File(dosyaYolu));




    }
}
