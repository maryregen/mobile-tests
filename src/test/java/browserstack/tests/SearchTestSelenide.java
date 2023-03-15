package browserstack.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
public class SearchTestSelenide extends TestBase {

    String searchCriteria = "java";

        @Test
        void successfulSearchTest() {

            System.setProperty("platform", "android");

            step("Type search", () -> {
                $(accessibilityId("Search Wikipedia")).click();
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchCriteria);
            });
            step("Verify content found", () ->
                    $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                            .shouldHave(sizeGreaterThan(0)));
        }

        @Test
         void openSearchResult(){

            System.setProperty("platform", "android");

            step("Type search", () -> {
                $(accessibilityId("Search Wikipedia")).click();
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchCriteria);
            });
            step("Open search result", () ->
                    $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
        }

        @Test
        void verifyContentOnResultPage(){

            System.setProperty("platform", "ios");

            step("Type search", () -> {
                $(accessibilityId("Search Wikipedia")).click();
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchCriteria);
            });
            step("Open search result", () ->
                    $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
            step("Verify content found", () ->
                    $$(byText("java"))
                            .shouldHave(sizeGreaterThan(0)));
        }

}
