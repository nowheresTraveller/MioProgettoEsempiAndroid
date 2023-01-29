package com.example.progettoesercizi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SeventhExamplesActivity extends AppCompatActivity {

    LinearLayout linLayoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_examples);
        linLayoutRoot = (LinearLayout) findViewById(R.id.linearLayoutRoot);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void stampa(View v){
        Log.d(" - stampa ", "ok");
    }



    public void addElement (View v){
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View newLayoutView = inflater.inflate(R.layout.my_row_layout, null);
        linLayoutRoot.addView(newLayoutView);

        /*
        LinearLayout newLinLay= new LinearLayout(this);
        newLinLay.setOrientation(LinearLayout.HORIZONTAL);
        newLinLay.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
         */

    }

    //TODO provare un altra strada per "addElement"
    public void addElement2 (View v){
        }



    public void removeElement(){

    }

}