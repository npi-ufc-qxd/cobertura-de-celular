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
        void setTipoServicoRede(int tipoServicoRede);
        void mensagemErro(String msg);

    }

    interface coletaDadosView{
        String sucessoTransmissao();
        void setarCodigoOperadora(String codigoOperadora);
        void setarLocalizaoGeografica(LocalizacaoGeografica localizacaoGeografica);
        void setarServiceRede(int tipoServicoRede);
        void mensagemErro(String msg);
    }

}
