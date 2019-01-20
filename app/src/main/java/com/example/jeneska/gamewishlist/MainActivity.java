package com.example.jeneska.gamewishlist;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GameAdapter.OnGameItemClickListener {

    private GameViewModel mGameViewModel;
    public static final int NEW_GAME_ACTIVITY_REQUEST_CODE = 1;
    private GameAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setting up recyclerview
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        adapter = new GameAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Get a viewmodel from the viewmodelprovider
        mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        //Adding observer on LiveData to return games by platform
        //OnChanged goes when the Observer sees data changes

        mGameViewModel.getAllGames().observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(@Nullable List<Game> games) {
                adapter.setGames(games);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddGameActivity.class);
                startActivityForResult(intent, NEW_GAME_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onGameItemClick(final int position) {

        final Game game = adapter.getGameAtPosition(position);

        new AlertDialog.Builder(MainActivity.this).setTitle("Select Options").setItems(
                new String[]{"Delete", "Update"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i) {

                            //delete game
                            case 0:
                                mGameViewModel.delete(game);
                                break;

                        }
                    }
                }).show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_GAME_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            //Bundle extras = getIntent().getExtras();
            Game game = new Game(data.getStringExtra("title"), data.getStringExtra("platform"), data.getStringExtra("genre"), data.getStringExtra("cost"), data.getStringExtra("interest"), data.getStringExtra("release"));

            mGameViewModel.insert(game);
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.empty, Toast.LENGTH_LONG).show();
        }
    }

}




