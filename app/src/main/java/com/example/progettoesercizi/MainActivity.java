package com.example.progettoesercizi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {

        setListenenerOnFirstButton();
        setListenerOnSecondButton();
        setListenenerOnFourthButton();
        setListenerOnSixthButton();
        setListenerOnSwitch();
        setListenerOnToggle();

        //spinner
        configuraMySpinner();
        setListenerOnMySpinner();

        // metodo che assegna differenta listener al bottone 'fifthButton'
        setDifferentListenersOnFifthButton ();

        setDifferentListenersOnFirstEditText();

        super.onResume();
    }


    public void radioButtonSelected(View view){
        boolean ifChecked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.maleRadioButton:
                Log.d(" - Radio button ","maschio è settato a "+ifChecked);
                break;
            case R.id.femaleRadioButton:
                Log.d(" - Radio button","femmina è settato a "+ifChecked);
        }
    }


    public void checkOnCheckBox(View view) {
        boolean ifChecked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.firstCheckBox:
                Log.d(" - La checkBox 'macchina'","è settata a "+ifChecked);
                break;

            case R.id.secondCheckBox:
                Log.d(" - La checkBox 'moto'","è settata a "+ifChecked);
                break;
        }
    }

    public void printALog(View view) {

        Log.d(" - click su thirdButton", "Ho eseguito il metodo 'printALog'");
    }

    public void setListenenerOnFirstButton() {

        Button firstButton = findViewById(R.id.firstButton);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondExamplesActivity.class);
                startActivity(i);
            }
        });
    }

    public void setListenerOnSecondButton() {

        Button secondButton = findViewById(R.id.secondButton);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ThirdExamplesActivity.class);
                startActivity(i);
            }
        });
    }

    public void setListenenerOnFourthButton(){
        Button fourthButton = findViewById(R.id.fourthButton);
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FourthExamplesActivity.class);
                startActivity(i);
            }
        });
    }

    public void setListenerOnSwitch(){
        Switch mySwitch = findViewById(R.id.mySwitch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Log.d(" - 'switch' ","L'utente vuole ricevere e-mail!");
                }else{
                    Log.d(" - 'switch' ","L'utente non vuole ricevere e-mail!");
                }
            }});
    }

    public void setListenerOnToggle(){
        ToggleButton toggleButton= findViewById(R.id.myToggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Log.d(" - 'toggle' ","ON");
                }else{
                    Log.d(" - 'toggle' ","OFF");
                }

            }
        });
    }


    public void configuraMySpinner(){
        Spinner mySpinner = findViewById(R.id.mySpinner);
        // 'android.R.layout.simple_spinner_item' = layout del singolo elemento dello spinner
        ArrayAdapter <CharSequence> arrAdapter= ArrayAdapter.createFromResource(getApplicationContext(),R.array.citta,android.R.layout.simple_spinner_item);
        // 'android.R.layout.simple_spinner_dropdown_item' = layout dell'intero spinner
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(arrAdapter);
    }

    public void setListenerOnMySpinner(){
        Spinner mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // 'onItemSelected(.....)' viene attivato quando viene cliccato un elemento
            //dello spinner
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(" - elemento selezionato di 'mySpinner' ","'"+mySpinner.getItemAtPosition(position)+"'");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setDifferentListenersOnFifthButton (){
        Button fifthButton= (Button) findViewById(R.id.fifthButton);

        // Assegno a 'fifthButton' un listener che gestisce il semplice click sulla view
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(" - evento "," hai effettuato il semplice click sul bottone '"+v.getResources().getResourceEntryName(v.getId())+"'");
            }
        });

        // Assegno a 'fifthButton' un listener che gestisce l'evento 'onLongClick'
        // (l'utente tiene premuta la view)
        fifthButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d(" - evento "," hai effettuato un click che dura più di un secondo sul bottone '"+v.getResources().getResourceEntryName(v.getId())+"'");
                return true;
            }
        });

        /*
        // Assegno a 'fifthButton' un listener che gestisce 'il touch' sulla view
        fifthButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(" - evento "," hai effettuato il touch sul bottone "+v.getResources().getResourceEntryName(v.getId())+"'");
                return true;
            }
        });
        */

    }

    public void setDifferentListenersOnFirstEditText(){

        EditText firstEditText = (EditText) findViewById(R.id.firstEditText);

        // Assegno a 'firstEditText' un listener che gestisce il semplice click sulla view
        firstEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(" - evento "," hai effettuato il semplice click sull' editText '"+v.getResources().getResourceEntryName(v.getId())+"'");
            }
        });

        // Assegno a 'firstEditText' un listener che gestisce l'evento 'onLongClick'
        // (l'utente tiene premuta la view)
        firstEditText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d(" - evento "," hai effettuato un click che dura più di un secondo sull'editText '"+v.getResources().getResourceEntryName(v.getId())+"'");
                return true;
            }
        });

        /*
        // Assegno a 'firstEditText' un listener che gestisce 'il touch' sulla view
        firstEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(" - evento "," hai effettuato il touch sull'editText '"+v.getResources().getResourceEntryName(v.getId())+"'");
                return true;
            }
        });
        */
    }


    public void setListenerOnSixthButton(){
        Button sixthButton= (Button) findViewById(R.id.sixthButton);

        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FifthExamplesActivity.class));
            }
        });
    }

}