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

public class Ex_05 {
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
       // driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        // 3. Verify that home page is visible successfully.//3. Ana sayfanın başarıyla göründüğünü doğrulayin...
        WebElement anaSayfa = driver.findElement(By.xpath("//*[text()=' Home']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println(" Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a [@href='/login']")).click();

        //  5. Verify 'New User Signup!' is visible//5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünürlugunu
        WebElement yeniKullanici = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (yeniKullanici.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        //   6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Esra");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("esra@gmail.com");
        Thread.sleep(3000);
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();


        //8. Verify error 'Email Address already exist!' is visible
        WebElement error = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
            Assert.assertTrue(error.isDisplayed());
    }



}

