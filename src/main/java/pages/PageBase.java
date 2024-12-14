package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;


public class PageBase {
	protected static Select select ;
	protected static Actions action;
	protected static JavascriptExecutor jse;
	protected static WebDriverWait wait;
	protected static WebDriver driver;
	protected static Properties props;


		public PageBase(WebDriver driver){
			PageBase.driver= driver;
			wait = new WebDriverWait(driver,(Duration.ofSeconds(60)));
			props = System.getProperties();

			try {
				props.load(new FileInputStream(new File("resources/demo-site.properties")));
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

		public void clickButton(By button) {
			wait.until(ExpectedConditions.elementToBeClickable(button));
			safeFind(button).click();}
		public void clearText(By button)
		{
			safeFind(button).clear();
		}

		public void sendText(By textBox, String text){
			safeFind(textBox).sendKeys(text);
		}

		public void scrollToButtom() {
			jse.executeScript("scrollBy(0,2500)");
		}

		public void scrollToUp() {
			jse.executeScript("scrollBy(0,-2500)");
		}

		public String getText(By element){
			return safeFind(element).getText();
		}

		public String getAttribute(By element){
			return safeFind(element).getAttribute("value");
		}

	private WebElement safeFind(By locator) {
		try {
			return driver.findElement(locator);
		}catch (org.openqa.selenium.NoSuchElementException e){
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return driver.findElement(locator);
		}
	}
	public List<WebElement> getListOfElements (By element){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
			return driver.findElements(element);
	}

		public boolean isAlertPresent() {
			try {
				driver.switchTo().alert();
				return true;
			} catch (NoAlertPresentException e) {
				return false;
			}
		}

		public String closeAlertAndGetItsText() {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();

			alert.accept();

			return alertText;
		}


	}
