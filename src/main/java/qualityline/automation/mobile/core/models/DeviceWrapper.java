package qualityline.automation.mobile.core.models;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URL;
import java.nio.charset.StandardCharsets;

@Data
public class DeviceWrapper {

    public static String CAPABILITIES_PATH = "CAPABILITIES_PATH";

    @SerializedName("iOS")
    @Expose
    private IOSDevice ios;

    @SerializedName("android")
    @Expose
    private AndroidDevice android;

    public static DeviceWrapper create() {
        URL url = Resources.getResource(System.getProperty(CAPABILITIES_PATH));
        try {
            String json = Resources.toString(url, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            return gson.fromJson(json, DeviceWrapper.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}