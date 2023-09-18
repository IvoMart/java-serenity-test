package serenity.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import serenity.test.pages.GoogleSearchPageObject;

@RunWith(SerenityRunner.class)
public class GoogleSearchPageObjectLiveTest {

  @Managed
  private WebDriver browser;

  GoogleSearchPageObject googleSearch;

  @Test
  public void whenGoogleBaeldungThenShouldSeeEugen() {
    googleSearch.open();

    googleSearch.searchFor("baeldung");

    googleSearch.resultMatches("baeldung");
  }
}