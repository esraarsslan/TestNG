package pre_exe_LOgin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_05 extends TestBase {


    @Test
    public void test05(){

        WebElement hesap= driver.findElement(By.xpath("//*[text()='My Account']"));
        hesap.click();

        //4Bos kullanıcı adı ve dogru şifre ile oturum açın.
        WebElement username = driver.findElement(By.xpath("//input[@id='reg_email']"));
        username.sendKeys("");

        WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
        password.sendKeys("");

//7) Oturum aç düğmesine tıklayın.
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //7) Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar giriş yapılması istenmelidir
        //WebElement error = driver.findElement(By.linkText(" Username is required."));
        //error.isDisplayed();
    }

}



