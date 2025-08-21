package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CSVUtils;

public class LoginTest extends BaseTest {

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
