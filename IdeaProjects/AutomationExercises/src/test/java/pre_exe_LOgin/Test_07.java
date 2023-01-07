package pre_exe_LOgin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_07 extends TestBase {


    @Test
    public void test06() {

        //TEST DURUMU 7
        //  7. Oturum Açma-Büyük/küçük harfe duyarlı işler
        //1) Tarayıcıyı açın
        //2) "http://practice.automationtesting.in/" URL'sini girin
        //3) Hesabım Menüsüne tıklayın

        WebElement hesap = driver.findElement(By.xpath("//*[text()='My Account']"));
        hesap.click();

//4) Kullanıcı adı metin kutusuna durum değiştirilen kullanıcı adını girin
        WebElement username = driver.findElement(By.xpath("//input[@id='reg_email']"));
        username.sendKeys("esros@gmail.com");
        //5) Parola tetxbox'ına büyük/küçük harf değiştirilen parolayı girin
        WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
        password.sendKeys("ES.123456?");

//7) Oturum aç düğmesine tıklayın.
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //7) Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar giriş yapılması istenmelidir
        //WebElement error = driver.findElement(By.linkText(" Username is required."));
        //error.isDisplayed();
    }


}
