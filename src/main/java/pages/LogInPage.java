package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends PageBase{
    public LogInPage(WebDriver driver) {super(driver);}

    private static By usernameTextBox = By.name("username");
    private static By passwordTextBox = By.name("password");
    private static By loginButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

    public void loginToDemoSite(String userNameValue, String passwordValue) {
        sendText(usernameTextBox, userNameValue);
        sendText(passwordTextBox, passwordValue);
        clickButton(loginButton);
    }


}
