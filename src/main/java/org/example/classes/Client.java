package org.example.classes;
import org.example.interfaces.Persoana;

import java.util.ArrayList;

public class Client extends Persoana {

    private ArrayList<Comanda> comenzi = new ArrayList<Comanda>();

    private Comanda comandaActuala;

    public Client(String nume, String prenume, String numarTelefon, String email, Float fonduri) {
        super(nume, prenume, numarTelefon, email, fonduri);
    }

    String plateste(Boolean isTipping, Barista barista){
        if(this.getFonduri() >= comandaActuala.getPretTotal()){
            this.scadeFonduri(comandaActuala.getPretTotal() * 1.f);
            if(isTipping && this.getFonduri() >= 0.1f * comandaActuala.getPretTotal()){
                // ATENTIE!
                // 10% din pretul total al comenzii
               this.giveTip(0.1f * comandaActuala.getPretTotal(), barista);
            }
            comenzi.add(comandaActuala);
            barista.setComandaActuala(comandaActuala);
            Integer pretTotal = comandaActuala.getPretTotal();
            Companie companie = barista.getAngajator();
            companie.adaugareVenituri(pretTotal);
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

    void giveTip(Float tip, Barista barista){
        barista.addTipsPrimit(tip);
        barista.adaugaFonduri(tip);
        this.scadeFonduri(tip * 1.f);
    }
}
