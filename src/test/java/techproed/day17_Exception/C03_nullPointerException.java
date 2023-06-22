package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_nullPointerException extends TestBase {


    /*
        NullPointerException:

        degisken yada obje olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde
        NullPointerException hatasi aliriz.
 */

    WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;

    @Test
    public void nullPointerExceptionTest01() {

        // driver = new ChromeDriver(); atamasını yapmadıgımız icin NullPointerException hatasını aldık.

        driver.get("https://amazon.com");
    }

    @Test
    public void nullPointerExceptionTest02() {

        //faker = new Faker(); atamasini yapmadigimiz icin NullPointerException hatasi aldik

        System.out.println(faker.name().firstName());
    }

    @Test
    public void nullPointerExceptionTest03() {

        //actions = new Actions() atamasini yapmadigimiz icin NullPointerException hatasini aldik

        actions.doubleClick().perform();
    }

    @Test
    public void nullPointerException04() {

        //sayi=6;   sayi degiskenine atama yapmadigimiz icin NullPointerException hatasi aldik

        System.out.println((sayi + 5));

    }

    @Test
    public void nullPointerException05() {

        //isim="Ramazan";   isim degiskenine atama yapmadigimiz icin NullPointer hatasi aldik

        System.out.println(isim.charAt(0));
    }
}
