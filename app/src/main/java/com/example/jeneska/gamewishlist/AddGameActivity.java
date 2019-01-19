package com.example.jeneska.gamewishlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddGameActivity extends AppCompatActivity {

    private EditText mEditGameView, mEditTextRelease;
    private Spinner spinnerPlatform, spinnerGenre, spinnerCost, spinnerInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);
        mEditGameView = findViewById(R.id.editTextTitle);
        mEditTextRelease = findViewById(R.id.editTextReleaseDate);

        //Spinners

        //Platform
        spinnerPlatform = findViewById(R.id.spinnerPlatform);
        spinnerPlatform.setOnItemSelectedListener(new SpinnerSelect());
        ArrayAdapter<CharSequence> adapterPlatform = ArrayAdapter.createFromResource(this, R.array.platform_array, android.R.layout.simple_spinner_item);
        adapterPlatform.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlatform.setAdapter(adapterPlatform);

        //Genre
        spinnerGenre = findViewById(R.id.spinnerGenre);
        spinnerGenre.setOnItemSelectedListener(new SpinnerSelect());
        ArrayAdapter<CharSequence> adapterGenre = ArrayAdapter.createFromResource(this, R.array.genre_array, android.R.layout.simple_spinner_item);
        adapterGenre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenre.setAdapter(adapterGenre);

        //Cost
        spinnerCost = findViewById(R.id.spinnerCost);
        spinnerCost.setOnItemSelectedListener(new SpinnerSelect());
        ArrayAdapter<CharSequence> adapterCost = ArrayAdapter.createFromResource(this, R.array.cost_array, android.R.layout.simple_spinner_item);
        adapterCost.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCost.setAdapter(adapterCost);

        //Interest
        spinnerInterest = findViewById(R.id.spinnerInterest);
        spinnerInterest.setOnItemSelectedListener(new SpinnerSelect());
        ArrayAdapter<CharSequence> adapterInterest = ArrayAdapter.createFromResource(this, R.array.interest_array, android.R.layout.simple_spinner_item);
        adapterInterest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterest.setAdapter(adapterInterest);

        final Button button = findViewById(R.id.btn_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditGameView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String sTitle = mEditGameView.getText().toString().trim();
                    String sRelease = mEditTextRelease.getText().toString().trim();
                    String sPlatform = spinnerPlatform.getSelectedItem().toString();
                    String sGenre = spinnerGenre.getSelectedItem().toString();
                    String sCost = spinnerCost.getSelectedItem().toString();
                    String sInterest = spinnerInterest.getSelectedItem().toString();

                    replyIntent.putExtra("title", sTitle);
                    replyIntent.putExtra("release", sRelease);
                    replyIntent.putExtra("platform", sPlatform);
                    replyIntent.putExtra("genre", sGenre);
                    replyIntent.putExtra("cost", sCost);
                    replyIntent.putExtra("interest", sInterest);

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
