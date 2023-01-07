package caseler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Ex_07 extends TestBase {


    @Test
    public void test07(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//i[@class = 'fa fa-list']")).click();
        //5. Verify user is navigated to test cases page successfully
        WebElement basarili= driver.findElement(By.xpath("//i[@class = 'fa fa-list']"));
        Assert.assertTrue(basarili.isDisplayed());
    }
}
