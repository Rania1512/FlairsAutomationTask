package tests.login_to_demo_site;

import io.cucumber.java.en.And;
import tests.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DashBoard;
import pages.LogInPage;

public class LoginToDemoSiteStepDefs extends TestBase {

    LogInPage login;
    DashBoard dashBoard;


    @Then("user access dashboard successfully")
    public void userAccessDashboardSuccessfully() {
        dashBoard=new DashBoard(driver);
        Assert.assertEquals(dashBoard.getDashBoardUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");


    }


    @Given("user login with {string} and {string} in demo site")
    public void userLoginWithAndInDemoSite(String UserName, String Password) {
        login= new LogInPage(driver);
        login.loginToDemoSite(props.getProperty(UserName), props.getProperty(Password));
    }



}
