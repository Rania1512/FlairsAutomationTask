package tests.admin_counter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.UserPage;
import tests.TestBase;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.DashBoard;

public class UsersCounterStepDefs extends TestBase {
    DashBoard dashBoard;
    AdminPage adminPage;
    UserPage userPage;

    @When("user press admin tap")
    public void userPressAdminTap() {
        dashBoard=new DashBoard(driver);
        dashBoard.pressOnAdminTap();
    }

    @And("user get the current NumberOfRecords")
    public void userGetTheCurrentNumberOfRecords() {
        adminPage=new AdminPage(driver);
        adminPage.getCurrentRecordsNumber();

    }


    @And("user get the new current Number of records")
    public void userGetTheNewCurrentNumberOfRecords() {
       adminPage.getNewCurrentRecordsNumber();
    }

    @And("user press add new user")
    public void userPressAddNewUser() {
        adminPage.pressAddButton();
    }

    @And("user fill {string} and {string}")
    public void userFillAnd(String userNamefiled, String userPassword) throws InterruptedException {
        userPage=new UserPage(driver);
        userPage.fillMandatoryFeilds(userNamefiled,userPassword);
    }

    @And("user choose {string}")
    public void userChoose(String userRole) {
        userPage.chooseUserRole(userRole);
    }
    @And("user choose user {string}")
    public void userChooseUser(String status) {
        userPage.chooseStatus(status);
    }

    @And("user enter {string}")
    public void userEnter(String employeeName) throws InterruptedException {
        userPage.enterEmployeeName(employeeName);
    }
    @And("user press save button")
    public void userPressSaveButton() {
        userPage.saveNewUser();
    }

    @Then("user added successfully")
    public void userAddedSuccessfully() {
        Assert.assertEquals((adminPage.currentRecordNumber-adminPage.previousRecordNumber),1);
    }

    @And("user press confirm delete user")
    public void userPressConfirmDeleteUser() {
        adminPage.clickOnConfirmDeleteUser();
    }

    @Then("user deleted successfully")
    public void userDeletedSuccessfully() {
        Assert.assertEquals(adminPage.previousRecordNumber-adminPage.currentRecordNumber,1);
    }

    @And("user search with {string}")
    public void userSearchWith(String user) {
        adminPage.searchWithUserName(user);

    }

    @And("user click on remove button")
    public void userClickOnRemoveButton() {
        adminPage.clickOnRemoveUserButton();
    }

    @And("user refresh page")
    public void userRefreshPage() {
        refreshCurrentUrl();
    }
}
