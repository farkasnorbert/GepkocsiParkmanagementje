package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models;

import java.util.Date;

public class Car {
    private int idAuto;
    private String Nev;
    private Date muszaki_lejarat;
    private Date kotelezo_biztositas_lejarat;
    private int kmOra;
    private int Auto_felelos;

    public Car(int idAuto, String nev, Date muszaki_lejarat, Date kotelezo_biztositas_lejarat, int kmOra, int auto_felelos) {
        this.idAuto = idAuto;
        Nev = nev;
        this.muszaki_lejarat = muszaki_lejarat;
        this.kotelezo_biztositas_lejarat = kotelezo_biztositas_lejarat;
        this.kmOra = kmOra;
        Auto_felelos = auto_felelos;
    }

    public int getAuto_felelos() {
        return Auto_felelos;
    }

    public Date getMuszaki_lejarat() {
        return muszaki_lejarat;
    }

    public Date getKotelezo_biztositas_lejarat() {
        return kotelezo_biztositas_lejarat;
    }

    public int getKmOra() {
        return kmOra;
    }

    public void setMuszaki_lejarat(Date muszaki_lejarat) {
        this.muszaki_lejarat = muszaki_lejarat;
    }

    public void setKotelezo_biztositas_lejarat(Date kotelezo_biztositas_lejarat) {
        this.kotelezo_biztositas_lejarat = kotelezo_biztositas_lejarat;
    }

    public void setKmOra(int kmOra) {
        this.kmOra = kmOra;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Nev='" + Nev + '\'' +
                '}';
    }
}
