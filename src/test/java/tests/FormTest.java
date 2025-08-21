package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.FormPage;
import pages.HomePage;
import utils.CSVUtils;

public class FormTest extends BaseTest {

    @DataProvider(name = "formData")
    public Object[][] loginData() {
        return CSVUtils.readCSV("src/resources/data/formData.csv");
    }

    @Test(dataProvider = "formData")
    public void testPreenchimentoFormulario(String campo1, String campo2) {
        HomePage homePage = new HomePage(driver);
        homePage.acessarFormulario();

        FormPage formPage = new FormPage(driver);
        formPage.preencherFormulario(campo1, campo2);

        assert formPage.isFormularioEnviado();    }


}
