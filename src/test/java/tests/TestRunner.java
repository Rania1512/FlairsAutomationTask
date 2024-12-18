package tests;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/tests",
        glue = {"tests"},
        tags = "@DeleteUser")
public class TestRunner extends TestBase {

}
