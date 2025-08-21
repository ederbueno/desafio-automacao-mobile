package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class CadastroPage {
    private AppiumDriver driver;
    @AndroidFindBy(id = "name")
    private WebElement nameField;
    @AndroidFindBy(id = "email")
    private WebElement emailField;
    @AndroidFindBy(id = "registerBtn")
    private WebElement registerButton;
    @AndroidFindBy(id = "cadastroTitle")
    private WebElement cadastroTitle;
    @AndroidFindBy(id = "mensagemErro")
    private WebElement mensagemErro;
    public CadastroPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void cadastrar(String name, String email) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        registerButton.click();
    }
    public boolean isCadastroDisplayed() {
            return cadastroTitle.isDisplayed();
    }
    public String getMensagemErro() {
            return mensagemErro.getText();
    }
}
