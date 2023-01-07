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

public class Test_02 {

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


        //TEST DURUMU 2
        //  2. Yanlış kullanıcı adı ve yanlış şifre ile giriş yapın.

        //1) Tarayıcıyı açın
        //2) "http://practice.automationtesting.in/" URL'sini girin

        //3) Hesabım Menüsüne tıklayın
        WebElement hesap= driver.findElement(By.xpath("//*[text()='My Account']"));
        hesap.click();


        //4) Kullanıcı adı metin kutusuna yanlış kullanıcı adı girin
        WebElement username = driver.findElement(By.xpath("//input[@id='reg_email']"));
        username.sendKeys("esram@gmail.com");

        //5) Şifre metin kutusuna yanlış şifreyi girin.
         WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
         password.sendKeys("123456?");
        //6) Giriş düğmesine tıklayın

        driver.findElement(By.xpath("//input[@value='Login']")).click();
        //7) Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar giriş yapılması istenmelidir
       // WebElement error = driver.findElement(By.linkText(" Username is required."));
        //error.isDisplayed();
    }
}