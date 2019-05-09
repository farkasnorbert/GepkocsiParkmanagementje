package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models;

public class Traveler {
    private int idUtazo;
    private int Nev;
    private String Utazo_tipus;
    private int Utazas_id;

    public Traveler(int idUtazo, int nev, String utazo_tipus, int utazas_id) {
        this.idUtazo = idUtazo;
        Nev = nev;
        Utazo_tipus = utazo_tipus;
        Utazas_id = utazas_id;
    }

    public Traveler(int nev, String utazo_tipus, int utazas_id) {
        Nev = nev;
        Utazo_tipus = utazo_tipus;
        Utazas_id = utazas_id;
    }

    public int getIdUtazo() {
        return idUtazo;
    }

    public int getNev() {
        return Nev;
    }

    public String getUtazo_tipus() {
        return Utazo_tipus;
    }

    public int getUtazas_id() {
        return Utazas_id;
    }

    public void setIdUtazo(int idUtazo) {
        this.idUtazo = idUtazo;
    }

    public void setNev(int nev) {
        Nev = nev;
    }

    public void setUtazo_tipus(String utazo_tipus) {
        Utazo_tipus = utazo_tipus;
    }

    public void setUtazas_id(int utazas_id) {
        Utazas_id = utazas_id;
    }
}
