package caseler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class Ex_02 extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Launch browser
        //      2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //      3. Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.xpath("//*[text()=' Home']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println(" Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        //      4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a [@href='/login']")).click();
        driver.navigate().refresh();
        //      5. Verify 'Login to your account' is visible
        WebElement login= driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());
        //      6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("esra@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123");

        //      7. Click 'login' button

        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        driver.navigate().refresh();
        //      8. Verify that 'Logged in as username' is visible
        WebElement username = driver.findElement(By.cssSelector("<a><i class=\"fa fa-user\"></i> Logged in as <b>Esra</b></a>"));
        Assert.assertTrue(username.isDisplayed());
        //      9. Click 'Delete Account' button
        driver.findElement(By.linkText(" Delete Account")).click();
        //      10. Verify that 'ACCOUNT DELETED!' is visible


    }
}