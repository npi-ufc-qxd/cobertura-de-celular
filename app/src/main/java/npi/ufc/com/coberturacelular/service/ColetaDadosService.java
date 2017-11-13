package npi.ufc.com.coberturacelular.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;

import npi.ufc.com.coberturacelular.presenter.InterfaceColetaDadosMoveis;

/**
 * Created by 06129767340 on 13/11/17.
 */

public class ColetaDadosService extends IntentService{
    InterfaceColetaDadosMoveis.coletaDadosPresenter interfaceColeta;




    /**
     *
     *
     * @paramname Usado para nomear a thread em execução,
     * importante somente para debug.
     */
    public ColetaDadosService() {
        super("ColetaDadosService");
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
        new Thread(){
            private Context context;
            public void run(){

                TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                String codigoOperadora1 = manager.getNetworkOperator();
                String codigoProvedorSim = manager.getSimOperator();

                interfaceColeta.setCodigoOperadora();
                interfaceColeta.setLocalizacaoGeografica();

            }




        }.start();

    }
}
