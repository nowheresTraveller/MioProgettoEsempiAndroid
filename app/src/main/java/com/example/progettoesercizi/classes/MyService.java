package com.example.progettoesercizi.classes;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }


    @Override
    public void onCreate() {
        Log.d(" - servizio creato","ok");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(" - servizio invocato", "ok");

        Toast t1= Toast.makeText(getApplicationContext(),"Donwload startato", Toast.LENGTH_SHORT);
        t1.show();
        //termina il servizio
        stopSelf();

        Toast t2= Toast.makeText(getApplicationContext(),"Donwload terminato", Toast.LENGTH_SHORT);
        t2.show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(" - servizio terminato","ok");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}