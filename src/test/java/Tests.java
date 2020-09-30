import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ComputersPage;
import pages.NewComputerPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests {
    DriverManager driverManager;
    WebDriver driver;
    ComputersPage computersPage;
    NewComputerPage newComputerPage;

    @BeforeClass
    public void setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        computersPage = new ComputersPage(driver);
        newComputerPage = new NewComputerPage(driver);
    }

    @Test
    public void computersDatabaseTest() {
        computersPage.getComputersPage();
        computersPage.clickAddComputer();
        String title = driver.findElement(By.xpath("//*[@id='main']/h1")).getText();
        Assert.assertEquals( title, "Add a computer");
    }

    @Test
    public void newComputerTest() {
        String computerName = "Sony 400S";
        String currentTimeStamp = newComputerPage.getCurrentTimeStamp();
        newComputerPage.setComputerName(computerName);
        newComputerPage.setIntroduced();
        newComputerPage.setDiscontinued(currentTimeStamp);
        newComputerPage.setCompany();
        newComputerPage.clickCreateComputer();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        computersPage.setComputerName(computerName);
        computersPage.clickComputerSearch();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(rows.size() > 0);
        List<WebElement> fields = driver.findElements(By.xpath("//tbody/tr/td[2][contains(text(),'" + currentTimeStamp + "')]//parent::tr"));
        for (WebElement field : fields) {
            List<WebElement> comps = field.findElements(By.xpath("td/a//parent::td//parent::tr"));
            for (WebElement comp : comps) {
                String computer = comp.findElement(By.xpath("td/a[text()='" + computerName + "']")).getText();
                Assert.assertEquals(computer, computerName);
            }
        }
    }


    @AfterClass
    public void quit() {
        driverManager.quitWebDriver();
    }
}
