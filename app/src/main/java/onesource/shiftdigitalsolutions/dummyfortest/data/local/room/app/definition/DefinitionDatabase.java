package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.definition;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.DefinitionEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.converter.DBConverter;

@Database(entities = DefinitionEntity.class, version = 1)
@TypeConverters({DBConverter.class})
public abstract class DefinitionDatabase extends RoomDatabase {
    private static DefinitionDatabase INSTANCE;

    public abstract DefinitionDao definitionDao();

    public static synchronized DefinitionDatabase getINSTANCE(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room
                    .databaseBuilder(context, DefinitionDatabase.class, "DefinitionDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        return INSTANCE;
    }
}
