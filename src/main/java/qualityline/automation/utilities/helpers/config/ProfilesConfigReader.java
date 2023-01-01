package qualityline.automation.utilities.helpers.config;

public class ProfilesConfigReader extends ConfigReader {

    private static ConfigReader instance;

    public ProfilesConfigReader() {
        super("/config/profile_config.properties");
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new ProfilesConfigReader();
                }
            }
        }
        return instance;
    }
}
