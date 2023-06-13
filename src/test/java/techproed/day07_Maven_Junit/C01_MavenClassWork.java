package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        // http://zero.webappsecurity.com sayfasina gidin

        driver.get(" http://zero.webappsecurity.com");

        // Signin buttonuna tiklayin

        driver.findElement(By.xpath("//button[@id= 'signin_button']")).click();

        // Login alanina  "username" yazdirin

       WebElement login=  driver.findElement(By.xpath("//input[@id='user_login']"));
       login.sendKeys("username");


        // Password alanine "password" yazdirin

       WebElement password= driver.findElement(By.xpath("//input[@id='user_password']"));
       password.sendKeys("password");

        // Sign in buttonuna tiklayin

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Güvenlik problemini gecmek icin sayfada bir geri gelin

        driver.navigate().back();

        // Online Banking bölümüne tıklayalım

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        // Pay Bills yazan kısıma tıklayın

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin

        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");
        Thread.sleep(2000);

        // Date kismina "2020-09-10" yazdirin

        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        Thread.sleep(2000);

        // Pay buttonuna tiklayin

        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        // "The payment was successfully submitted." mesajinin ciktigini test edin

       WebElement massege= driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (massege.isDisplayed()){
            System.out.println("Test passed");
        }else
        {
            System.out.println("Test Failed");
        }
        Thread.sleep(2000);

        // Sayfayi kapatın

       driver.close();


    }
}
