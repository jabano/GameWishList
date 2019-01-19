package com.example.jeneska.gamewishlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Game.class}, version = 1)
public abstract class GameDatabase extends RoomDatabase {
    public abstract GameDao gameDao();
    private static volatile GameDatabase mGameDb;

    static GameDatabase getGameDb(final Context context) {
        if (mGameDb == null) {
            synchronized (GameDatabase.class) {
                if(mGameDb == null) {
                    mGameDb = buildDbInstance(context);
                }
            }
        }
        return mGameDb;
    }

    private static GameDatabase buildDbInstance(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), GameDatabase.class, "gameDb").build();
    }

    public void cleanUp() {
        mGameDb = null;
    }

}