package pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private AppiumDriver driver;

    @AndroidFindBy(xpath="//*[@text='Login']")
    private WebElement navLogin;
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

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/message']")
    private WebElement modalLoginSuccess;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String userName, String pass) {
        navLogin.click();
        emailField.sendKeys(userName);
        passField.sendKeys(pass);
        loginButton.click();
    }
    public boolean loginSuccess(){
        return modalLoginSuccess.isEnabled();
    }

    public String emailError(){
        return emailError.getText();
    }

    public String passError(){
        return passError.getText();
    }


}
