package com.example.jeneska.gamewishlist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class GameViewModel extends AndroidViewModel {

    private GameRepository mRepository;
    private LiveData<List<Game>> mAllGames;

    public GameViewModel(Application application) {
        super(application);
        mRepository = new GameRepository(application);
        mAllGames = mRepository.getAllGames();
    }

    LiveData<List<Game>> getAllGames() {return mAllGames;}

    public void insert(Game game) {mRepository.insert(game);}
}
