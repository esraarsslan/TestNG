package caseler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Ex_08 extends TestBase {
    @Test
    public void test08() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProduct = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProduct.isDisplayed());

        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("*[class='features_items']")).isDisplayed());


        //7. Click on 'View Product' of first product
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();

        //driver.findElement(By.xpath("//*[@class='fa fa-plus-square'][1]")).click();

        //8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.cssSelector("*[class='product-information']")).isDisplayed());


        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement name = driver.findElement(By.xpath("(//h2['Blue Top'])[3]"));
        Assert.assertTrue(name.isDisplayed());

        WebElement category = driver.findElement(By.xpath("//p['Category: Women > Tops'])[3]"));
        Assert.assertTrue(category.isDisplayed());

        WebElement price = driver.findElement(By.linkText("Rs. 500"));

        Assert.assertTrue(price.isDisplayed());
        WebElement condition = driver.findElement(By.xpath("//b[normalize-space()='Condition:']"));

        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//b[normalize-space()='Brand:']"));
    }

    }
