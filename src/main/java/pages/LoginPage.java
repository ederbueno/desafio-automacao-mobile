package pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "username")
    private WebElement  usernameField;

    @AndroidFindBy(id = "password")
    private WebElement  passwordField;

    @AndroidFindBy(id = "loginBtn")
    private WebElement  loginButton;

    @AndroidFindBy(id = "goToRegisterBtn")
    private WebElement goToRegisterButton;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void irParaCadastro() {
        goToRegisterButton.click();
    }


}
