package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CadastroPage;
import pages.HomePage;



public class CadastroTest extends BaseTest  {

    @Test
    public void deveValidarUsuarioCadastrado() {
        CadastroPage cadastroPage = new CadastroPage(driver);
        cadastroPage.cadastrar("João Silva", "joao@email.com");

        HomePage homePage = new HomePage(driver);
        assert homePage.isHomeDisplayed();
    }

    @Test
    public void naoDeveValidarUsuarioCadastrado() {
        CadastroPage cadastroPage = new CadastroPage(driver);
        cadastroPage.cadastrar("", "email_invalido");


       assert cadastroPage.getMensagemErro().contains("Campos obrigatórios");
    }
}

