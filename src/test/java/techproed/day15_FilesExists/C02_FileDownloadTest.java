package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01() {

        String filePath ="C:\\Users\\HP\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("dosya bulunamadı");
        }
    /*
    Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
    burda dosyayı sildik
     */

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim

        driver.findElement(By.xpath("(//*[text()=.])[6]")).click();

        wait(2);

        /*
        indirmemizi istedigi dosyayi locate edip tikladik ve dosyamiz indirilenler klasörune indi
         */


       //Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu= "C:\\Users\\HP\\Downloads\\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
