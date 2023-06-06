package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion {




// test01
// https://amazon.com sayfasına gidin
// sayfa baslıgının "Amazon" kelimesini icerdigini test edin


// test02
// https://amazon.com sayfasına gidin
// Amazon resminin görüntülendiğini (isDisplayed()) test edin


// test03
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin


// test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin


// test02
// https://amazon.com sayfasına gidin
// Amazon resminin görüntülendiğini (isDisplayed()) test edin


// test03
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin


// test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // https://amazon.com sayfasına gidin
        driver.get("https://amazon.com");

       //sayfa baslıgının "Amazon" kelimesini icerdigini test edin
     String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));

       Thread.sleep(2000);
    }

    @Test
    public void test02() throws InterruptedException {

        // https://amazon.com sayfasına gidin
        driver.get("https://amazon.com ");

       // Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));

        Assert.assertTrue(logo.isDisplayed());

        Thread.sleep(2000);
    }


    @Test
    public void test03() throws InterruptedException {

        // https://amazon.com sayfasına gidin

        driver.get("https://amazon.com");

        // arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());

        Thread.sleep(2000);
    }


    @Test
    public void test04() {

        // https://amazon.com sayfasına gidin

        driver.get("https://amazon.com");

        // sayfa baslıgının "kitap" icermedigini test edin

        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains("kitap"));

    }
}
