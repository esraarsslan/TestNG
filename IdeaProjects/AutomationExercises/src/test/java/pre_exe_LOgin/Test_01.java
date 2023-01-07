package pre_exe_LOgin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_01{
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


        //TEST CASE  1
        // 1. Log-in with valid username and password.
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”


        //3) Click on My Account Menu
      WebElement hesap= driver.findElement(By.xpath("//*[text()='My Account']"));
      hesap.click();
        //4) Enter registered username in username textbox
       // WebElement username = driver.findElement(By.xpath("//input[@id='reg_email']"));
        //username.sendKeys("esra@gmail.com");
        //5) Enter password in password textbox
      //  WebElement password = driver.findElement(By.xpath("//input[@id='reg_password']"));
       // password.sendKeys("es.123456?");
        driver.findElement(By.xpath("//*[@name='register']")).click();
        //6) Click on login button
    WebElement loginUsername= driver.findElement(By.xpath("//input[@id='username']"));
    loginUsername.sendKeys("esra@gmail.com", Keys.TAB,"es.123456?");
    driver.findElement(By.xpath("//input[@value='Login']")).click();

        //7) User must successfully login to the web page


    }
}