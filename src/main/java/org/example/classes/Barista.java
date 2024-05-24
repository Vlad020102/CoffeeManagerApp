package org.example.classes;

import org.example.enums.StatusProdus;
import org.example.enums.TipPost;

import java.util.ArrayList;

public class Barista extends Angajat {

    private Float tipsPrimit = 0.f;

    private Comanda comandaActuala;

    private Integer nrComenziFinalizate = 0;

    private Integer venituriZilnice = 0;


    public Barista(String nume, String prenume, String email, String nrTelefon, TipPost tipPost, String adresaLocDeMunca, String intervalOrar, Integer salariu, Float fonduri) {
        super(nume, prenume, email, nrTelefon, salariu, tipPost, adresaLocDeMunca, intervalOrar, fonduri);
    }

    public void setComandaActuala(Comanda comanda){
        this.comandaActuala = comanda;
    }

    public void addTipsPrimit(Float tipsPrimit) {
        this.tipsPrimit += tipsPrimit;
    }

    public Float getTipsPrimit() {
        return tipsPrimit;
    }

    public Integer getVenituriZilnice() {
        return venituriZilnice;
    }

    public Integer getNrComenziFinalizate() {
        return nrComenziFinalizate;
    }

    public void servireComanda() {
        for (Produs produs : comandaActuala.getProduse()) {
            produs.setStatusProdus(StatusProdus.SERVIT);
            this.venituriZilnice += produs.getPret();
        }
        this.comandaActuala = null;
        this.nrComenziFinalizate++;
    }
    
    public ArrayList<Produs> preparaProduse() {
        for (Produs produs : comandaActuala.getProduse()) {
            // delay for 1000 ms
            System.out.println(produs.getNume() + " este in curs de preparare...");
            try {
                // simulate the work of preparing the product
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            produs.setStatusProdus(StatusProdus.PREPARAT);
        }

        return this.comandaActuala.getProduse();
    }
}
