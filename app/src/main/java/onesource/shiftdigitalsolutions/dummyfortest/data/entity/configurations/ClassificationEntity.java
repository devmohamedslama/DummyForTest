package onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class ClassificationEntity {

    @PrimaryKey(autoGenerate = true)
    public long clId;

    @SerializedName("Id")
    @Expose
    Integer classificationId;

    @SerializedName("FlourCategoryId")
    @Expose
    Integer categoryId;

    @SerializedName("FlourClassificationName")
    @Expose
    String classificationName;

    public ClassificationEntity(Integer classificationId, Integer categoryId, String classificationName) {
        this.classificationId = classificationId;
        this.categoryId = categoryId;
        this.classificationName = classificationName;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    @NonNull
    @Override
    public String toString() {
        return "ClassificationEntity{" +
                "classificationId=" + classificationId +
                ", categoryId=" + categoryId +
                ", classificationName='" + classificationName + '\'' +
                '}';
    }
}
