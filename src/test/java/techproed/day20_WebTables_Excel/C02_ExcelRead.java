package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {
    @Test
    public void excelReadTest1() throws IOException {

      //Excel dosyasindan veri okuyabilmemiz icin ;
      //  1- dosya yolunu aliriz

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

      //  2- Capitals dosyasini bizim sistemimize getirmeliyiz. Dosyayi okuyabilmek icin akisa almaliyiz. bu yuzden stream diyoruz

        FileInputStream fis = new FileInputStream(dosyaYolu);

      //  3-dosyayi workbook'a atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz.

        Workbook workbook = WorkbookFactory.create(fis);

      //  4- sayfayi(sheet) secmeliyiz

        Sheet sheet = workbook.getSheet("Sheet1");

      // satiri (row) secmeliyiz

        Row row = sheet.getRow(0);  // excel'de index 0'dan baslar  1.satir-->index 0

      //hucreyi(cell) secmeliyiz

        Cell cell = row.getCell(0);

      // Son olarak cell bilgisini sout ile yazdirip excel'deki 1. satir 1 .hucredeki veriyi görebiliriz

        System.out.println(cell);


    }

    @Test
    public void readExcelTest2() throws IOException {

        //KISAYÖNTEM

        // 1. satir , 1 sutundaki bilgiyi yazdiriniz

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun1= workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();

        System.out.println(satir1Sutun1);

    }



    @Test
    public void readExcelTest3() throws IOException {

        // 1. satir , 2. sutundaki hucreyi yazdirin

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();

        System.out.println(satir1Sutun1);


    }

    @Test
    public void test04() throws IOException {

    //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin


        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String row3Cell1= workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(row3Cell1);
        Assert.assertEquals("France", row3Cell1);


        //Kullanılan satır sayısın bulun

        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());

        //NOT:getPhysicalNumberOfRows() methodu kullanilan yani ici dolu olan satirlarin sayisini verir.Index 1 den baslar

        //Sayfadaki satir sayisini yadiriniz

        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());   // INDEX 0'dan baslar

        //NOT:getLastRowNum() methodu sayfadaki satır sayısını verir ve index 0(sıfır) dan başlar


        //Ülke-Başkent şeklinde verileri yazdırın

        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {

            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
            
        }


    }


}
