import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ComputersPage;
import pages.NewComputerPage;

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
        String title = driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText();
        Assert.assertEquals( title, "Add a computer");
    }

    @Test
    public void newComputerTest() {
        String computerName = "Samsung Galaxy Tab";
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
        String expectedText = driver.findElement(By.xpath("//div[@id='pagination']//li[@class='current']/a")).getText();
        Assert.assertEquals(expectedText,"Displaying 1 to 1 of 1");
        String expectedComputerName = driver.findElement(By.xpath("//td/a")).getText();
        Assert.assertEquals(expectedComputerName,computerName);
        String expectedDate = driver.findElement(By.xpath("//tr/td[3]")).getText();
        Assert.assertEquals(expectedDate,currentTimeStamp);
    }

    @AfterClass
    public void quit() {
        driverManager.quitWebDriver();
    }
}
