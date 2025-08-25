package dataprovider;

import org.testng.annotations.DataProvider;
import utils.CSVUtils;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return CSVUtils.readCSV("src/main/resources/data/login.csv");
    }

    @DataProvider(name = "formData")
    public Object[][] formData() {
        return CSVUtils.readCSV("src/main/resources/data/formData.csv");
    }
}
