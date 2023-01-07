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

public class Ex_04 {
    /*
           1. Launch browser
           2. Navigate to url 'http://automationexercise.com'
           3. Verify that home page is visible successfully
           4. Click on 'Signup / Login' button
           5. Verify 'Login to your account' is visible
           6. Enter correct email address and password
           7. Click 'login' button
           8. Verify that 'Logged in as username' is visible
           9. Click 'Logout' button
           10. Verify that user is navigated to login page
         */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

    @Test
    public void test01() {

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
        email.sendKeys("esra@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123");
        //        7. Click 'login' button
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        //      8. Verify that 'Logged in as username' is visible
       // WebElement username = driver.findElement(By.cssSelector("<a><i class=\"fa fa-user\"></i> Logged in as <b>Esra</b></a>"));
       // Assert.assertTrue(username.isDisplayed());


        //9. Click 'Logout' button
        //           10. Verify that user is navigated to login page
    }
}