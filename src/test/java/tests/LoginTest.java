package tests;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CSVUtils;

public class LoginTest {
    private AppiumDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return CSVUtils.readCSV("src/resources/data/login.csv");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(driver.getPageSource().contains(expectedMessage));
    }
}
