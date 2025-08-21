package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CadastroPage;
import pages.HomePage;
import pages.LoginPage;


public class NavigationTest extends BaseTest {

    @Test
    public void testNavegacaoCadastro() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.irParaCadastro();

        CadastroPage cadastroPage = new CadastroPage(driver);
        assert cadastroPage.isCadastroDisplayed();
    }

    @Test
    public void testNavegacaoFormulario() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("usuario", "senha");

        HomePage homePage = new HomePage(driver);
        homePage.acessarFormulario();

        assert homePage.isHomeDisplayed();
    }
}
