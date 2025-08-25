package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {
    private AppiumDriver driver;

     @AndroidFindBy(id = "switch")
    private WebElement switchFiled;
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'button-Active')]")
    private WebElement activeButton;

    @AndroidFindBy(accessibility="Forms" )
    private WebElement formButton;
    @AndroidFindBy(id = "android:id/message")
    private WebElement mensagemSucces;

    public FormPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void preencherFormulario(String type, String texto) {
        typeField(type);
        dropDown(texto);
    }
    public boolean isFormularioEnviado() {
        return mensagemSucces.isDisplayed();
    }
    public void clicarNoBotaoForms() {
        WebElement formsButton = driver.findElement(MobileBy.AccessibilityId("Forms"));
        formsButton.click();
    }
    public void typeField(String texto) {
        WebElement typeField = driver.findElement(MobileBy.xpath("//android.widget.EditText[@content-desc='text-input']"));
        typeField.sendKeys(texto);
    }
    public void dropDown(String texto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.xpath("//android.widget.EditText[@resource-id='text_input']")));
                dropDown.click();
        WebElement dropDownValue = wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='" + texto + "']")));
                dropDownValue.click();
    }

    public void activeButton(){
        WebElement active = driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc='button-Active']/android.view.ViewGroup" ));
        active.click();
    }

}
