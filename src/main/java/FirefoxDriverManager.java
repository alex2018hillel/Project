import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        FirefoxProfile options = new FirefoxProfile();
        this.driver = new FirefoxDriver(options);

    }

}
