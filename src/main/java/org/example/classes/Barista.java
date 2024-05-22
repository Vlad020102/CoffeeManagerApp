package org.example.classes;

import org.example.classes.Angajat;
import org.example.enums.TipPost;

public class Barista extends Angajat {
    private Integer tipsPrimite = 0;

    private Comanda comandaActuala;
    private Integer nrComenziFinalizate = 0;

    public Barista(String nume, String prenume, String email, String nrTelefon, TipPost tipPost, String adresaLocDeMunca, String intervalOrar, Integer salariu, Integer tipsPrimite) {
        super(nume, prenume, email, nrTelefon, salariu, tipPost, adresaLocDeMunca, intervalOrar);
        this.tipsPrimite = tipsPrimite;
    }

    public void setComandaActuala(Comanda comanda){
        this.comandaActuala = comanda;
    }

    public void setTipsPrimite(Integer tipsPrimite) {
        this.tipsPrimite += tipsPrimite;
    }
}
