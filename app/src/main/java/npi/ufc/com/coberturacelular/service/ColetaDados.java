package npi.ufc.com.coberturacelular.service;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;

import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;
import npi.ufc.com.coberturacelular.presenter.InterfaceColetaDadosMoveis;

/**
 * Created by 06129767340 on 07/11/17.
 */

public class ColetaDados {

    private Context context;


    public int getTipoServicoRede() {
        TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        int tipoDeRede = manager.getNetworkType();
        return tipoDeRede;

    }


}
