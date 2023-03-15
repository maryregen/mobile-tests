package browserstack.drivers;

import browserstack.configs.AuthConfig;
import browserstack.configs.MobileConfig;
import browserstack.configs.ProjectConfig;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
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

        AuthConfig authConfig = ConfigFactory
                .create(AuthConfig.class, System.getProperties());

        MobileConfig mobileConfig = ConfigFactory
                .create(MobileConfig.class, System.getProperties());

        ProjectConfig projectConfig = ConfigFactory
                .create(ProjectConfig.class, System.getProperties());

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
// Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", authConfig.getUser());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getPassword());

// Set URL of the application under test
        mutableCapabilities.setCapability("app", authConfig.getApp());

// Specify device and os_version for testing
        mutableCapabilities.setCapability("device,name", mobileConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", mobileConfig.getPlatformVersion());

// Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", projectConfig.getProject());
        mutableCapabilities.setCapability("build", projectConfig.getBuild());
        mutableCapabilities.setCapability("name", projectConfig.getName());

    // Initialise the remote Webdriver using BrowserStack remote URL
// and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(projectConfig.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
