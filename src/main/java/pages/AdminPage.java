package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminPage extends PageBase{
    public AdminPage(WebDriver driver) {
        super(driver);
    }
    public int previousRecordNumber;
    public int currentRecordNumber;
    private static By adminButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private static By listRecords= By.xpath("//div[@class='oxd-table-card']");
    private static By userNameSearchBar=By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']");
    private static By searchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private static By removeButton =By.xpath("//i[@class='oxd-icon bi-trash']");
    private static By confirmeDeleteUser=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");

    public void getCurrentRecordsNumber(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listRecords));
        List<WebElement> allUsers =driver.findElements(listRecords);
        previousRecordNumber= allUsers.size();
        System.out.println(previousRecordNumber);
    }
    public void getNewCurrentRecordsNumber(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listRecords));
        List<WebElement> allUsers =driver.findElements(listRecords);
        currentRecordNumber= allUsers.size();
        System.out.println(currentRecordNumber);
    }

    public void pressAddButton(){
        clickButton(adminButton);
    }
    public void searchWithUserName(String userName){
        sendText(userNameSearchBar,userName);
        clickButton(searchButton);
    }
    public void clickOnRemoveUserButton(){
        clickButton(removeButton);
    }
    public void clickOnConfirmDeleteUser(){
        clickButton(confirmeDeleteUser);
    }
}

