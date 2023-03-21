package browserstack.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})

public interface MobileConfig extends Config {
    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("app")
    String getApp();
}
