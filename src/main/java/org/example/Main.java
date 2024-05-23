package org.example;

import org.example.classes.Barista;
import org.example.classes.Companie;
import org.example.classes.ElPatron;
import org.example.enums.TipPost;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ElPatron patron = new ElPatron("Muchacho", "Gatito", "0710101010", "muchacho_gatito10@gmail.com", 10000.f);
        Companie companie = new Companie("CoisCoffee", 1000, patron);

        patron.infiintareCompanie(companie);
        for (int i = 0; i < 3; i++) {
            String adresa = "Strada" + i + ", Oras" + i + ", Judet" + i;
            patron.inchirereLocatie(adresa);
        }

        for (int i = 0; i < 10; i++) {
            Barista barista = new Barista("Barista" + i, "Barista" + i, "barista" + i + "@gmail.com", "0710101010", TipPost.BARISTA, companie.getLocatii().get(i), "intervalul", 2000, 0.f);
            patron.adaugaAngajat(barista);
        }


    }
}