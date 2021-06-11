

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //mvn clean -D'cucumber.options=--glue Steps' -DargLine='-Dplatform="web"' test //for web app
        //mvn clean -D'cucumber.options=--glue Steps_Android' -DargLine='-Dplatform="android"' test //for android app
        features = {"src/test/features/"},
        glue = "steps",
        plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml"},
        monochrome = true,

        tags = "@SearchOnGoogle"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
