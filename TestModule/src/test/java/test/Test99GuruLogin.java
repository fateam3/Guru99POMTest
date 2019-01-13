package test;


import java.util.concurrent.TimeUnit;

import com.common.Guru99Login;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pages.Guru99HomePage;



public class Test99GuruLogin {

    WebDriver driver;

    Guru99Login objLogin;

    Guru99HomePage objHomePage;

    @BeforeTest

    public void setup() {

        System.setProperty("webdriver.gecko.driver", "/Users/shamimchy/Documents/geckodriver");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");

    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * <p>
     * Verify login page title as guru99 bank
     * <p>
     * Login to application
     * <p>
     * Verify the home page using Dashboard message
     */

    @Test(priority = 0)

    public void test_Home_Page_Appear_Correct() throws InterruptedException {

        //Create Login Page object

        objLogin = new Guru99Login(driver);

        //Verify login page title

        String loginPageTitle = objLogin.getLoginTitle();

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        //login to application

        objLogin.loginToGuru99("mgr123", "mgr!23");

        // go the next page

        objHomePage = new Guru99HomePage(driver);

        //Verify home page

        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
        Thread.sleep(1000);
        driver.close();
    }
}