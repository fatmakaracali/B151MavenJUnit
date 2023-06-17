package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {


    @Test
    public void name() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin

        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Kutuya sag tıklayın

        WebElement box= driver.findElement(By.id("hot-spot"));

        //Sag klik yapabilmek icin oncelikle Actions classindan bir obje olusturmaliyiz
        Actions action= new Actions(driver);

        action.contextClick(box).perform();

        wait(2);

        // Alert’te cikan yazinin“You selected a context menu”oldugunu test edin

        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        wait(2);

        // Tamam diyerek alert’i kapatın

        alertAccept();
    }

    @Test
    public void test03() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(84,28).release().   //belirtmis oldugumuz koordinatlara göturur
                perform();


    }














}