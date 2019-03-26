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
}
