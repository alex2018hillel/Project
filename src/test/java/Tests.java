import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests {
    DriverManager driverManager;
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
    }

    @Test
    public void googleTest() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
    }

    @AfterClass
    public void quit() {
        driverManager.quitWebDriver();
    }
}
