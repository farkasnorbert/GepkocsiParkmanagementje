package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models;

import java.util.Date;

public class Travel {
    private int idUtazas;
    private int Sofor;
    private Date indulas;
    private Date haza_erkezes;
    private String Celalomas;
    private int Utasok_szama;
    private String Utazas_celja;
    private int Alapot;
    private int Auto;
    private int Igenylo;

    public Travel(int idUtazas, int sofor, Date indulas, Date haza_erkezes, String celalomas, int utasok_szama, String utazas_celja, int alapot, int auto, int igenylo) {
        this.idUtazas = idUtazas;
        Sofor = sofor;
        this.indulas = indulas;
        this.haza_erkezes = haza_erkezes;
        Celalomas = celalomas;
        Utasok_szama = utasok_szama;
        Utazas_celja = utazas_celja;
        Alapot = alapot;
        Auto = auto;
        Igenylo = igenylo;
    }

    public int getIdUtazas() {
        return idUtazas;
    }

    public int getSofor() {
        return Sofor;
    }

    public Date getIndulas() {
        return indulas;
    }

    public Date getHaza_erkezes() {
        return haza_erkezes;
    }

    public String getCelalomas() {
        return Celalomas;
    }

    public int getUtasok_szama() {
        return Utasok_szama;
    }

    public String getUtazas_celja() {
        return Utazas_celja;
    }

    public int getAlapot() {
        return Alapot;
    }

    public int getAuto() {
        return Auto;
    }

    public int getIgenylo() {
        return Igenylo;
    }

    public void setIdUtazas(int idUtazas) {
        this.idUtazas = idUtazas;
    }

    public void setSofor(int sofor) {
        Sofor = sofor;
    }

    public void setIndulas(Date indulas) {
        this.indulas = indulas;
    }

    public void setHaza_erkezes(Date haza_erkezes) {
        this.haza_erkezes = haza_erkezes;
    }

    public void setCelalomas(String celalomas) {
        Celalomas = celalomas;
    }

    public void setUtasok_szama(int utasok_szama) {
        Utasok_szama = utasok_szama;
    }

    public void setUtazas_celja(String utazas_celja) {
        Utazas_celja = utazas_celja;
    }

    public void setAlapot(int alapot) {
        Alapot = alapot;
    }

    public void setAuto(int auto) {
        Auto = auto;
    }

    public void setIgenylo(int igenylo) {
        Igenylo = igenylo;
    }

    public Travel() {
    }

    @Override
    public String toString() {
        return "Travel{" +
                "idUtazas=" + idUtazas +
                ", Sofor=" + Sofor +
                ", indulas=" + indulas +
                ", haza_erkezes=" + haza_erkezes +
                ", Celalomas='" + Celalomas + '\'' +
                ", Utasok_szama=" + Utasok_szama +
                ", Utazas_celja='" + Utazas_celja + '\'' +
                ", Alapot=" + Alapot +
                ", Auto=" + Auto +
                ", Igenylo=" + Igenylo +
                '}';
    }
}
