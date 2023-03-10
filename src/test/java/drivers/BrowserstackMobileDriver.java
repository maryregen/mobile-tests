package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
// Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", "bsuser_IW4HJ6");
        mutableCapabilities.setCapability("browserstack.key", "xTkxQA8hziLM1BszqfVe");

// Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

// Specify device and os_version for testing
        mutableCapabilities.setCapability("device", "Samsung Galaxy S23 Ultra");
        mutableCapabilities.setCapability("os_version", "13.0");

// Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");


    // Initialise the remote Webdriver using BrowserStack remote URL
// and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                   new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
