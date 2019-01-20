package com.example.jeneska.gamewishlist;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class GameRepository {

    private GameDao mGameDao;
    private LiveData<List<Game>> mAllGames;

    GameRepository(Application application) {
        GameDatabase db = GameDatabase.getGameDb(application);
        mGameDao = db.gameDao();
        mAllGames = mGameDao.getAllGames();
    }

    LiveData<List<Game>> getAllGames() {
        return mAllGames;
    }

    public void insert (Game game) {
        new insertAsyncTask(mGameDao).execute(game);
    }

    //added
    public void delete (Game game) { new deleteAsyncTask(mGameDao).execute(game);}

    private static class insertAsyncTask extends AsyncTask<Game, Void, Void> {
        private GameDao mAsyncTaskDao;

        insertAsyncTask(GameDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Game... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    //added

    private static class deleteAsyncTask extends AsyncTask<Game, Void, Void> {
        private GameDao mAsyncTaskDao;

        deleteAsyncTask(GameDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Game... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}
