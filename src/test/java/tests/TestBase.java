package tests;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase extends AbstractTestNGCucumberTests {

    protected static WebDriver driver;
    protected static Properties props;

    @BeforeSuite
    @Parameters("browser")

    public void setUp(@Optional("chrome")String browserName) {
        props=System.getProperties();
        try {
            props.load(new FileInputStream(("resources/demo-site.properties")));

        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }


        driver.get(props.getProperty("site.url"));

        driver.manage().window().maximize();
    }


    @AfterSuite
    public void tearDown(){
        driver.quit();
    }



}
