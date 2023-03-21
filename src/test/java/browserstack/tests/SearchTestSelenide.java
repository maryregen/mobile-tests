package browserstack.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
public class SearchTestSelenide extends TestBase {

    String searchCriteria = "java";

        @Test
        @Tag("android")
        void successfulSearchTest() {
            step("Type search", () -> {
                $(accessibilityId("Search Wikipedia")).click();
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchCriteria);
            });
            step("Verify content found", () -> {
                    $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                            .shouldHave(sizeGreaterThan(0));
            });
        }

        @Test
        @Tag("android")
         void openSearchResult(){
            step("Type search", () -> {
                $(accessibilityId("Search Wikipedia")).click();
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchCriteria);
            });
            step("Open search result", () -> {
                    $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
            });
        }

        @Test
        @Tag("ios")
        void verifyContentOnResultPage() {
            step("Click text button", () -> {
                $(id("Text Button")).click();
            });
            step("Search information", () -> {
                $(id("Text Input")).click();
                $(id("Text Input")).sendKeys(searchCriteria);
                $(id("Text Input")).pressEnter();
            });
            step("Verify content found", () -> {
                $(id("Text Output")).shouldHave(text(searchCriteria));
        });
        }
}
