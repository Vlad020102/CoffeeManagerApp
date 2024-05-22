package org.example.interfaces;

public abstract class Persoana {
    private String nume;

    private String prenume;

    private String numarTelefon;

    private String email;


    public Persoana(String nume, String prenume, String numarTelefon, String email) {
        this.nume = nume;
        this.prenume = prenume;
        this.numarTelefon = numarTelefon;
        this.email = email;
    }
    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}