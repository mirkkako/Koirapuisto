package com.example.koirapuisto;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;


import java.time.LocalDate;

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
     * Lukupaivakirja-olio
     */

    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Ohjelmaikkuna
     */
    @Override
    public void start(Stage primaryStage) {

        ListView puistolista = new ListView();

        puistolista.getItems().add("Puisto 1");
        puistolista.getItems().add("Puisto 2");
        puistolista.getItems().add("Puisto 3");

        //OK-painike ikkunan alalaitaan
        Button OKpainike = new Button();
        OKpainike.setLayoutX(250);
        OKpainike.setLayoutY(550);
        OKpainike.setText("OK!");

        //tekstikenttien kuvaukset
        Label eka = new Label("Puiston nimi: ");
        Label toka = new Label("Puiston osoite: ");
        Label kolmas = new Label("Kommentit: ");
        Label neljas = new Label("Käyty: ");
        Label viides = new Label("Arvosana");

        //RadioButtonit arvosanalle
        RadioButton radioButton1 = new RadioButton("1");
        RadioButton radioButton2 = new RadioButton("2");
        RadioButton radioButton3 = new RadioButton("3");
        RadioButton radioButton4 = new RadioButton("4");
        RadioButton radioButton5 = new RadioButton("5");

        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);
        radioButton5.setToggleGroup(radioGroup);


        //MenuButton MenuItemeille
        VBox arvosanaValitsin = new VBox( radioButton1, radioButton2, radioButton3, radioButton4, radioButton5);


        //GridPne-paneeli, teksikenttien ja painikkeiden asettelua siihen
        GridPane root = new GridPane();
    //    root.addRow(0, eka, tfPuisto);
    //    root.addRow(1, toka, tfosoite);
        root.addRow(2, kolmas, tfKommentit);
        root.addRow(3, neljas, paivaValitsin);
        root.addRow(4, viides, arvosanaValitsin);
        root.addRow(5, OKpainike);
        root.addRow(6,puistolista);
        root.setVgap(5);
        root.setHgap(5);
        root.setAlignment(Pos.CENTER);

        OKpainike.setOnAction(action -> {
       //     System.out.println("Kirjan nimi: " + tfOsoite.getText());
            LocalDate paiva = paivaValitsin.getValue();
            System.out.println("käyty: " + paiva);

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


        });


        Scene scene = new Scene(root, 600,300);
        primaryStage.setTitle("Koirapuisto");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
