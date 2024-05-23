package org.example.classes;

import org.example.interfaces.Persoana;

public class ElPatron extends Persoana {

    private Companie companie;

    public ElPatron(String nume, String prenume, String numarTelefon, String email, Float fonduri) {
        super(nume, prenume, numarTelefon, email, fonduri);
    }

    public void infiintareCompanie(Companie companie) {
        this.companie = companie;
    }

    public void inchirereLocatie(String locatie) {
        this.companie.addLocatie(locatie);
    }

    public void adaugaAngajat(Angajat angajat) {
        this.companie.add(angajat);
    }

    public void concendiereAngajat(Angajat angajat) {
        this.companie.remove(angajat);
    }

    public void platireAngajati(){
        for (Angajat angajat : companie.getAngajati()) {
            companie.scadereVenituri(angajat.getSalariu());
            angajat.adaugaFonduri(angajat.getSalariu() * 1.f);
        }
    }

}