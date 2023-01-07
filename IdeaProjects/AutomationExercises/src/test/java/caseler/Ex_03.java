package caseler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex_03 {

    WebDriver driver;

    @Before
    public void setUp() {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible
         */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1() {

        //3. Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.xpath("//*[text()=' Home']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println(" Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        //        4. Click on 'Signup / Login' button

        driver.findElement(By.xpath("//a [@href='/login']")).click();
        //        5. Verify 'Login to your account' is visible
        WebElement login= driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());
        //        6. Enter incorrect email address and password
        driver.navigate().refresh();
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("esraa@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123");
        //        7. Click 'login' button
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        //        8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrect = driver.findElement(By.xpath("//p['Your email or password is incorrect!']"));
                Assert.assertTrue(incorrect.isDisplayed());
    }
}