package org.example.classes;
import org.example.interfaces.Persoana;

import java.util.ArrayList;

public class Client extends Persoana {
    private Integer fonduri;

    private ArrayList<Comanda> comenzi = new ArrayList<Comanda>();

    private Comanda comandaActuala;

    public Client(String nume, String prenume, String numarTelefon, String email, Integer fonduri) {
        super(nume, prenume, numarTelefon, email);
        this.fonduri = fonduri;
    }

    String plateste(Boolean isTipping, Barista barista){
        if(this.fonduri >= comandaActuala.getPretTotal()){
            this.fonduri -= comandaActuala.getPretTotal();
            if(isTipping){
                this.fonduri -= 10;
            }
            comenzi.add(comandaActuala);
            barista.setComandaActuala(comandaActuala);
            Integer pretTotal = comandaActuala.getPretTotal();
            comandaActuala = null;
            System.out.println("Comanda platita cu succes!");

            return "Total Platit: " + pretTotal + " lei";
        } else {
            throw new RuntimeException("Fonduri insuficiente!");
        }
    }

    void comandaProdus(Produs produs){
        if(comandaActuala == null){
            comandaActuala = new Comanda();
        }
        comandaActuala.addProdus(produs);
    }

    void giveTip(Integer tip, Barista barista){
        barista.setTipsPrimite(tip);
        this.fonduri -= tip;
    }
}
