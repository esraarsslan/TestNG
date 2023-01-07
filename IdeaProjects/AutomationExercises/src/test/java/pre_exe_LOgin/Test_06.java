package pre_exe_LOgin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_06 extends TestBase {

    @Test
    public void test06(){

        //TEST DURUMU 6
        //  6. Oturum açma -Şifre maskelenmelidir
        //1) Tarayıcıyı açın
        //2) "http://practice.automationtesting.in/" URL'sini girin
        //3) Hesabım Menüsüne tıklayın
        WebElement hesap= driver.findElement(By.xpath("//*[text()='My Account']"));
        hesap.click();
        //4) Bazı karakterlerle şifre alanına girin.
        WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
        password.sendKeys("@#$//");

       // 5) Parola alanında, parola ekranda görünmeyecek şekilde yıldız veya madde işareti içindeki karakterler gösterilmelidir.

        password.isDisplayed();


    }

}


