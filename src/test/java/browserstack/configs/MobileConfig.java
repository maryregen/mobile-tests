package browserstack.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})

public interface MobileConfig extends Config {

    @Key("platform.version")
    String getPlatformVersion();

    @Key("device.name")
    String getDeviceName();

}
