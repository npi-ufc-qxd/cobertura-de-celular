package npi.ufc.com.coberturacelular.model;

import android.location.Location;

/**
 * Created by 06129767340 on 06/11/17.
 */

public class LocalizacaoGeografica {
    private double latitude;
    private double longitude;
    private double altitude;
    private double raioDeErroMaximo;



    public float getPrecisaoEmMetros(){
        Location location = new Location("Localizacao");
        return location.getAccuracy();
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getRaioDeErroMaximo() {
        return raioDeErroMaximo;
    }

    public void setRaioDeErroMaximo(double raioDeErroMaximo) {
        this.raioDeErroMaximo = raioDeErroMaximo;
    }
}
