package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Base extends Report{
    public WebDriver driver;
    public String Driverpath = "C:\\Program Files\\chromedriver.exe";
    public Base(){

    }


    @Parameters({"browserName", "url"})
    @BeforeMethod
    public void beforeSuite(String browserName, String url) throws Exception {
        getDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(){

        this.driver.quit();

    }


    public WebDriver getDriver(String browserName)throws Exception{
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", Driverpath);
                this.driver = new ChromeDriver();
            }
            return driver;
        }catch (Exception e){
            throw e;
        }
    }
}
