package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class NewComputerPage {
    WebDriver driver;
    public NewComputerPage(WebDriver driver){
        this.driver = driver;
    }

    // Return current time in format "yyyy-MM-dd"
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    // Return current time minus delta(years) in format "yyyy-MM-dd"
    public static String getTimeStamp(int delta) {
        LocalDate dateTime = LocalDate.now();
        LocalDate newDateTime = dateTime.minusYears(delta);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String strDate = newDateTime.format(formatter);
        return strDate;
    }

    private By fieldComputerName = By.xpath("//div[@class='input']/input[@id='name']");
    private By fieldIntroduced = By.xpath("//div[@class='input']/input[@id='introduced']");
    private By fieldDiscontinued = By.xpath("//div[@class='input']/input[@id='discontinued']");
    private By fieldCompany = By.xpath("//div[@class='input']/select[@id='company']/option[@value='42']");
    private By createComputerButton = By.xpath("//*[@class='actions']/input");


    public void setComputerName(String computerName) {
        driver.findElement(fieldComputerName).sendKeys(computerName);
    }

    public void setIntroduced() {
        int delta = 10;
        String strDate = getTimeStamp(delta);
        driver.findElement(fieldIntroduced).sendKeys(strDate);
    }

    public void setDiscontinued(String currentTimeStamp) {
        driver.findElement(fieldDiscontinued).sendKeys(currentTimeStamp);
    }

    public void setCompany() {
        driver.findElement(fieldCompany).click();
    }

    public void clickCreateComputer() {
        driver.findElement(createComputerButton).click();
    }
}
