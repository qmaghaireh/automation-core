package qualityline.automation.utilities.helpers.config;

import org.jetbrains.annotations.NotNull;
import qualityline.automation.utilities.helpers.ConfigKey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public abstract class ConfigReader {

    private final Properties properties;

    public ConfigReader(String path) {
        File file = new File(this.getClass().getResource(path).getFile());
        properties = new Properties();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            properties.load(bufferedReader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public String getPropValue(ConfigKey key) {
        return properties.getProperty(key.getKey());
    }

    @NotNull
    public String getPropValue(String key) {
        return properties.getProperty(key);
    }
}
