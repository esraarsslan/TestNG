package caseler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Ex_06 extends TestBase {

    @Test
    public void test06() throws InterruptedException {

        //Test Case 6: Contact Us Form
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.xpath("//*[text()=' Home']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println(" Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        //4. Click on ‘Contact Us’ button
        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();

        //5. Verify ‘GET IN TOUCH’ is visible
        WebElement touch = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(touch.isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Esra", Keys.TAB,"esra@gmail.com",Keys.TAB,"salih",Keys.TAB,"Selenium cok zevkli");
        //7. Upload file
      WebElement uploadFile =  driver.findElement(By.xpath("//input[@name='upload_file']"));
       // uploadFile.sendKeys("/Users/esarac/Downloads/java");
        //Thread.sleep(2000);

        //8. Click ‘Submit’ button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).submit();

        //9. Click OK button

        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        //10. Verify success message ‘Success! Your details have been submitted successfully.’ is visible
        WebElement succes= driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(succes.isDisplayed());
        //11. Click ‘Home’ button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();

    }
}
