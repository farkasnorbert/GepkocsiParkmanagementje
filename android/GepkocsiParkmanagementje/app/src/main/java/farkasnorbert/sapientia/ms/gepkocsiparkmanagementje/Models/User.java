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

    public int getIdFelhasznalok() {
        return idFelhasznalok;
    }

    public String getNev() {
        return Nev;
    }

    public String getEmail() {
        return email;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setIdFelhasznalok(int idFelhasznalok) {
        this.idFelhasznalok = idFelhasznalok;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
}
