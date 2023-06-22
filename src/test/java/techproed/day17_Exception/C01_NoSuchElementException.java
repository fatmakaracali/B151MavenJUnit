package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {



    @Test
    public void NoSuchElementException01() {
        /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.
        *Webelement bir iframe icinde olabilir, bir butona tikladigimizda yeni bir
        pencere acilabilir yada alert cikabilir bu gibi durumlarda da nosuchelementexception aliriz
         */


        //techproEducation sayfasina gidiniz.

        driver.get("https://techproEducation.com");

        //reklami kapatiniz

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //searchBox'a java yazip aratalim

        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("Java", Keys.ENTER);
    }
           /*
        org.openqa.selenium.InvalidSelectorException: xpath ile aldigimiz bir webelementin locate'ini
        cssSelector locator ile kullanirsak bu exception'i aliriz. Dolayisiyla bunu handle etmek icin
        dogru locator'i kullanmamiz gerekir
         */



    }

