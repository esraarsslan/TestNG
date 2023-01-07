package pre_exe_LOgin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_08 extends TestBase {

    @Test
    public void test08(){

        //TEST DURUMU 8
        //  8. Oturum Açma-Kimlik Doğrulama
        //1) Tarayıcıyı açın
        //2) "http://practice.automationtesting.in/" URL'sini girin







        //3) Hesabım Menüsüne tıklayın
        WebElement hesap = driver.findElement(By.xpath("//*[text()='My Account']"));
        hesap.click();

        //4) Kullanıcı adı metin kutusuna durum değiştirilen kullanıcı adını girin
       // WebElement username = driver.findElement(By.xpath("//input[@id='reg_email']"));
        //username.sendKeys("esros@gmail.com");
        //5) Parola tetxbox'ına büyük/küçük harf değiştirilen parolayı girinn
       // WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
       // password.sendKeys("ES.123456?");

        //6) Şimdi giriş düğmesine tıklayın

        //driver.findElement(By.xpath("//*[@name='register']")).click();

        WebElement loginUsername= driver.findElement(By.xpath("//input[@id='username']"));
        loginUsername.sendKeys("esros@gmail.com",Keys.TAB);
//
        WebElement sifre= driver.findElement(By.xpath("//input[@id='password']"));
       sifre.sendKeys("ES.123456?");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        //7) Giriş yaptıktan sonra siteden çıkış yapın
        driver.findElement(By.linkText("Sign out")).click();

        //8) Şimdi geri düğmesine basın
        driver.navigate().back();

        //9) Kullanıcı hesabında oturum açmamalı, bunun yerine genel bir web sayfası görünür olmalıdır

         driver.findElement(By.xpath("//*[text()='Test Cases']")).click();
    }
}
