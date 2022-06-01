package onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ConfigurationEntity {

    @SerializedName("Markets")
    @Expose
    List<MarketsEntity> marketsEntityList;

    @SerializedName("FlourProductCategory")
    @Expose
    List<CategoryEntity> categoryEntityList;

    @SerializedName("FlourProductClassification")
    @Expose
    List<ClassificationEntity> classificationEntityList;

    @SerializedName("FlourProductDefinition")
    @Expose
    List<DefinitionEntity> definitionEntityList;

    @SerializedName("DeviceName")
    @Expose
    String deviceName;


    public List<MarketsEntity> getMarketsEntityList() {
        return marketsEntityList;
    }

    public List<CategoryEntity> getCategoryEntityList() {
        return categoryEntityList;
    }

    public List<ClassificationEntity> getClassificationEntityList() {
        return classificationEntityList;
    }

    public List<DefinitionEntity> getDefinitionEntityList() {
        return definitionEntityList;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public String toString() {
        return "ConfigurationEntity{" +
                "marketsEntityList=" + marketsEntityList +
                ", categoryEntityList=" + categoryEntityList +
                ", classificationEntityList=" + classificationEntityList +
                ", definitionEntityList=" + definitionEntityList +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}
