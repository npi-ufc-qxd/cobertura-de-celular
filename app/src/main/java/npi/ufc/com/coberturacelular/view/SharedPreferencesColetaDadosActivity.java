package npi.ufc.com.coberturacelular.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import npi.ufc.com.coberturacelular.R;
import npi.ufc.com.coberturacelular.service.ColetaDadosService;

public class SharedPreferencesColetaDadosActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_coleta_dados);

        final RadioButton um_minuto = (RadioButton)findViewById(R.id.radio_um_minuto);
        final RadioButton cinco_minutos = (RadioButton)findViewById(R.id.radio_cinco_minutos);
        final RadioButton trinta_minutos = (RadioButton)findViewById(R.id.radio_trinta_minutos);
        final RadioButton duas_horas = (RadioButton)findViewById(R.id.radio_duas_horas);
        final RadioButton seis_horas = (RadioButton)findViewById(R.id.radio_seis_horas);
        final RadioButton vinte_quatro_horas = (RadioButton)findViewById(R.id.radio_vinta_quatro_horas);

        SharedPreferences preferences = getSharedPreferences("preferencias",Context.MODE_PRIVATE);


        //Setando o período em que o serviço vai coletar os dados
        Context ctx = getApplicationContext();

        Calendar cal = Calendar.getInstance();
        AlarmManager am = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
        long interval = 1000 * 60 * preferences.getInt("tempo-coleta",0); // Tempo de atualização do serviço em ms
        Log.i("TAG", "MENSAGEM" + interval);
        Intent serviceIntent = new Intent(ctx, ColetaDadosService.class);

        PendingIntent servicePendingIntent =
                PendingIntent.getService(ctx,
                        ColetaDadosService.SERVICE_ID, // ID identifica o serviço
                        serviceIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT);
        am.setRepeating(
                AlarmManager.RTC_WAKEUP,
                cal.getTimeInMillis(),
                interval,
                servicePendingIntent
        );


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void radioCheckedSharedPreferences(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        SharedPreferences prefs = getSharedPreferences("preferencias",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();

        // Checa qual botão foi selecionado
        switch(view.getId()) {
            case R.id.radio_um_minuto:
                if (checked)
                    ed.putInt("tempo-coleta",1);
                    ed.apply();
                    break;

            case R.id.radio_cinco_minutos:
                if (checked)
                    ed.putInt("tempo-coleta",5);
                    ed.apply();
                    break;

            case R.id.radio_trinta_minutos:
                if (checked)
                    ed.putInt("tempo-coleta",30);
                    ed.apply();
                    break;

            case R.id.radio_duas_horas:
                if (checked)
                    ed.putInt("tempo-coleta",120);
                    ed.apply();
                    break;

            case R.id.radio_seis_horas:
                if (checked)
                    ed.putInt("tempo-coleta",360);
                    ed.apply();
                    break;

            case R.id.radio_vinte_quatro_horas:
                if (checked)
                    ed.putInt("tempo-coleta",1440);
                    ed.apply();
                    break;
        }

    }
}
