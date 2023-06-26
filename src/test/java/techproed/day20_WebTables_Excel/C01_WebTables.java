package techproed.day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    //thead -->tablonun basligi
    //tr    -->satir
    //th    -->sutun
    //tbody -->tablonun ici
    //tr    -->satir
    //td    -->sutun


    @Test
    public void webTablesTest01() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/tables");

        //Table1'i yazdirin

       WebElement tablo1= driver.findElement(By.xpath("//table[1]"));
        System.out.println(tablo1.getText());

        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");

    }

    @Test
    public void webTablesTest02() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/tables");

        //3.satir verilerini yazdirin

       List<WebElement>  list=  driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));

       list.stream().forEach(t-> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTableTest03() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/tables");

        //son satirin verilerini yazdirin

       // List<WebElement>  list= driver.findElements(By.xpath("//table[1]//tbody//tr[4]//td"));     en son satir'i almak icin last() da kullanabiliriz

        List<WebElement>  list= driver.findElements(By.xpath("//table[1]//tbody//tr[last()]//td"));

        list.stream().forEach(t-> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTableTest04() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/tables");

        //5. sutunun basligini yazdirin

       WebElement besinciSutun= driver.findElement(By.xpath("//table[1]//thead//tr//th[5]"));
        System.out.println( " besinci sutun basligi :"+ besinciSutun.getText());

        //5.sutun verilerini yazdirin

       List<WebElement> besinciSutunVerileri= driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));

       besinciSutunVerileri.stream().forEach(t-> System.out.println(t.getText() +" - "));


    }

    @Test
    public void webTable05() {



        // iki parametreli bir java methodu olusturalım
        // Parametre 1 => satır numarasını
        // Parametre 2 => sutun numarası

       // printData(2,3) ==> 2. satır, 3. sutundaki veriyi yazdırın


        //  https://the-internet.herokuapp.com/tables sayfasına gidin

        driver.get("https://the-internet.herokuapp.com/tables");

        printData(2,3);
        printData(2,5);
        printData(3,2);
      //  printData(1,7);     //7.sutun olmadigi icin NoSuchElementException hatasini aliriz
        printData(1,1);

    }

    private void printData(int satir, int sutun) {

       WebElement satirSutun= driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(satirSutun.getText());

    }




}
