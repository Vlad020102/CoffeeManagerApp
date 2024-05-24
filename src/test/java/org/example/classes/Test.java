package org.example.classes;

import org.example.enums.StatusProdus;
import org.example.enums.TipPost;
import org.example.enums.TipProdus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    Barista mockedBarista;
    Comanda mockedComanda = new Comanda();
    Client underTest;
    ElPatron mockedPatron;
    @BeforeEach
    void beforeEach() {
        mockedBarista = new Barista("Barista", "Barista", "barista@gmail.com", "0710101010", TipPost.BARISTA, "Adresa", "10:00-16:00", 2000, 10.f);
        mockedPatron = new ElPatron("Patron", "Patron", "0710101010", "patron@gmail.com", 1000.f);
        Companie companie = new Companie("CoisCoffee", 10000, mockedPatron);

        mockedPatron.infiintareCompanie(companie);
        mockedPatron.inchirereLocatie("Adresa");
        mockedPatron.adaugaAngajat(mockedBarista);
    }

    @AfterEach
    void tearDown() {
        underTest = null;
        mockedBarista = null;
        mockedComanda = null;
    }
    @org.junit.jupiter.api.Test
    void PlatesteAndShouldReturnRunTimeExceptionFonduriInsuficiente() {
        underTest = new Client("Client", "Client", "0710101010", "client@gmail.com", 10.f);

        Produs cafea = new Produs("Cafea", TipProdus.CAFEA, 2);
        Produs croissant = new Produs("Croissant", TipProdus.CROISSANT, 6);

        underTest.comandaProdus(cafea);
        underTest.comandaProdus(croissant);

        assertThrows(RuntimeException.class, () -> underTest.plateste(false, mockedBarista));
    }

    @org.junit.jupiter.api.Test
    void TipAndBaristaShouldReceiveTipping() {
        underTest = new Client("Client", "Client", "0710101010", "client@gmail.com", 30.f);

        Produs cafea = new Produs("Cafea", TipProdus.CAFEA, 10);
        Produs croissant = new Produs("Croissant", TipProdus.CROISSANT, 10);

        underTest.comandaProdus(cafea);
        underTest.comandaProdus(croissant);

        underTest.plateste(true, mockedBarista);

        assertEquals(2.f, mockedBarista.getTipsPrimit());
        assertEquals(13.f, mockedBarista.getFonduri());
    }

    @org.junit.jupiter.api.Test
    void PrepareProductsAndAllProductsShouldBePrepared() {
        underTest = new Client("Client", "Client", "0710101010", "client@gmail.com", 30.f);

        Produs cafea = new Produs("Cafea", TipProdus.CAFEA, 10);
        Produs croissant = new Produs("Croissant", TipProdus.CROISSANT, 10);

        underTest.comandaProdus(cafea);
        underTest.comandaProdus(croissant);

        underTest.plateste(false, mockedBarista);

        ArrayList<Produs> produse = mockedBarista.preparaProduse();

        for (Produs produs : produse) {
            assertEquals(StatusProdus.PREPARAT, produs.getStatusProdus());
        }
    }

    @org.junit.jupiter.api.Test
    void PayAngajatAndCompanyShouldHaveLessFontsAndAngajatMore() {
        mockedPatron.platireAngajati();

        assertEquals(8000, mockedPatron.getCompanie().getVeniturileCampaniei());
        assertEquals(2010.f, mockedBarista.getFonduri());
    }

}