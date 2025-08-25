package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ErroPage;
import pages.FormPage;


public class ErrorMessageTest extends BaseTest {

    @Test
    public void testMensagemErroCamposVazios() {
        FormPage formPage = new FormPage(driver);
        formPage.preencherFormulario("", 0);

        ErroPage errorPage = new ErroPage(driver);
        String mensagem = errorPage.getMensagemErro();

        assert mensagem.contains("Preencha todos os campos");
    }

    @Test
    public void testMensagemErroDadosInvalidos() {
        FormPage formPage = new FormPage(driver);
        formPage.preencherFormulario("123", 0);

        ErroPage errorPage = new ErroPage(driver);
        String mensagem = errorPage.getMensagemErro();

        assert mensagem.contains("Dados inválidos");
    }
}
