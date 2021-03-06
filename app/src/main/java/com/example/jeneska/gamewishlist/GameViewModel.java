package com.example.jeneska.gamewishlist;

import android.app.AlertDialog;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.DialogInterface;
import android.widget.Toast;

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

    //added
    public void delete(Game game) {mRepository.delete(game);}

}
