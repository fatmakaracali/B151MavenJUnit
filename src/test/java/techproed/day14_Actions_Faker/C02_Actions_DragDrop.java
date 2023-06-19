package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        //drog ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz

        driver.switchTo().frame(0);

        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
    }

    @Test
    public void test02() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        //drog ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz

        driver.switchTo().frame(0);

        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basılı tuttuk
                moveToElement(drop).//-->Bu method ile basılı tuttuğumuz we'ti diğer we'tin üzerine götürdük
                release().//-->Bu method ile basılı tuttuğumuz we'ti serbest bıraktık
                perform();//--> işlemi sonlandırdık




    }
}