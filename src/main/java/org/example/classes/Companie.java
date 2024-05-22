package org.example.classes;

import org.example.enums.TipPost;

import java.util.ArrayList;

public class Companie {
    private String nume;
    private Integer veniturileCampaniei;
    private ArrayList<Angajat> angajati = new ArrayList<>();
    private ElPatron patron;
    private ArrayList<String> locatii;
    public Companie(String nume, Integer veniturileCampaniei, ElPatron patron) {
        this.nume = nume;
        this.veniturileCampaniei = veniturileCampaniei;
        this.patron = patron;
    }

    protected void add(Angajat angajat) {
        this.angajati.add(angajat);
    }

    protected void remove(Angajat angajat) {
        this.angajati.remove(angajat);
        angajat = null;
    }
    public ElPatron getPatron() {
        return patron;
    }

    public ArrayList<Angajat> getAngajati() {
        return angajati;
    }
    public Integer getVeniturileCampaniei() {
        return veniturileCampaniei;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    public void daily_recap (){
        System.out.println("Recapitulare zilnica pentru campania " + this.nume);
        System.out.println("Venituri: " + this.veniturileCampaniei);
        System.out.println("Angajati: ");
        for (Angajat angajat : angajati) {
            if (angajat.getTipPost() == TipPost.BARISTA) {
                Barista b = (Barista) angajat;
                System.out.println("Barista: " + angajat.getNume() + " " + angajat.getPrenume() + b.getNrComenziFinalizate() + b.getVenituriZilnice());
            }
            System.out.println(angajat.getNume() + " " + angajat.getPrenume());
        }
    }

    public void addLocatie (String locatie) {
        this.locatii.add(locatie);
    }

    public void scadereVenituri(Integer venituri) {
        this.veniturileCampaniei -= venituri;
    }
}