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
}
