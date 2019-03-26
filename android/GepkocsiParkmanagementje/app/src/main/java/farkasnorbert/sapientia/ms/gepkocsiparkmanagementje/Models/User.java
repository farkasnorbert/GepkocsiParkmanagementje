package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models;

public class User {
    private int idFelhasznalok;
    private String Nev;
    private String email;
    private String jelszo;

    public User(int idFelhasznalok, String nev, String email, String jelszo) {
        this.idFelhasznalok = idFelhasznalok;
        this.Nev = nev;
        this.email = email;
        this.jelszo = jelszo;
    }

    public void Deletep(){
        this.jelszo="";
    }
}
