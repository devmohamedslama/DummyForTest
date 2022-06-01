package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.category;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.CategoryEntity;

@Dao
public interface CategoryDao {
    @Insert
    Single<Long> insertCategoryEntity(CategoryEntity categoryEntity);

    @Query("SELECT * FROM CategoryEntity")
    Single<List<CategoryEntity>> getAllCategoryEntity();
}
