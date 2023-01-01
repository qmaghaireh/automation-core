package qualityline.automation.mobile.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AndroidDevice extends Device {

    @SerializedName("androidInstallTimeout")
    @Expose
    private String androidInstallTimeout;

    @SerializedName("androidAppPackage")
    @Expose
    private String androidAppPackage;

    @SerializedName("androidAppActivity")
    @Expose
    private String androidAppActivity;

    @SerializedName("deviceReadyTimeout")
    @Expose
    private String deviceReadyTimeout;
}