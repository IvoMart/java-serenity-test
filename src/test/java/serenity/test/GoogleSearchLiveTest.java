package serenity.test;

import java.time.Duration;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import serenity.test.base.SettingEdgeWebDriver;

@RunWith(SerenityRunner.class)
public class GoogleSearchLiveTest {

  //@Managed(driver = "chrome")
  @Managed(driver = "edge")
  private WebDriver browser;

  @Test
  public void whenGoogleBaeldungThenShouldSeeEugen() {

    browser.get("https://www.google.com/ncr");

    browser
        .findElement(By.name("q"))
        .sendKeys("baeldung", Keys.ENTER);

    new WebDriverWait(browser, Duration.ofMinutes(1)) // https://www.baeldung.com/serenity-screenplay
        .until(visibilityOfElementLocated(By.cssSelector("#rso")));

    assertTrue(browser
        .findElement(By.id("rso"))
            .getAttribute("data-async-context").contains("baeldung"));

  }
}
