package org.example.classes;

import org.example.enums.TipPost;
import org.example.interfaces.Persoana;

public class Angajat extends Persoana {
    private Integer salariu = 2000;
    private TipPost tipPost;
    private String adresaLocDeMunca;
    private String intervalOrar;

    public Angajat(String nume, String prenume, String email, String nrTelefon, Integer salariu, TipPost tipPost, String adresaLocDeMunca, String intervalOrar, Float fonduri) {
        super(nume, prenume, email, nrTelefon, fonduri);
        this.tipPost = tipPost;
        this.adresaLocDeMunca = adresaLocDeMunca;
        this.intervalOrar = intervalOrar;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public TipPost getTipPost() {
        return tipPost;
    }

    public String getAdresaLocDeMunca() {
        return adresaLocDeMunca;
    }

    public String getIntervalOrar() {
        return intervalOrar;
    }
}
