package qualityline.automation.utilities.helpers.config;

public class CommonConfigReader extends ConfigReader {

    private static ConfigReader instance;

    public CommonConfigReader() {
        super("/config/common_config.properties");
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new CommonConfigReader();
                }
            }
        }
        return instance;
    }
}
