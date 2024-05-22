package org.example;

import org.example.classes.Angajat;
import org.example.classes.Companie;
import org.example.classes.ElPatron;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ElPatron patron = new ElPatron("Muchacho", "Gatito", "0710101010", "muchacho_gatito10@gmail.com", 10000.f);
        Companie companie = new Companie("CoisCoffee", 1000, patron);
        for (int i = 0; i < 10; i++) {
            Angajat angajat = new Angajat("Nume" + i, "Prenume" + i, "email" + i + "@gmail.com", "0710101010", 2000, null, "adresa" + i, "interval" + i, 1000.f);
//            Barista barista =  new Barista("Nume" + i, "Prenume" + i, "email" + i + "@gmail.com", "0710101010", 2000, null, "adresa" + i, "interval" + i, 1000.f);
            patron.adaugaAngajat(angajat);
        }

    }
}