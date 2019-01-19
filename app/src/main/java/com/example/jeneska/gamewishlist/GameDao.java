package com.example.jeneska.gamewishlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GameDao {

    @Query("SELECT * FROM gameTable ORDER BY interest DESC")
    LiveData<List<Game>> getAllGames();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Game game);

    @Delete
    void delete(Game game);

    @Update
    void update(Game game);
}
