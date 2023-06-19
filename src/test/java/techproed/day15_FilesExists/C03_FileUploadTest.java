package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        // eger chooseFile butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde
        //      //  exception aliyorsak direkt upload yapmak istedigimz dosya yolunu alip sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz

        String dosyaYolu="C:\\Users\\HP\\Downloads\\b10 all test cases, code.docx";
        //chooseFile butonuna basalim

        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        //  chooseFile.click(); //click yapmadi hata aldik


        //Yuklemek istediginiz dosyayi secelim.

        chooseFile.sendKeys(dosyaYolu);

        // Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();
        wait(2);

        //"File Uploaded!" textinin goruntulendigini test edelim.

        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
