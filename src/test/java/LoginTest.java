import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;
    String expTitle = "https://mail.ukr.net/desktop/login";

    @BeforeClass
    public  void  setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get(expTitle);
    }

    @Test(description = "Login")
    public void  loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("alex2019hillel","A661956a");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(loginPage.userMail).getText(), "alex2019hillel@ukr.net");
    }

    @AfterClass
    public void quit() {
        driverManager.quitWebDriver();
    }
}
