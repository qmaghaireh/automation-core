package qualityline.automation.mobile.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Device {

    @SerializedName("app")
    @Expose
    private String app;

    @SerializedName("deviceName")
    @Expose
    private String deviceName;

    @SerializedName("platformName")
    @Expose
    private String platformName;

    @SerializedName("automationName")
    @Expose
    private String automationName;

    @SerializedName("fullReset")
    @Expose
    private String fullReset;

    @SerializedName("noReset")
    @Expose
    private String noReset;

    @SerializedName("newCommandTimeout")
    @Expose
    private String newCommandTimeout;

    @SerializedName("platformVersion")
    @Expose
    private String platformVersion;

}
