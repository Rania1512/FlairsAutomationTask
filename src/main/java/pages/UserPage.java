package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class UserPage extends PageBase{
    public UserPage(WebDriver driver) {
        super(driver);
    }

    private static By userNameTextBox=By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active'][1]");
    private static By userNamePassword=By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@type='password'][1]");
    private static By confirmPasswordTextBox=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private static By userRoleSelectButton=By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][1]");
    private static By statusSelectButton=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]");
    private static By saveButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

public void fillMandatoryFeilds(String userName,String password) throws InterruptedException {
    sendText(userNameTextBox, userName);
    sendText(userNamePassword, password);
    sendText(confirmPasswordTextBox, password);
}
public void chooseUserRole(String userRole) {
    clickButton(userRoleSelectButton);
    WebElement dropdownmenue = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-select-wrapper")));
    List<WebElement> options = dropdownmenue.findElements(By.tagName("div"));
    for (WebElement option : options) {
        if (option.getText().trim().equals(userRole)) {
            option.click();
            break;
        }
    }
}
public void chooseStatus(String status){
    clickButton(statusSelectButton);
    WebElement statusdropdownmenue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div")));
    List<WebElement> statusoptions = statusdropdownmenue.findElements(By.tagName("div"));
    for (WebElement option : statusoptions) {
        if (option.getText().trim().equals("Enabled")) {
            option.click();
            break;
        }
    }}
public void enterEmployeeName(String employeeName) throws InterruptedException {
    WebElement inputField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
    inputField.sendKeys(employeeName);
    Thread.sleep(3000);
    List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-autocomplete-wrapper")));
    List<WebElement> suggestionslist = suggestions.get(0).findElements(By.tagName("div"));
    for (WebElement suggestion : suggestionslist) {
        if (suggestion.getText().trim().contains(employeeName)) {
            suggestion.click();
            break;
        }
    }
}
public void saveNewUser(){
    clickButton(saveButton);
}

    }




