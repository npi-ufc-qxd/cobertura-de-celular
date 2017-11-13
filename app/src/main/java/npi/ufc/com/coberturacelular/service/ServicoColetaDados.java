package npi.ufc.com.coberturacelular.service;

import android.content.Context;
import android.location.Location;
import android.telephony.TelephonyManager;

import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;
import npi.ufc.com.coberturacelular.presenter.InterfaceColetaDadosMoveis;

/**
 * Created by 06129767340 on 07/11/17.
 */

public class ServicoColetaDados implements InterfaceColetaDadosMoveis.coletaDadosPresenter {
    private Context context;

    @Override
    public String getCodigoOperadora() {
        TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String codigoOperadora1 = manager.getNetworkOperator();
        String codigoProvedorSim = manager.getSimOperator();

        return codigoProvedorSim;
    }

    @Override
    public LocalizacaoGeografica getLocalizacaoGeografrica() {
        Location location = new Location("Localizacao");

        LocalizacaoGeografica localizacaoGeografica = new LocalizacaoGeografica();
        localizacaoGeografica.setLatitude(location.getLatitude());
        localizacaoGeografica.setLongitude(location.getLongitude());
        localizacaoGeografica.setAltitude(location.getAltitude());

        return localizacaoGeografica;


    }

    @Override
    public int getTipoServicoRede() {
        TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        int tipoDeRede = manager.getNetworkType();
        return tipoDeRede;

    }
}
