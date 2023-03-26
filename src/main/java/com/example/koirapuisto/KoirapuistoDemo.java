package com.example.koirapuisto;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;


import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.koirapuisto.Koirapuisto.kirjoitetaanOliotiedosto;
import static com.example.koirapuisto.Koirapuisto.luetaanOliotiedosto;

/**
 * Koirapuisto-ohjelmaa kasittelevan luokan kayttoliittyma, johon voidaan syottaa tietoja,
 * jotka ohjelma tulostaa.
 * @author mirkka
 * @version 1.0
 */
public class KoirapuistoDemo extends Application {
    /**
     * tänne tulee käyttöliittymä
     */
    /**
     * Kommenttien tekstikentta
     */
    private TextField tfKommentit = new TextField();
    /**
     * Paivamaaran DatePicker
     */
    private DatePicker paivaValitsin = new DatePicker();
    /**
     * Arvosanan MenuButton
     */
    private MenuButton arvosanaValitsin = new MenuButton();
    /**
     * Kävijönöörä
     */
    public int kavijatYhteensa = 0;



    public static void main(String[] args) {
        launch();
    }

    /**
     * Ohjelmaikkuna
     */
    @Override
    public void start(Stage primaryStage) {

        //ComboBox puistoille
        ComboBox puistolista = new ComboBox();

        puistolista.getItems().add(0,"Pitkäkosken koirapuisto");
        puistolista.getItems().add(1,"Kahluuniityn koirapuisto");
        puistolista.getItems().add(2, "Metsälän koirapuisto");


        //OK-painike ikkunan alalaitaan
        Button OKpainike = new Button();
        OKpainike.setLayoutX(250);
        OKpainike.setLayoutY(550);
        OKpainike.setText("OK!");

        //tekstikenttien kuvaukset
        Label eka = new Label("Valitse puisto: ");
        Label kolmas = new Label("Kommentit: ");
        Label neljas = new Label("Käyty: ");
        Label viides = new Label("Arvosana");

        //RadioButtonit arvosanalle
        RadioButton radioButton1 = new RadioButton("1");
        RadioButton radioButton2 = new RadioButton("2");
        RadioButton radioButton3 = new RadioButton("3");
        RadioButton radioButton4 = new RadioButton("4");
        RadioButton radioButton5 = new RadioButton("5");

        //ToggleGroup radiobuttoneille, jotta käyttäjä voi valita vain yhden
        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);
        radioButton5.setToggleGroup(radioGroup);

        //MenuButton MenuItemeille
        HBox arvosanaValitsin = new HBox( radioButton1, radioButton2, radioButton3, radioButton4, radioButton5);


        //GridPne-paneeli, teksikenttien ja painikkeiden asettelua siihen
        GridPane root = new GridPane();
        root.addRow(0, eka, puistolista);
        root.addRow(2, kolmas, tfKommentit);
        root.addRow(3, neljas, paivaValitsin);
        root.addRow(4, viides, arvosanaValitsin);
        root.addRow(5, OKpainike);
        root.setVgap(5);
        root.setHgap(5);
        root.setAlignment(Pos.CENTER);

        //OK-painikkeet tapahtumat
        OKpainike.setOnAction(action -> {

           Koirapuisto puisto1 = new Koirapuisto();

            Object selectedItem = puistolista.getSelectionModel().getSelectedItem();
            System.out.println("Puisto: " + selectedItem);
            if (selectedItem == "Pitkäkosken koirapuisto") {
                System.out.println("Käyntejä Pitkäkosken koirapuistossa: ");

            } else if (selectedItem == "Kahluuniityn koirapuisto") {
                    System.out.println("Käyntejä Kahluuniityn koirapuistossa: ");

                } else if (selectedItem == "Metsälann koirapuisto") {
                    System.out.println("Käyntejä Metsälän koirapuistossa: ");
                }
            //Kommenttikentän tekstin lukeminen
            System.out.println("Kommentteja puistosta: " + tfKommentit.getText());

            //Päivämäärävalitsimen toiminta
            LocalDate paiva = paivaValitsin.getValue();
            System.out.println("käyty: " + paiva);

            //RadioButtoneiden toiminnot
            if (radioButton1.isSelected()) {
                System.out.println("Arvosana: 1");
            }
            if (radioButton2.isSelected()) {
                System.out.println("Arvosana: 2");
            }
            if (radioButton3.isSelected()) {
                System.out.println("Arvosana: 3");
            }
            if (radioButton4.isSelected()) {
                System.out.println("Arvosana: 4");
            }
            if (radioButton5.isSelected()) {
                System.out.println("Arvosana: 5");
            }
            //lasketaan kavijoiden maara
            int kavijatKerroin = ++ kavijatYhteensa;
            System.out.println("Puistokäyntejä yhteensä: " + kavijatKerroin);






        });

        //Ikkunan luominen
        Scene scene = new Scene(root, 600,300);
        primaryStage.setTitle("Koirapuisto");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
