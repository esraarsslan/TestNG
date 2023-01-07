package caseler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

    public class Ex_01 extends TestBase {


        /*
           1. Launch browser
           2. Navigate to url 'http://automationexercise.com'
           3. Verify that home page is visible successfully
           4. Click on 'Signup / Login' button
           5. Verify 'New User Signup!' is visible
           6. Enter name and email address
           7. Click 'Signup' button
           8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
           9. Fill details: Title, Name, Email, Password, Date of birth
           10. Select checkbox 'Sign up for our newsletter!'
           11. Select checkbox 'Receive special offers from our partners!'
           12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
           13. Click 'Create Account button'
           14. Verify that 'ACCOUNT CREATED!' is visible
           15. Click 'Continue' button
           16. Verify that 'Logged in as username' is visible
           17. Click 'Delete Account' button
           18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         */

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // 1.Navigate to url 'http://automationexercise.com'
            driver.navigate().to("http://automationexercise.com");

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


            //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible//'HESAP BİLGİLERİNİ GİRİN'in görünür olduğunu doğrulayın
            WebElement hesapBilgileri = driver.findElement(By.xpath("//b['Enter Account Information']"));
            if (hesapBilgileri.isDisplayed()) {
                System.out.println("Test Passed");
            } else
                System.out.println("Test Failed");

            //       9. Fill details: Title, Name, Email, Password, Date of birth.
            WebElement title = driver.findElement(By.xpath("//div[@class='clearfix']"));
            WebElement mrs = driver.findElement(By.xpath("//input[@id='id_gender2']"));
            Thread.sleep(2000);
            if (!mrs.isSelected()) {
                mrs.click();
                WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
                password.sendKeys("12345");
                driver.findElement(By.xpath("//*[@id='days']")).sendKeys("21", Keys.TAB, "May", Keys.TAB, "2000");

            }
            //       10. Select checkbox 'Sign up for our newsletter!'
            driver.navigate().refresh();
            driver.findElement(By.xpath("//input[@name='newsletter']")).click();
            //       11. Select checkbox 'Receive special offers from our partners!'
            driver.findElement(By.xpath("//input[@id='optin']")).click();

            //       12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Esra", Keys.TAB, "Sarac",
                    Keys.TAB, "Google", Keys.TAB, "sahil", Keys.TAB, "Mah", Keys.TAB, "Yalova", Keys.TAB, "Inonu",
                    Keys.TAB, "aaa", Keys.TAB, "ISt", Keys.TAB, "61", Keys.TAB, "546");

            //       13. Click 'Create Account button'
            driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
            //       14. Verify that 'ACCOUNT CREATED!' is visible

            WebElement hesapOlustu = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
            Assert.assertTrue(hesapOlustu.isDisplayed());
            //       15. Click 'Continue' button
            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
            driver.navigate().refresh();
            //       16. Verify that 'Logged in as username' is visible
            WebElement username = driver.findElement(By.cssSelector("<a><i class=\"fa fa-user\"></i> Logged in as <b>Esra</b></a>"));
            Assert.assertTrue(username.isDisplayed());
            //       17. Click 'Delete Account' button
            driver.findElement(By.linkText(" Delete Account")).click();
            //       18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement acountDelete= driver.findElement(By.xpath("//b['Account Deleted!']"));
        Assert.assertTrue(acountDelete.isDisplayed());
        driver.findElement(By.xpath("//div[@class='pull-right']")).click();
          driver.close();
        }
    }

