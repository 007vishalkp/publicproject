
package steps;

import com.google.common.io.Files;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.DriverManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScenarioHook {

  @Before
  public void beforeScenario() {
    DriverManager.initWindowsDriver();
  }

  @After
  public void afterScenario(Scenario scenario) throws InterruptedException {
    if (scenario.isFailed()) {
      getScreenshot(scenario.getName());
      System.out.println(scenario.getName());
    }
    DriverManager.close();
  }

  public void getScreenshot(String methodName) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
      Date date = new Date();
      File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
      Files.copy(scrFile, new File(System.getProperty("user.dir") + "/FailedScreenshots/screenshot_" + methodName + "_" + dateFormat.format(date) + ".png"));
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
}