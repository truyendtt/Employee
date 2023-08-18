package tests;


import common.TestBasic;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import Pages.HomePage;
import Pages.PageLogin;
public class TestCase {
    TestBasic testBase = new TestBasic();
    @Parameters({"browser" , "envi"})
    @BeforeTest
    public void openWeb(String Browser, String envi) {
        testBase.openWebsite(Browser, envi);
        PageLogin pageLogin = new PageLogin(testBase.driver);
        HomePage homePage = pageLogin.loginKV(testBase.getRetailerName(envi) , testBase.getUserName(envi), testBase.getPassword(envi));
    }
}
