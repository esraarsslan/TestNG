package pre_exe_LOgin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_04 extends TestBase {
    @Test
    public void test1(){

        //TEST DURUMU 4


        //3) Hesabım Menüsüne tıklayın

        WebElement hesap= driver.findElement(By.xpath("//*[text()='My Account']"));
        hesap.click();

        //4Bos kullanıcı adı ve dogru şifre ile oturum açın.
        WebElement username = driver.findElement(By.xpath("//input[@id='reg_email']"));
        username.sendKeys("");

        WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
        password.sendKeys("es.123456?");

//7) Oturum aç düğmesine tıklayın.
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //7) Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar giriş yapılması istenmelidir
        //WebElement error = driver.findElement(By.linkText(" Username is required."));
        //error.isDisplayed();
    }

}
