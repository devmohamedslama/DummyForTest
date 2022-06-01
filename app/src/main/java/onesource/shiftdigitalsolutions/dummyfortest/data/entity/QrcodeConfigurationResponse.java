package onesource.shiftdigitalsolutions.dummyfortest.data.entity;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.ConfigurationEntity;

public class QrcodeConfigurationResponse {

    @SerializedName("status")
    @Expose
    Integer status;

    @SerializedName("result")
    @Expose
    ConfigurationEntity configurationEntity;


    public Integer getStatus() {
        return status;
    }

    public ConfigurationEntity getConfigurationEntity() {
        return configurationEntity;
    }

    @NonNull
    @Override
    public String toString() {
        return "QrcodeConfigurationResponse{" +
                "status=" + status +
                ", configurationEntity=" + configurationEntity +
                '}';
    }
}
