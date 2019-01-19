package com.example.jeneska.gamewishlist;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerSelect implements AdapterView.OnItemSelectedListener {
    String item;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        item = parent.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
