package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.classification;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.ClassificationEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.converter.DBConverter;

@Database(entities = ClassificationEntity.class, version = 1)
@TypeConverters({DBConverter.class})
public abstract class ClassificationDatabase extends RoomDatabase {
    private static ClassificationDatabase INSTANCE;

    public abstract ClassificationDao classificationDao();

    public static synchronized ClassificationDatabase getINSTANCE(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room
                    .databaseBuilder(context, ClassificationDatabase.class, "ClassificationDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        return INSTANCE;
    }
}
