package org.example.classes;

import org.example.enums.StatusProdus;
import org.example.enums.TipProdus;

public class Produs {

    private String nume;
    private TipProdus tipProdus;
    private Integer pret;
    private StatusProdus statusProdus;

    public Produs(String nume, TipProdus tipProdus, Integer pret, StatusProdus statusProdus) {
        this.nume = nume;
        this.tipProdus = tipProdus;
        this.pret = pret;
        this.statusProdus = statusProdus;
    }

    public String getNume() {
        return nume;
    }

    public TipProdus getTipProdus() {
        return tipProdus;
    }

    public Integer getPret() {
        return pret;
    }

    public StatusProdus getStatusProdus() {
        return statusProdus;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setTipProdus(TipProdus tipProdus) {
        this.tipProdus = tipProdus;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    public void setStatusProdus(StatusProdus statusProdus) {
        this.statusProdus = statusProdus;
    }
}
