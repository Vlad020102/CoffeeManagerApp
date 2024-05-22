package org.example.classes;

import org.example.enums.TipPost;
import org.example.interfaces.Persoana;

public class Angajat extends Persoana {
    private Integer salariu = 2000;
    private TipPost tipPost;
    private String adresaLocDeMunca;
    private String intervalOrar;

    public Angajat(String nume, String prenume, String email, String nrTelefon, Integer salariu, TipPost tipPost, String adresaLocDeMunca, String intervalOrar) {
        super(nume, prenume, email, nrTelefon);
        this.tipPost = tipPost;
        this.adresaLocDeMunca = adresaLocDeMunca;
        this.intervalOrar = intervalOrar;
    }


}
