package onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.category;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.CategoryEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.converter.DBConverter;

@Database(entities = CategoryEntity.class, version = 1)
@TypeConverters({DBConverter.class})
public abstract class CategoryDatabase extends RoomDatabase {
    private static CategoryDatabase INSTANCE;

    public abstract CategoryDao categoryDao();

    public static synchronized CategoryDatabase getINSTANCE(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room
                    .databaseBuilder(context, CategoryDatabase.class, "CategoryDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        return INSTANCE;
    }
}
