package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By fildUserName = By.xpath("//*[@id='id-l']");
    private By fildPassword = By.xpath("//*[@id='id-p']");
    private By loginButton = By.xpath("//*[@type='submit']");
    public By userMail = By.xpath("//*[@class='login-button__user']");


    public void login(String userName,String password) {
        this.setUsername(userName);
        this.setPassword(password);
        this.clickLogin();
       // this.user();
    }
    public void setUsername(String userName) {
        driver.findElement(fildUserName).sendKeys(userName);
    }
    public void setPassword(String password) {
        driver.findElement(fildPassword).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    //public void user() {
    //    driver.findElement(userMail).getText();
    //    return;
    //}

}
