package pages;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "formBtn")
    private WebElement formButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    private WebElement messageLogin;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acessarFormulario() {
        formButton.click();
    }

    public boolean isHomeDisplayed() {
        return messageLogin.isDisplayed();
    }
}

