package npi.ufc.com.coberturacelular.model;

/**
 * Created by 06129767340 on 06/11/17.
 */

public class DadosMoveis {
    private String codigoNumericoOperadora;
    private LocalizacaoGeografica localizacao;
    private String tipoDeRede;
    private boolean statusTransmissao;
    private int latencia;
    private float raioErroEstimativa;

    public float getRaioErroEstimativa() {
        return raioErroEstimativa;
    }

    public void setRaioErroEstimativa(float raioErroEstimativa) {
        this.raioErroEstimativa = raioErroEstimativa;
    }

    public String getCodigoNumericoOperadora() {
        return codigoNumericoOperadora;
    }

    public void setCodigoNumericoOperadora(String codigoNumericoOperadora) {
        this.codigoNumericoOperadora = codigoNumericoOperadora;
    }

    public LocalizacaoGeografica getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoGeografica localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoDeRede() {
        return tipoDeRede;
    }

    public void setTipoDeRede(String tipoDeRede) {
        this.tipoDeRede = tipoDeRede;
    }

    public boolean isStatusTransmissao() {
        return statusTransmissao;
    }

    public void setStatusTransmissao(boolean statusTransmissao) {
        this.statusTransmissao = statusTransmissao;
    }

    public int getLatencia() {
        return latencia;
    }

    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }
}
