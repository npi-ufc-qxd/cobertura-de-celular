package npi.ufc.com.coberturacelular.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;

import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;
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

        private Context context;


    /**
     *
     *
     * Coleta os dados de localização geográfica, código da operado e o tipo de Rede
     *
     */
    @Override
    protected void onHandleIntent(final Intent intent) {
        new Thread(){
            private Context context;
            public void run(){

                TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                String codigoOperadora = manager.getNetworkOperator();
                String codigoProvedorSim = manager.getSimOperator();

                Location location = new Location("Localizacao");

                LocalizacaoGeografica localizacaoGeografica = new LocalizacaoGeografica();
                localizacaoGeografica.setLatitude(location.getLatitude());
                localizacaoGeografica.setLongitude(location.getLongitude());
                localizacaoGeografica.setAltitude(location.getAltitude());

                manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                int tipoDeRede = manager.getNetworkType();

                interfaceColeta.setCodigoOperadora(codigoOperadora);
                interfaceColeta.setLocalizacaoGeografica(localizacaoGeografica);
                interfaceColeta.setTipoServicoRede(tipoDeRede);

            }




        }.start();

    }
}
