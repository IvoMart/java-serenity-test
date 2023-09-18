package serenity.test.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://www.google.com/ncr")
public class GoogleSearchPageObject extends PageObject {

    @FindBy(name = "q")
    private WebElementFacade search;

    @FindBy(css = "#rso")
    private WebElementFacade result;

    public void searchFor(String keyword) {
        this.search.sendKeys(keyword, Keys.ENTER);
    }

    public void resultMatches(String expected) {
        assertTrue(this.result.getAttribute("data-async-context").contains(expected));
    }
}