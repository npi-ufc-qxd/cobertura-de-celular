package npi.ufc.com.coberturacelular.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import npi.ufc.com.coberturacelular.model.DadosMoveis;
import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;
import npi.ufc.com.coberturacelular.presenter.ColetaDadosMoveis;
import npi.ufc.com.coberturacelular.presenter.InterfaceColetaDadosMoveis;

/**
 * Created by Júlio Martins on 13/11/17.
 */

public class ColetaDadosService extends IntentService{
    InterfaceColetaDadosMoveis.coletaDadosPresenter interfaceColeta;
    DadosMoveis dadosMoveis;
    RequisicaoDadosService requisicaoServidor;


    /**
     *
     *
     * @paramname Usado para nomear a thread em execução,
     * importante somente para debug.
     */
    public ColetaDadosService() {
        super("ColetaDadosService");
        interfaceColeta = new ColetaDadosMoveis();

    }

        private Context context;


    /**
     *
     *
     * Coleta os dados de localização geográfica, código da operado e o tipo de Rede e
     * envio para o servidor rest temporário para fins de teste
     *
     */
    @Override
    protected void onHandleIntent(final Intent intent) {

        new Thread(){
            private Context context;
            public void run(){


                try{



                    TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                    String codigoOperadora = manager.getNetworkOperator();
                    String codigoProvedorSim = manager.getSimOperator();

                    Location location = new Location("Localizacao");

                    LocalizacaoGeografica localizacaoGeografica = new LocalizacaoGeografica();
                    localizacaoGeografica.setLatitude(location.getLatitude());
                    localizacaoGeografica.setLongitude(location.getLongitude());
                    localizacaoGeografica.setAltitude(location.getAltitude());

                    float precisaoEmMetros = localizacaoGeografica.getPrecisaoEmMetros();

                    manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);

                    int tipoDeRede = manager.getNetworkType();
                    dadosMoveis = new DadosMoveis();
                    dadosMoveis.setCodigoNumericoOperadora(codigoOperadora);
                    dadosMoveis.setLocalizacao(localizacaoGeografica);
                    dadosMoveis.setRaioErroEstimativa(precisaoEmMetros);
                    dadosMoveis.setStatusTransmissao(true); // dado ficticio
                    dadosMoveis.setLatencia(12); // dado ficticio

                    requisicaoServidor = new RequisicaoDadosService();
                    requisicaoServidor.requisicaoPostServidor(dadosMoveis);


                }

                catch (NullPointerException e){
                    interfaceColeta.mensagemErro("Erro na comunicação com o servidor");
                }



            }




        }.start();

    }
}
