package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    //  https://www.techproeducation.com adresine gidiniz
//  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

//  techproeducation sayfasına geçiniz
//  youtube sayfasına geçiniz
//  linkedIn sayfasına geçiniz:


    @Test
    public void windowHandle() {


        //  https://www.techproeducation.com adresine gidiniz

        driver.get("https://www.techproeducation.com");

        wait(2);

       // ******Techproeducation sayfasinin handle degerini getWindowHandle() methodu ile elde edebiliriz************

       String techproWindoeHandle=  driver.getWindowHandle();
       System.out.println(" Techpro Handle :"+techproWindoeHandle);

        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

        wait(2);

        String actualTitle= driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps ";



       Assert.assertEquals(expectedTitle,actualTitle);

     //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://www.youtube.com ");

        wait(2);

        String youTubeWindowHandle=  driver.getWindowHandle();
        System.out.println("Youtube Handle :"+ youTubeWindowHandle);


        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        wait(2);

        String linkedInHandle=  driver.getWindowHandle();             // linkedin handle degeriini getWindowHandle ile aldik
        System.out.println("linkedIn Handle :"+ linkedInHandle);


        //  techproeducation sayfasına geçiniz

        driver.switchTo().window(techproWindoeHandle);

        //  youtube sayfasına geçiniz

        driver.switchTo().window(youTubeWindowHandle);

        //  linkedIn sayfasına geçiniz:

        driver.switchTo().window(linkedInHandle);

        //WindowType.TAB -->yeni sekme acar


    }
}
