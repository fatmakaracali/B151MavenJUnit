package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

    /*
    EXTENTREPORT:
       1- ExtentReport(aventstack) kullanabilmek icin oncelikle mvn adresinden 4.0.9 versiyon numarali
        dependency'i pom.xml dosyamiza ekleriz.
       2-ExtentReports class'indan class seviyesinde obje olustururuz
       3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
       4- ExtentTest class'ından class seviyeninde obje oluştururuz
     */
    ExtentReports extentReports;             //Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;   //Raporu Html formatinda duzenler
    ExtentTest extentTest;                   //Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururuz
    @Test
    public void test01() {

        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "testOutput/extentReports/extentReport"+date+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);       //HTML formatinda raporlamayi baslatacak

        //Raporda gözukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Fatma");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest= extentReports.createTest("ExtentTest","Test Raporu");

         /*
        Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
        testle ilgili bilgileri rapora ekleyebiliriz
     */

        //amazon sayfasina gidelim

        driver.get("https://amazon.com");

        extentTest.info("Amazon sayfasina gidildi");

        // basligin amazon icerdigini test edelim

        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Basligin Amazon icerdigi test edildi");


        //arama kutusunda iphone aratalim

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");




        //sonuc yazisini konsola yazdiralim

       WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        System.out.println(sonucYazisi);

        extentTest.pass("Sonuc yazisinikonsolda yazdirdik ");
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();

        /*
        extentTest objesi ile info() methodunu kullanarak her step'te ne yaptigimizla alakali bilgi yazabiliriz.Te
        Testimizin en sonunda testin bittigini ifade eden pass() methodu ile testimiz ile alakali son bilgiyi ekleyebiliriz
        Ve son olarak actions'deki perform() methodu gibi extentReport objesi ile fush() methodu kullanarak raporu sonlandiririz

         extentReports.flush();  --> bu raporu kullanmazsak raporumuz olusmaz
         */


    }
}
