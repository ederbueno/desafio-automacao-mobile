package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "RNE__Input__text-input")
    private WebElement typeField;

    @AndroidFindBy(id = "switch")
    private WebElement switchFiled;

    @AndroidFindBy(id = "text_input")
    private WebElement dropDown;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'button-Active')]")
    private WebElement activeButton;

    @AndroidBy(xpath="//*[@text='Forms']")
    private WebElement  navForms;
    @AndroidFindBy(id = "android:id/message")
    private WebElement mensagemSucces;

    public FormPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void preencherFormulario(String type, int indice) {
        typeField.sendKeys(type);
        selecionarOpcaoPorIndice(indice);
        activeButton.click();
    }
    public void selecionarOpcaoPorIndice(int indice) {
        dropDown.click();
        String xpathOpcao = String.format("(//android.widget.TextView)[%d]", indice);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement opcao = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOpcao)));
        opcao.click();
    }
    public boolean isFormularioEnviado() {
        return mensagemSucces.isDisplayed();
    }
    public void clicarNavForms() throws InterruptedException {
         navForms.click();
    }

}
