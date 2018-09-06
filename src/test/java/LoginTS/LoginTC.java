package LoginTS;

import BaseTest.Base;
import LoginPO.LoginPO;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTC extends Base {
    public int flag=1;
    public LoginTC(){

    }
    public LoginTC(WebDriver driver, int falg){
        this.driver=driver;
        this.flag=flag;

    }

    @Test
    public void login(){
        if (flag > 0) {
            test = extent.createTest("login Succsfully");
        }
        LoginPO login = new LoginPO(driver);

        //Step-1 : Enter username and password in RIOT
        String name = "Jpatel39";
        String pass = "India*2018";
        Assert.assertTrue(login.Login(name,pass), "Unable to Enter username and password in RIOT ");
        test.log(Status.PASS,"Enter username and password in RIOT ");

        //Step-2 : verify login is successful in RIOT
        Assert.assertTrue(login.Clcik(), "Unable to  verify login is successful in RIOT");
        test.log(Status.PASS,"verify login is successful in RIOT");

    }

    @Test
    public void login___________2(){
        if (flag > 0) {
            test = extent.createTest("login Succsfully............................");
        }
        test.log(Status.PASS,"Enter username and password in RIOT ");


        test.log(Status.PASS,"verify login is successful in RIOT");

    }
}
