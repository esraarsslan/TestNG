package caseler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Ex_09 extends TestBase {

    @Test
    public void test09(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProduct = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProduct.isDisplayed());

        //6. Enter product name in search input and click search button
        WebElement urunIsmi = driver.findElement(By.xpath("//input[@id='search_product']"));
               urunIsmi.sendKeys("POLO");
               driver.findElement(By.xpath("//button[@id='submit_search']")).click();


        //7. Verify 'SEARCHED PRODUCTS' is visible

        WebElement searchProucts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchProucts.isDisplayed());

        //8. Verify all the products related to search are visible
        WebElement urunler= driver.findElement(By.xpath("//*[@class='fa fa-plus-square']"));
        Assert.assertTrue(urunler.isDisplayed());

    }
}
