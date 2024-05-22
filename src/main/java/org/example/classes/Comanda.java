package org.example.classes;

import org.example.enums.StatusProdus;

import java.util.ArrayList;

public class Comanda {
    private Integer pretTotal;
    private ArrayList<Produs> produse = new ArrayList<Produs>();

    void addProdus(Produs produs) {
        produs.setStatusProdus(StatusProdus.PENDING);
        produse.add(produs);
        this.pretTotal += produs.getPret();
    }
    void removeProdus(Produs produs) {
        produse.remove(produs);
        this.pretTotal -= produs.getPret();
    }

    public Integer getPretTotal() {
        return pretTotal;
    }

    public ArrayList<Produs> getProduse() {
        return produse;
    }

    public void displayComanda(){
        System.out.println("Comanda: ");
        for(Produs produs : produse){
            System.out.println(produs.getNume() + " - " + produs.getPret());
        }
        System.out.println("-----------------");
        System.out.println("Pret total: " + pretTotal);
    }
}
