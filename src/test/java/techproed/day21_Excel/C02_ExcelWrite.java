package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    @Test
    public void excelWriteTest1() throws IOException {

        //Bir nufus sutunu olusturun
        // baskent nufuslarını excel dosyasına yazınız.
        // (D.C: 1100, Paris:1500, London:1200, Ankara:1300)

        String dosyaYolu = "src/test/java/resources/Capitals (1).xlsx";

        // capitals dosyasini bizim sistemimize getirdik

        FileInputStream fis = new FileInputStream(dosyaYolu);

        //dosyayi workbook'a ata

        Workbook workbook = WorkbookFactory.create(fis);

        //Excel'de bir hucre olusturmak icin createCell() methodu kullanilir
        //hucre icine yazdiracagimiz deger icin setCellValue() methodu kullanilir

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("Nufus");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("1200");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("1300");


        // datalari bizim class'imizdan Capitals dosyasina gönderecegiz
        FileOutputStream fos = new FileOutputStream(dosyaYolu);


        workbook.write(fos);
        fos.close();
        workbook.close();








    }
}