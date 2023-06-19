package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {

        /*
        Bir web sitesini test ettigimizde download islemi yapildigi zaman dosyanin bilgisayarimiza inip inmedigini
        kontrol etmek,varligini dogrulamak icin  ya da bilgisayarimizdaki herhangi bir dosyanin varligini dogrulayabilmek
        icin ;
             Files class'indan  Files.exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanin varligini test edebiliriz. -->Files.exists(Paths.get(dosyaYolu)
        Dolayisiyla bu ise baslamadan önce varligini test edecegimiz dosyanin yolunu String bir degiskene assing ederiz

        NOT:
    Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
    yolunu almak istediğimiz dosyanun üzerine gelip shift+sagKlik tusuna basarak yol olarak kopyala
    seçeneği ile dosya yolunu kopyalayabiliriz.
         */

        String dosyaYolu="C:/Users/HP/OneDrive/Masaüstü/Koe taso 7.docx";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));   // -->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {

        String dosyaYolu= "C:/Users/HP/OneDrive/Masaüstü/kaynak.jpg";
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test03() {

        /*
        Bir server'da farkli isletim sistemleri ile ayni anda calisirken dosya varligini test etmek istedigimiz zaman
        daha dinamik olmasi acisindan System.getProperty("os.name") bu sekilde isletim sistemini alir ve her isletim
        sisteminin kullanici yolu farkli olacagindan  System.getProperty("user.home") ile bilgisayarimizdaki kullanici
        yolunu bu sekilde  alip String bir degiskene farkliYol ismi ile System.getProperty("user.home") atayarak
        her seferinde farkli yollari alma ile ugrasmamis oluruz. Dosya diyelim ki masaustunde ve her isletim sisteminde
        bize ayni yolu verecegi icin bunu da ortak yol olarak bir String ile assign ederiz.
         */



        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir

        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "C:/Users/HP";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/OneDrive/Masaüstü/kaynak.jpg";
        String dosyaYolu = farkliYol+ortakYol;

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
     /*   try {
            Files.delete(Paths.get(dosyaYolu)); //bu sekilde belirtmis oldugumuz dosyayi sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi.");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));

        //Sildigimiz dosya isminde yeni bir dosya olusturalim
        try {
            Files.createFile(Paths.get(dosyaYolu)); //belirtmis oldugumuz dosyayi olusturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

     /*
        Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
    yukardaki delete işlemini kullanabiliriz
     */

    @Test
    public void test04() {

        String dosyaYolu="C:/Users/HP/OneDrive/Masaüstü/Koe taso 7.docx";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
       // file.delete();

        /*
    Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
 */

    }
}





















