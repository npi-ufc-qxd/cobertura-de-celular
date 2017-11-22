package npi.ufc.com.coberturacelular.presenter;

import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;

/**
 * Created by Júlio Martins on 22/11/17.
 */

public class ColetaDadosMoveis implements InterfaceColetaDadosMoveis.coletaDadosPresenter{
    InterfaceColetaDadosMoveis.coletaDadosView interfaceView;


    public ColetaDadosMoveis(InterfaceColetaDadosMoveis.coletaDadosView view){
        interfaceView = view;
    }

    public ColetaDadosMoveis(){}

    @Override
    public void setCodigoOperadora(String codigoOperadora) {
            interfaceView.setarCodigoOperadora(codigoOperadora);
    }

    @Override
    public void setLocalizacaoGeografica(LocalizacaoGeografica localizacaoGeografica) {
            interfaceView.setarLocalizaoGeografica(localizacaoGeografica);
    }

    @Override
    public void setTipoServicoRede(int tipoServicoRede) {
            interfaceView.setarServiceRede(tipoServicoRede);
    }

    @Override
    public void mensagemErro(String msg) {
            interfaceView.mensagemErro(msg);
    }

}
