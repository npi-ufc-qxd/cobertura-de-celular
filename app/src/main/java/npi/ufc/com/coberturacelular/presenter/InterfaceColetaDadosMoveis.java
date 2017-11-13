package npi.ufc.com.coberturacelular.presenter;

import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;

/**
 * Created by 06129767340 on 06/11/17.
 */

public interface InterfaceColetaDadosMoveis {

    interface coletaDadosPresenter{
       /* String getCodigoOperadora();
        LocalizacaoGeografica getLocalizacaoGeografrica();
        int getTipoServicoRede();*/
        void setCodigoOperadora(String codigoOperadora);
        void setLocalizacaoGeografica(LocalizacaoGeografica localizacaoGeografica);
        void setTiposServicoRede(int tipoServicoRede);

    }

    interface coletaDadosView{
        String sucessoTransmissao();
        void setarDadosView();
    }

}
