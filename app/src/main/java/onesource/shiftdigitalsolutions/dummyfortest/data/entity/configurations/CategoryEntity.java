package onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class CategoryEntity {

    @PrimaryKey(autoGenerate = true)
    public long caId;

    @SerializedName("Id")
    @Expose
    Integer categoryId;

    @SerializedName("FlourCategoryName")
    @Expose
    String categoryName;

    public CategoryEntity(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @NonNull
    @Override
    public String toString() {
        return "CategoryEntity{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
