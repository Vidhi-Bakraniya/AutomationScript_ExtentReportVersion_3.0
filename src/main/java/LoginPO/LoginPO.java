package LoginPO;

import BaseTest.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO extends Base {

    public WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver=driver;
    }


    public By user_Xpath = By.xpath("//input[@id='Username']");
    public By password_Xpath = By.xpath("//input[@id='Password']");
    public By Login_Xpath = By.xpath("//button[contains(text(),'Sign In')]");
    public By Logo_Xpath = By.xpath("//img[@class='brand-logo']");



    public Boolean Login(String usernamen ,String password) {
        try{
            WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(user_Xpath));
            WebElement user = driver.findElement(user_Xpath);
            wait.sendKeys(usernamen);

            WebElement pass = driver.findElement(password_Xpath);
            pass.sendKeys(password);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public Boolean Clcik(){
        try{
            WebElement btn = driver.findElement(Login_Xpath);
            btn.click();
            WebElement logo = driver.findElement(Logo_Xpath);
            if (logo.isDisplayed()){
                System.out.println("Login succesfully to RIOT");
                return true;
            }else
                System.out.println("Login unsuccesfully to RIOT");
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
