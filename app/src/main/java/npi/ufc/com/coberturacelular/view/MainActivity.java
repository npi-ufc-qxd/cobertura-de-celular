package npi.ufc.com.coberturacelular.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import npi.ufc.com.coberturacelular.R;
import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;
import npi.ufc.com.coberturacelular.presenter.ColetaDadosMoveis;
import npi.ufc.com.coberturacelular.presenter.InterfaceColetaDadosMoveis;

public class MainActivity extends AppCompatActivity implements InterfaceColetaDadosMoveis.coletaDadosView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(MainActivity.this, ColetaDadosMoveis.class);
        startService(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public String sucessoTransmissao() {
        return null;
    }

    @Override
    public void setarCodigoOperadora(String codigoOperadora) {
        Toast.makeText(this, "CÓDIGO OPERADORA: " + codigoOperadora , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setarLocalizaoGeografica(LocalizacaoGeografica localizacaoGeografica) {
        Toast.makeText(this, "LOCALIZACAO: " + localizacaoGeografica.toString(), + Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setarServiceRede(int tipoServicoRede) {
        Toast.makeText(this, "TIPO SERVICE: " + tipoServicoRede, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void mensagemErro(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
