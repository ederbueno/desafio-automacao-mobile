package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ErroPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "errorMessage")
    private WebElement errorMessage;

    public ErroPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getMensagemErro() {
        return errorMessage.getText();
    }
}
