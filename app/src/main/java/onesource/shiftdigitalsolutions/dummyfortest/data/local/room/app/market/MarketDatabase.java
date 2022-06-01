package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.market;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.MarketsEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.converter.DBConverter;


@Database(entities = MarketsEntity.class, version = 1)
@TypeConverters({DBConverter.class})
public abstract class MarketDatabase extends RoomDatabase {
    private static MarketDatabase INSTANCE;

    public abstract MarketDao marketDao();

    public static synchronized MarketDatabase getINSTANCE(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room
                    .databaseBuilder(context, MarketDatabase.class, "MarketDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        return INSTANCE;
    }
}
