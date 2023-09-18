package serenity.test.base;

import java.io.File;
import java.time.Duration;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingEdgeWebDriver {
  public static WebDriver driver;
  private static File driverLocation;

  /*
   * Edge
   */

  @BeforeAll
  public static void installDriver() {
    String location = DriverFinder.getPath(EdgeDriverService.createDefaultService(), new EdgeOptions())
        .getBrowserPath();
    driverLocation = new File(location);
  }

  @AfterEach
  public void quit() {
    driver.quit();
  }

  public static void setEdgeDriver() {
    EdgeDriverService service = new EdgeDriverService.Builder()
        .build();
    driver = new EdgeDriver(service);
  }

  public static WebDriverWait waitTime(long timeSec) {
    return new WebDriverWait(driver, Duration.ofSeconds(timeSec));
  }

  public static WebDriver getDriver() {
    return driver;
  }

  @Test
  public void initDriver() {
    setEdgeDriver();
    quit();
  }

}
