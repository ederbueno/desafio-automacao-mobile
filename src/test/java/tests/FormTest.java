package tests;

import base.BaseTest;
import dataprovider.LoginDataProvider;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormTest extends BaseTest {

    @Test(dataProvider = "formData", dataProviderClass = LoginDataProvider .class)
    public void testPreenchimentoFormulario(String tipo, String indice) throws InterruptedException {
        FormPage formPage = new FormPage(driver);
        formPage.clicarNavForms();
        formPage.preencherFormulario(tipo, Integer.parseInt(indice));
        assert formPage.isFormularioEnviado();
    }

}
