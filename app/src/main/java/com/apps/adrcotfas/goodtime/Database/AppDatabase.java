package com.apps.adrcotfas.goodtime.Database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = Session.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    private static final Object LOCK = new Object();
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE =  Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "Goodtime").build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract SessionDao sessionModel();
}