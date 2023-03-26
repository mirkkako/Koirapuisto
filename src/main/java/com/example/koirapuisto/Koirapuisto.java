package com.example.koirapuisto;

import java.io.Serializable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/*
 * Luokka toteuttaa koirapuisto-ohjelman,
 * jonka kenttia ovat puiston nimi, puiston kommentit, ja kävijamäärä
 *
 */

public class Koirapuisto implements Serializable {
    /**
     * Puiston nimi merkkijonona
     */
    private String puistonNimi;
    /**
     * Puiston kommentit merkkijonona
     */
    private String kommentit;
    /**
     * Puiston kävijämäärä kokonaislukuna
     */
    private int kavijat;

    /**
     * Kävijämäärää laskeva muuttuja
     */
    private int kavijatYhteensa = 0;

    /**
     * Parametritön alustaja, joka luo uuden koirapuiston
     */
    public Koirapuisto() {

    }
 //  Koirapuisto [] puistot = new Koirapuisto[3];

    /*** Lukupaivakirja perustiedoilla
     * @param puistonNimi
     * @param kommentit
     * @param kavijat
     */
    public Koirapuisto(String puistonNimi, String kommentit, int kavijat) {
        this.puistonNimi = puistonNimi;
        this.kommentit= kommentit;
        this.kavijat = kavijat;
        kavijatYhteensa++;
    }

    /**
     * alustaja joka luo uuden kirjan
     *
     * @param puisto
     */
    public Koirapuisto(Koirapuisto puisto) {
        this.puistonNimi = puisto.getPuistonNimi();
        this.kommentit = puisto.getKommentit();
        this.kavijat = puisto.getKavijat();

    }

    public String getPuistonNimi() {
        return puistonNimi;
    }

    public void setPuistonNimi(String puistonNimi) {
        this.puistonNimi = puistonNimi;
    }

    public String getKommentit() {
        return kommentit;
    }

    public void setKommentit(String osoite) {
        this.kommentit = osoite;
    }

    public int getKavijat() {
        return kavijat;
    }

    public void setKavijat(int kavijat) {
        this.kavijat = kavijat;
    }

    public int getKavijatYhteensa() {
        int kavijatYhteensa = 0;
        kavijatYhteensa++;
        return kavijatYhteensa;
    }

    public void setKavijatYhteensa(int kavijatYhteensa) {
        this.kavijatYhteensa = kavijatYhteensa;
    }

    @Override
    public String toString() {
        return "Koirapuisto{" +
                "puistonNimi='" + puistonNimi + '\'' +
                ", osoite='" + kommentit + '\'' +
                ", kavijat=" + kavijat +
                ", kavijatYteensa=" + kavijatYhteensa +
                '}';
    }

    /**
     * @param puisto-olio, oka tallennetaan oliotiedostoon.
     */
    public static void tallennaOlio(Koirapuisto puisto) {
        try (ObjectOutputStream olioVirta = new ObjectOutputStream(new FileOutputStream("puistot.dat", true))) {
            olioVirta.writeObject(puisto);
            olioVirta.flush();
            olioVirta.close();
            System.out.println("Tallennus onnistui!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Luetaan oliot tiedostosta ja tulostetaan niiden tiedot konsoliin
     *
     * @throws IOException Virheilmoituksia varten
     */
    /**
     *     public static void lueOliot() throws IOException {
     *         //lista johon kerätään olio
     *         ArrayList<Koirapuisto> puistoLista = new ArrayList<>();
     *         int x = 0;
     *         try {
     *             FileInputStream ok = new FileInputStream("puistot.dat");
     *
     *             //luetaan olioita niin kauan, kun niitä on tiedostossa jäljellä
     *             while (ok.available() > 0) {
     *                 ObjectInputStream tiedostoOlio = new ObjectInputStream(ok);
     *                 Koirapuisto puisto = null;
     *
     *                 try {
     *                     puisto = (Koirapuisto) tiedostoOlio.readObject();
     *                     puistoLista.add(puisto);
     *
     *                 } catch (ClassNotFoundException e) {
     *                     e.printStackTrace();
     *                 }
     *             }
     *         }
     */

    }



