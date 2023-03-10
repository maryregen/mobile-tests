package browserstack;
/*
- Зарегистрировать аккаунт в browserstack.com
- Запустить автотест локально
- Разработать еще один автотест на открытие любой статьи
-* Разработать еще один автотест на iOS
-* Адаптировать TestBase / Driver для работы с двумя типами платформ - Android, iOS
- Вынести данные (логин, пароль, урл браузерстека и т.д.) в .properties с owner
- Сделать сборку в дженкинсе

В качестве ответа на домашнее задание нужно прислать ссылку на репозиторий в гитхаб и аллюр-отчет в дженкинс
 */
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
public class SearchTestSelenide extends TestBase {
        @Test
        void successfulSearchTest() {
            step("Type search", () -> {
                $(accessibilityId("Search Wikipedia")).click();
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
            });
            step("Verify content found", () ->
                    $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                            .shouldHave(sizeGreaterThan(0)));
        }
    }
