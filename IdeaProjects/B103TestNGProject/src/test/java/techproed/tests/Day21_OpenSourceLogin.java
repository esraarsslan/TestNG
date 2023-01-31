package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {

    @Test
    public void openSourceLogin() throws InterruptedException {

        //        1.
//        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

//        2. Page Objesi Olustur.
        OpenSourcePage openSourcePage = new OpenSourcePage();

//     3. Bu objeyi kullanarak o classtaki objelere ulas.
//     openSourcePage.username.sendKeys("Admin");
//     openSourcePage.password.sendKeys("admin123");
//     openSourcePage.submitButton.click();

     //DINAMIK KOD HALII******
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submitButton.click();

//        4. ASSERTITION
        OpenSourceDashboardPage  openSourceDashboardPage = new OpenSourceDashboardPage();
        Thread.sleep(3000);

        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());
//      5.Close DRIVER

        Driver.closeDriver();

    }
}
