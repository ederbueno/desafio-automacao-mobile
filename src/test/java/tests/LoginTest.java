package tests;

import base.BaseTest;
import dataprovider.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void deveRealizarLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assert loginPage.loginSuccess();
    }

    @Test
    public void deveRetornarMensagemErroEmail(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test124","teste1234");
        Assert.assertEquals(loginPage.emailError(),"Please enter a valid email address");
    }

    @Test
    public void deveRetornarMensagemErroSenha(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jose.silva@teste.com.br","teste12");
        Assert.assertEquals(loginPage.passError(),"Please enter at least 8 characters");
    }
}
