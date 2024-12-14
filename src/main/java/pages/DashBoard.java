package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard extends PageBase{
    public DashBoard(WebDriver driver) {super(driver);}

    public String getDashBoardUrl() {
        return driver.getCurrentUrl();
    }
    private static By adminTap= By.xpath("//span[text()='Admin']");

    public void pressOnAdminTap(){
        clickButton(adminTap);
    }
}
