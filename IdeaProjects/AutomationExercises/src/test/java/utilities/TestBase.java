package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;


public abstract  class TestBase {
        // driver objesini olustur...
        // Driver ya public ya da protected olmali. Sebebi; diger child classlarda gorunebilmesidir.
        protected static WebDriver driver;


        //SEtup
        @Before
        public void setup() {

//            //Chrome'a Adblock uzantısını yükle
//            ChromeOptions options = new ChromeOptions();
//            options.addExtensions(new File("C:\\Users\\hp\\REKLAM ENGELLEYICI\\extension_5_3_3_0.crx"));
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//            options.merge(capabilities);
            //Yeni sekme açılana kadar bekle
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            wait.until(t -> t.getWindowHandles().size() == 2);
//            //İkinci(Uzantı) sekmesini kapat orjinal sayfaya dön
//            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1));
//            driver.close();
//            driver.switchTo().window(tabs.get(0));


            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          //  driver.get("http://practice.automationtesting.in/");
            driver.get("http://automationexercise.com");
            // 3. Verify that home page is visible successfully.//3. Ana sayfanın başarıyla göründüğünü doğrulayin...
            WebElement anaSayfa = driver.findElement(By.xpath("//*[text()=' Home']"));
            if (anaSayfa.isDisplayed()) {
                System.out.println(" Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        }

        //TearDown
        @After
        public void tearDown() throws InterruptedException {
            //   driver.quit();

        }
        //    MULTIPLE WINDOW

        //1 parametre alir : Gecis yapmak istedigim sayfanin title i
        //Orn:  driver.get("https://the-internet.herokuapp.com/windows");
        // switchToWindow("New Window")
        public static void switchToWindow(String targetTitle) {
            String origin = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(targetTitle)) {
                    return;
                }
            }
            driver.switchTo().window(origin);
        }


    }


