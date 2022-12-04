package com.example.progettoesercizi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import com.example.progettoesercizi.classes.Auto;
import com.example.progettoesercizi.classes.MyAdapter;

public class SecondExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_examples);
    }

    @Override
    protected void onResume() {
        //Implementazione gridView
        GridView gridView = findViewById(R.id.myGridView);
        ArrayList<Auto> automobili = new ArrayList<>();
        automobili.add(new Auto("Fiat","Punto"));
        automobili.add(new Auto("Opel","Corsa"));
        automobili.add(new Auto("Renault","Clio"));
        automobili.add(new Auto("Pegeout","106"));
        automobili.add(new Auto("Mercedes","classe-a"));
        automobili.add(new Auto("Bmw","serie 1"));
        MyAdapter myAdapter= new MyAdapter(getApplicationContext(),R.layout.row_of_samplegridview,automobili);
        gridView.setAdapter(myAdapter);

        super.onResume();
    }
}