package com.example.koirapuisto;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
     * Arvosanan ilmoittava muuttuja
     */
    private String arvosana;
    /**
     * Parametritön alustaja, joka luo uuden koirapuiston
     */
    public Koirapuisto() {

    }

    /*** Lukupaivakirja perustiedoilla
     * @param puistonNimi
     * @param kommentit
     * @param kavijat
     */
    public Koirapuisto(String puistonNimi, String kommentit, int kavijat, String arvosana) {
        this.puistonNimi = puistonNimi;
        this.kommentit= kommentit;
        this.kavijat = kavijat;
        this.arvosana = arvosana;
        kavijatYhteensa++;
    }

    /**
     * alustaja joka luo uuden puiston
     *
     * @param puisto
     */
    public Koirapuisto(Koirapuisto puisto) {
        this.puistonNimi = puisto.getPuistonNimi();
        this.kommentit = puisto.getKommentit();
        this.kavijat = puisto.getKavijat();
        this.arvosana = puisto.getArvosana();

    }
    /**
     * palauttaa puiston nimen
     *
     * @return String
     */

    public String getPuistonNimi() {
        return puistonNimi;
    }
    /**
     * asettaa puiston nimen
     *
     * @param puistonNimi String
     */
    public void setPuistonNimi(String puistonNimi) {
        this.puistonNimi = puistonNimi;
    }
    /**
     * palauttaa puistoon liittyvät kommentit
     *
     * @return String
     */
    public String getKommentit() {
        return kommentit;
    }
    /**
     * asettaa puiston kommentit
     *
     * @param kommentit String
     */

    public void setKommentit(String kommentit) {
        this.kommentit = kommentit;
    }

    /**
     * Palauttaa kävijämäärän
     * @return int
     */
    public int getKavijat() {
        return kavijat;
    }

    /**
     * Asettaa kävijämäärän
     * @param kavijat
     */

    public void setKavijat(int kavijat) {
        this.kavijat = kavijat;
    }

    /**
     * Palauttaa yhteenlasketun kävijämäärän
     * @return
     */
    public int getKavijatYhteensa() {
        int kavijatYhteensa = 0;
        kavijatYhteensa++;
        return kavijatYhteensa;
    }

    /**
     * Asettaa yhteenlasketun kävijämäärän
     * @param kavijatYhteensa
     */
    public void setKavijatYhteensa(int kavijatYhteensa) {
        this.kavijatYhteensa = kavijatYhteensa;
    }

    /**
     * Tekee tiedoista merkkijonon
     * @return
     */
    public String getArvosana() {
        return arvosana;
    }

    public void setArvosana(String arvosana) {
        this.arvosana = arvosana;
    }
    @Override
    public String toString() {
        return "Koirapuisto{" +
                "puiston nimi ='" + puistonNimi + '\'' +
                ", kommentit ='" + kommentit + '\'' +
                ", kavijätt =" + kavijat +
                ", kavijat yhteensä=" + kavijatYhteensa +
                '}';
    }

    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Koirapuisto puisto = new Koirapuisto();

        File tiedosto = new File("puistot.dat");

        kirjoitetaanOliotiedosto(puisto, tiedosto);

        puisto = luetaanOliotiedosto(tiedosto);

        System.out.println("Kirjoitettiin tiedostoon");

        try{
            kirjoitetaanOliotiedosto(puisto, new File("puistot.dat"));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        try{
            luetaanOliotiedosto(new File("puistot.dat"));
        }
        catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Kirjoitetaan oliotiedosto
     * @param puisto
     * @param tiedosto
     * @throws IOException
     */
    public static void kirjoitetaanOliotiedosto(Koirapuisto puisto, File tiedosto) throws IOException {
        try (FileOutputStream tiedostoUlos = new FileOutputStream(tiedosto);
             ObjectOutputStream olioUlos = new ObjectOutputStream(tiedostoUlos)) {
            olioUlos.writeObject(puisto);
            olioUlos.flush();
        }
    }

    /**
     * Luetaan oliotiedosto
     * @param tiedosto
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Koirapuisto luetaanOliotiedosto(File tiedosto) throws IOException, ClassNotFoundException {
        Koirapuisto result = null;
        try (FileInputStream tiedostoSisaan = new FileInputStream((tiedosto));
             ObjectInputStream olioSisaan = new ObjectInputStream(tiedostoSisaan)) {
            result = (Koirapuisto) olioSisaan.readObject();
        }
        return result;
    }

    }



