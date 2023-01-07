package pre_exe_LOgin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_03 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://practice.automationtesting.in/");
    }

    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        // driver.close();
    }

    @Test
    public void test1() {

//TEST DURUMU 3

//3) Hesabım Menüsüne tıklayın

        WebElement hesap= driver.findElement(By.xpath("//*[text()='My Account']"));
        hesap.click();

        //4. Doğru kullanıcı adı ve boş şifre ile oturum açın.
        WebElement username = driver.findElement(By.xpath("//input[@id='reg_email']"));
        username.sendKeys("esra@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
        password.sendKeys("");

//7) Oturum aç düğmesine tıklayın.
        driver.findElement(By.xpath("//input[@value='Login']")).click();
//8) Uygun hata görüntülenmeli (ör. Geçersiz şifre) ve tekrar oturum açmanız istenmelidir
    }
}