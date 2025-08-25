package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class CadastroPage {
    private AppiumDriver driver;

    @AndroidFindBy(xpath="//*[@text='Login']")
    private WebElement botaoLogin;
    @AndroidFindBy(xpath = "//*[@content-desc='input-email']")
    private WebElement emailField;
    @AndroidFindBy(xpath = "//*[@content-desc='input-password']")
    private WebElement passField;
    @AndroidFindBy(xpath = "//*[@content-desc='button-LOGIN']//android.view.ViewGroup")
    private WebElement loginButton;
    @AndroidFindBy(xpath = "//*[@text='Please enter a valid email address']")
    private WebElement emailError;
    @AndroidFindBy(xpath = "//*[@text='Please enter at least 8 characters']" )
    private WebElement passError;
    public CadastroPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void cadastrar(String pass, String email) {
        botaoLogin.click();
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginButton.click();
    }
    public boolean isCadastroDisplayed() {
            return emailError.isDisplayed();
    }
    public String getMensagemErro() {
            return passError.getText();
    }
}
