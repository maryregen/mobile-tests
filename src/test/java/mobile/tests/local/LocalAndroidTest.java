package mobile.tests.local;

import mobile.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class LocalAndroidTest extends TestBase {
    @Tag("emulation")
    @DisplayName("Onboard screen test")
    @Test
    void gettingStartedTest() {

        String pageOne = "The Free Encyclopedia …in over 300 languages";
        String pageTwo = "New ways to explore";
        String pageThree = "Reading lists with sync";
        String pageFour = "Send anonymous data";

        step("Check "+ pageOne +" text and tap Continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text(pageOne));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check "+ pageTwo +" text and tap Continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text(pageTwo));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check "+ pageThree +" text and tap Continue", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text(pageThree));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check "+ pageFour +" text", () ->
             $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text(pageFour)));
             $(id("org.wikipedia.alpha:id/acceptButton")).click();
    }
}
