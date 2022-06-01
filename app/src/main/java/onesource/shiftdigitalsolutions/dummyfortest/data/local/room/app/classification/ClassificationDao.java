package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.classification;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.ClassificationEntity;

@Dao
public interface ClassificationDao {
    @Insert
    Single<Long> insertClassificationEntity(ClassificationEntity classificationEntity);

    @Query("SELECT * FROM ClassificationEntity WHERE categoryId = :categoryId")
    Single<List<ClassificationEntity>> getClassificationEntityById(Integer categoryId);
}
