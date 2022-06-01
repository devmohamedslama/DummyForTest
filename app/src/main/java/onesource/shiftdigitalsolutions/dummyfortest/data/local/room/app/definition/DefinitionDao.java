package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.definition;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.DefinitionEntity;

@Dao
public interface DefinitionDao {
    @Insert
    Single<Long> insertDefinitionEntity(DefinitionEntity definitionEntity);

    @Query("SELECT * FROM DefinitionEntity WHERE classificationId = :classificationId")
    Single<List<DefinitionEntity>> getDefinitionEntityById(Integer classificationId);
}
