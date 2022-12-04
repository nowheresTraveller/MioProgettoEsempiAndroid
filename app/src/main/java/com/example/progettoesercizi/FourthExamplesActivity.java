package com.example.progettoesercizi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.progettoesercizi.classes.Auto;
import com.example.progettoesercizi.classes.MyAdapter;

import java.util.ArrayList;

public class FourthExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_examples);
        ListView sampleListView = findViewById(R.id.sampleListView);
        ArrayList<Auto> automobili = new ArrayList<>();
        automobili.add(new Auto("Fiat", "Punto"));
        automobili.add(new Auto("Opel", "Corsa"));
        automobili.add(new Auto("Renault", "Clio"));
        automobili.add(new Auto("Pegeout", "106"));
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), R.layout.row_of_samplelistview, automobili);
        sampleListView.setAdapter(myAdapter);
    }
}