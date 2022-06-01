package onesource.shiftdigitalsolutions.dummyfortest.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDataEntity {
    String name;
    @SerializedName("SSID")
    @Expose
    String ssid;

    public UserDataEntity(String name, String ssid) {
        this.name = name;
        this.ssid = ssid;
    }
}
