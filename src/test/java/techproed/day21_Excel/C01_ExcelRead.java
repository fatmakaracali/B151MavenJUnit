package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest1() throws IOException {

        //Hatirlatma: kodlari run ederken excel dosyasi kapatilmali, yoksa hata aliriz

        //3. satir 1. sutun degerini yazdirin ve "France" oldugunu test edin


        //Excel dosyasindan veri okuyabilmemiz icin;
        //1-Dosya yolunu aliriz

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";


        //2- Capitals dosyasini bizim sistemimize getirmeliyiz.

        FileInputStream fis = new FileInputStream(dosyaYolu);


       // 3-Dosyayi workbook'a atamaliyiz.Java ortaminda bir excel dosyasi olusturmaliyiz

        Workbook workbook = WorkbookFactory.create(fis);

       String satir3Sutun1= workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();

        System.out.println(satir3Sutun1);

        Assert.assertEquals("France",satir3Sutun1);



        //son satir sayisini bulunuz

       int sonSatriSayisi= workbook.getSheet("Sheet1").getLastRowNum();

        System.out.println("Son satir sayisi :" +sonSatriSayisi);

        //excel tablosundaki son satir sayisini getLastRowNum() methodu ile alabiliriz  (index olarak verir)


        //kullanilan satir sayisini bulunuz


       int satirSayisi=  workbook.getSheet("Sheet1").getPhysicalNumberOfRows();

        System.out.println("Kullanilan satir sayisi :"+ satirSayisi);


        //Excel tablosundaki kullanilan satir sayisini getPhysicalNumberOfRows() methodu ile alabiliriz. (index olarak vermez)

    }

    @Test
    public void readExcelTest2() throws IOException {


        //Capitals dosyasindaki tum verileri yazdiriniz

        Map<String, String> capitalsMap = new HashMap<>();  //capitals dosyasindaki tum verileri koyabilecegimiz java objesi Map'tir

        String dosyaYolu = "src/test/java/resources/Capitals (1).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirSayisi= workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i < sonSatirSayisi; i++) {

           String key= workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
           String value= workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

           capitalsMap.put(key,value);

        }

        System.out.println(capitalsMap);

    }


















}
