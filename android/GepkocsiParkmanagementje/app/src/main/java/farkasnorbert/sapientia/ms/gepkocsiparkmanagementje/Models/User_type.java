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
}
