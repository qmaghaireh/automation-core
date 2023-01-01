package qualityline.automation.mobile.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class IOSDevice extends Device {
    @SerializedName("udid")
    @Expose
    private String udid;

    @SerializedName("showIOSLog")
    @Expose
    private String showIOSLog;
}
