package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "campo1")
    private WebElement campo1;

    @AndroidFindBy(id = "campo2")
    private WebElement campo2;

    @AndroidFindBy(id = "submitBtn")
    private WebElement submitButton;

    @AndroidFindBy(id = "mensagemSucesso")
    private WebElement mensagemSucesso;

    public FormPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void preencherFormulario(String valor1, String valor2) {
        campo1.sendKeys(valor1);
        campo2.sendKeys(valor2);
        submitButton.click();
    }
    public boolean isFormularioEnviado() {
            return mensagemSucesso.isDisplayed();
    }

}
