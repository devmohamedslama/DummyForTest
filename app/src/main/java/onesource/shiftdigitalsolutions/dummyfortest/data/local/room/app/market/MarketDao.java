package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.market;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.MarketsEntity;

@Dao
public interface MarketDao {
    @Insert
    Single<Long> insertMarketsEntity(MarketsEntity marketsEntity);

    @Query("SELECT * FROM MarketsEntity")
    Single<List<MarketsEntity>> getAllMarketsEntity();
}
