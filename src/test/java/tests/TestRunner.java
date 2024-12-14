package tests;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/tests",
        glue = {"tests"},
        tags = "@add")
public class TestRunner extends TestBase {

}
