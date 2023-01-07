package pre_anasayfa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class EX_01 extends TestBase {

    @Test
    public void test01() {


        //1) Tarayıcıyı açın
        //2) "http://practice.automationtesting.in/" URL'sini girin
        driver.get("http://practice.automationtesting.in/");
        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//*[text()='Shop']")).click();
        //4) Şimdi Ana menü düğmesine tıklayın
       WebElement anasayfa =  driver.findElement(By.xpath("//*[text()='Home']"));
         anasayfa. click();

        //5) Ana sayfada yalnızca Üç Kaydırıcı olup olmadığını test edin
        WebElement ucSorguSel = driver.findElement(By.xpath("//h3['Selenium Ruby']"));
        Assert.assertTrue(ucSorguSel.isDisplayed());
        WebElement mastering = driver.findElement(By.xpath("//h3['Mastering JavaScript']"));
        Assert.assertTrue(mastering.isDisplayed());
        WebElement thinking = driver.findElement(By.xpath("//h3['Thinking in HTML']"));
        Assert.assertTrue(thinking.isDisplayed());

        //6) Ana sayfa yalnızca üç kaydırıcı içermelidir

//    Assert.assertTrue("anasayfa".contains("ucSorguSel"));
//    Assert.assertTrue("anasayfa".contains("mastering"));
    }
}
