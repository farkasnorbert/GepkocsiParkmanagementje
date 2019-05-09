package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models;

public class User_type {
    private int Felhasznalo_id;
    private int Dekan_hivatal;
    private int Gazdasagi_igazgato;
    private int Garazs_felelos;
    private int Auto_felelos;
    private int Auto_igenylo;
    private int Vezeto;

    public User_type(int felhasznalo_id, int dekan_hivatal, int gazdasagi_igazgato, int garazs_felelos, int auto_felelos, int auto_igenylo, int vezeto) {
        Felhasznalo_id = felhasznalo_id;
        Dekan_hivatal = dekan_hivatal;
        Gazdasagi_igazgato = gazdasagi_igazgato;
        Garazs_felelos = garazs_felelos;
        Auto_felelos = auto_felelos;
        Auto_igenylo = auto_igenylo;
        Vezeto = vezeto;
    }

    public int getFelhasznalo_id() {
        return Felhasznalo_id;
    }

    public int getDekan_hivatal() {
        return Dekan_hivatal;
    }

    public int getGazdasagi_igazgato() {
        return Gazdasagi_igazgato;
    }

    public int getGarazs_felelos() {
        return Garazs_felelos;
    }

    public int getAuto_felelos() {
        return Auto_felelos;
    }

    public int getAuto_igenylo() {
        return Auto_igenylo;
    }

    public int getVezeto() {
        return Vezeto;
    }

    public void setFelhasznalo_id(int felhasznalo_id) {
        Felhasznalo_id = felhasznalo_id;
    }

    public void setDekan_hivatal(int dekan_hivatal) {
        Dekan_hivatal = dekan_hivatal;
    }

    public void setGazdasagi_igazgato(int gazdasagi_igazgato) {
        Gazdasagi_igazgato = gazdasagi_igazgato;
    }

    public void setGarazs_felelos(int garazs_felelos) {
        Garazs_felelos = garazs_felelos;
    }

    public void setAuto_felelos(int auto_felelos) {
        Auto_felelos = auto_felelos;
    }

    public void setAuto_igenylo(int auto_igenylo) {
        Auto_igenylo = auto_igenylo;
    }

    public void setVezeto(int vezeto) {
        Vezeto = vezeto;
    }
}
