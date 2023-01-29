package com.example.progettoesercizi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.progettoesercizi.classes.MyService;

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
        setListenerOnFifthButton();
        setListenerOnSeventhButton();
        setListenerOnSwitch();
        setListenerOnToggle();
        setListenerOnNotificationButton();


        //spinner
        configuraMySpinner();
        setListenerOnMySpinner();

        // metodo che assegna differenta listener al bottone 'fifthButton'
        setDifferentListenersOnFifthButton();

        setDifferentListenersOnFirstEditText();

        //assegna un "context menu" ad una view dell'activity
        registerForContextMenu(findViewById(R.id.contextMenuButton));

        super.onResume();
    }

    public void startService(View view){

        Intent i= new Intent(getApplicationContext(), MyService.class);
        startService(i);

        //Stoppare il servizio fuori la classe "Myservice"
        //stopService(i);
    }


    public void setListenerOnNotificationButton() {
        Button notificationButton = findViewById(R.id.notificationButton);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAndExecuteNotifica1();
            }
        });

    }



    // Implementa e manda in esecuzione una notifica
    public void createAndExecuteNotifica1(){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:paolo.rossi@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Invito al meeting del 12/11/2022");
        intent.putExtra(Intent.EXTRA_TEXT, "Salve sig. Rossi, è invitato al meeting in data 12/11/2022 nella nostra sede a via Roma 22");


        // PendingIntent = intent presente in una notifica
        // implemento un PendingIntent
        //questo verrà poi aggiunto a notifica1 attraverso il metodo "addAction()"
        PendingIntent pIntent= PendingIntent.getActivity
                (getApplicationContext(),
                        1,
                        intent,
                        0);

        //creo la notifica
        NotificationCompat.Builder notifica1 = new NotificationCompat.Builder(getApplicationContext(), "mio_canale")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_text))
                .addAction(R.drawable.ic_launcher_background,"rispondi alla mail",pIntent);

        // L'"if" verifica se la versione dell'app è >= ad android "oreo"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "canale_1",
                    "canale_notifica_generale",
                    NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription("Questo è il canale per le notifiche di carattere generale");

            NotificationManager nManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
            nManager.createNotificationChannel(channel);

            //setto il canale appena creato alla notifica "sopra l'if"
            notifica1.setChannelId(channel.getId());
        }

        // mando in esecuzione la notifica
        NotificationManagerCompat nMCompat = NotificationManagerCompat.from(getApplicationContext());
        nMCompat.notify(1, notifica1.build());
    }


    // assegna il mio "context menu"(layout) all'oggetto parametro "ContextMenu"
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context, menu);
    }


    // gestisce gli eventi sugli item del "context menu"
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.callElement:
                Log.d(" - click su 'chiama'", " ok");
                return true;

            case R.id.sendMailElement:
                Log.d(" - click su 'invia e-mail'", " ok");
                return true;

            case R.id.goToInstagramElement:
                Log.d("- click su 'vai su instagram'", " ok");
                return true;
        }

        return false;
    }

    public void radioButtonSelected(View view) {
        boolean ifChecked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.maleRadioButton:
                Log.d(" - Radio button ", "maschio è settato a " + ifChecked);
                break;
            case R.id.femaleRadioButton:
                Log.d(" - Radio button", "femmina è settato a " + ifChecked);
        }
    }


    public void checkOnCheckBox(View view) {
        boolean ifChecked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.firstCheckBox:
                Log.d(" - La checkBox 'macchina'", "è settata a " + ifChecked);
                break;

            case R.id.secondCheckBox:
                Log.d(" - La checkBox 'moto'", "è settata a " + ifChecked);
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

    public void setListenenerOnFourthButton() {
        Button fourthButton = findViewById(R.id.fourthButton);
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FourthExamplesActivity.class);
                startActivity(i);
            }
        });
    }

    public void setListenerOnSwitch() {
        Switch mySwitch = findViewById(R.id.mySwitch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d(" - 'switch' ", "L'utente vuole ricevere e-mail!");
                } else {
                    Log.d(" - 'switch' ", "L'utente non vuole ricevere e-mail!");
                }
            }
        });
    }

    public void setListenerOnToggle() {
        ToggleButton toggleButton = findViewById(R.id.myToggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d(" - 'toggle' ", "ON");
                } else {
                    Log.d(" - 'toggle' ", "OFF");
                }

            }
        });
    }


    public void configuraMySpinner() {
        Spinner mySpinner = findViewById(R.id.mySpinner);
        // 'android.R.layout.simple_spinner_item' = layout del singolo elemento dello spinner
        ArrayAdapter<CharSequence> arrAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.citta, android.R.layout.simple_spinner_item);
        // 'android.R.layout.simple_spinner_dropdown_item' = layout dell'intero spinner
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(arrAdapter);
    }

    public void setListenerOnMySpinner() {
        Spinner mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // 'onItemSelected(.....)' viene attivato quando viene cliccato un elemento
            //dello spinner
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(" - elemento selezionato di 'mySpinner' ", "'" + mySpinner.getItemAtPosition(position) + "'");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setDifferentListenersOnFifthButton() {
        Button fifthButton = (Button) findViewById(R.id.fifthButton);

        // Assegno a 'fifthButton' un listener che gestisce il semplice click sulla view
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent (getApplicationContext(),FifthExamplesActivity.class);
                startActivity(i);
            }
        });

    }

    public void setDifferentListenersOnFirstEditText() {

        EditText firstEditText = (EditText) findViewById(R.id.firstEditText);

        // Assegno a 'firstEditText' un listener che gestisce il semplice click sulla view
        firstEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(" - evento ", " hai effettuato il semplice click sull' editText '" + v.getResources().getResourceEntryName(v.getId()) + "'");
            }
        });

        // Assegno a 'firstEditText' un listener che gestisce l'evento 'onLongClick'
        // (l'utente tiene premuta la view)
        firstEditText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d(" - evento ", " hai effettuato un click che dura più di un secondo sull'editText '" + v.getResources().getResourceEntryName(v.getId()) + "'");
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

    public void setListenerOnFifthButton() {
        Button sixthButton = (Button) findViewById(R.id.sixthButton);

        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FifthExamplesActivity.class));
            }
        });
    }


    public void setListenerOnSeventhButton() {
        Button seventhButton = (Button) findViewById(R.id.seventhButton);
        seventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SeventhExamplesActivity.class));
            }
        });
    }


    // creazione "popup menu" sul bottone
    public void startPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup, popupMenu.getMenu());
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.firstItem:
                        Log.d(" - Item_1 del popup menu", " cliccato");
                        break;
                    case R.id.secondItem:
                        Log.d(" - Item_2 del popup menu", " cliccato");
                        break;
                }
                return false;
            }
        });
    }


    public void toNavigationDrawer(View v) {
        Intent i = new Intent(getApplicationContext(), NavDrawerActivity.class);
        startActivity(i);
    }

}