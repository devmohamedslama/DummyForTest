package onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class DefinitionEntity {

    @PrimaryKey(autoGenerate = true)
    public long dId;

    @SerializedName("Id")
    @Expose
    Integer definitionId;

    @SerializedName("FlourClassificationId")
    @Expose
    Integer classificationId;

    @SerializedName("ProductSize")
    @Expose
    String definitionName;

    public DefinitionEntity(Integer definitionId, Integer classificationId, String definitionName) {
        this.definitionId = definitionId;
        this.classificationId = classificationId;
        this.definitionName = definitionName;
    }

    public Integer getDefinitionId() {
        return definitionId;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public String getDefinitionName() {
        return definitionName;
    }

    @NonNull
    @Override
    public String toString() {
        return "DefinitionEntity{" +
                "definitionId=" + definitionId +
                ", classificationId=" + classificationId +
                ", definitionName='" + definitionName + '\'' +
                '}';
    }
}
