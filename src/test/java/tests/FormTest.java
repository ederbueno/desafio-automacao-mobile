package tests;

import base.BaseTest;
import dataprovider.LoginDataProvider;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormTest extends BaseTest {

    @Test(dataProvider = "formData", dataProviderClass = LoginDataProvider.class)
    public void testPreenchimentoFormulario(String tipo, String texto) {
        FormPage formPage = new FormPage(driver);
        formPage.clicarNoBotaoForms();
        formPage.preencherFormulario(tipo, texto);
        formPage.activeButton();
        assert formPage.isFormularioEnviado();
    }

}
