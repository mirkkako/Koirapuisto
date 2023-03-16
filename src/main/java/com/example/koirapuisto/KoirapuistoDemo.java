package com.example.koirapuisto;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;


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
     * Kirjan tekstikentta
     */
    private TextField tfKirja = new TextField();
    /**
     * Kirjailijan tekstikentta
     */
    private TextField tfKirjailija = new TextField();
    /**
     * Sivumaaran tekstikentta
     */
    private TextField tfSivumaara = new TextField();
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

    /**
     * kirjaolioiden maara
     */
    private int kirjatYhteensa = 0;

    /**
     * sivujen maara
     */
    private int luettujaSivuja = 0;



    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Ohjelmaikkuna
     */
    @Override
    public void start(Stage primaryStage) {
        //OK-painike ikkunan alalaitaan
        Button OKpainike = new Button();
        OKpainike.setLayoutX(250);
        OKpainike.setLayoutY(550);
        OKpainike.setText("OK!");

        //tekstikenttien kuvaukset
        Label eka = new Label("Kirjan nimi: ");
        Label toka = new Label("Kirjailijan nimi: ");
        Label kolmas = new Label("Sivumäärä: ");
        Label neljas = new Label("Luettu: ");
        Label viides = new Label("Arvosana");

        //MenuItemit arvosanalle
        MenuItem menuItem1 = new MenuItem("5");
        MenuItem menuItem2 = new MenuItem("4");
        MenuItem menuItem3 = new MenuItem("3");
        MenuItem menuItem4 = new MenuItem("2");
        MenuItem menuItem5 = new MenuItem("1");

        //MenuButton MenuItemeille
        MenuButton arvosanaValitsin = new MenuButton("Valitse arvosana", null, menuItem1, menuItem2, menuItem3, menuItem4, menuItem5);


        //arvosanaValitsimen tapahtumat
        menuItem1.setOnAction(event -> {
            System.out.println("Arvosana: 5");
        });
        menuItem2.setOnAction(event -> {
            System.out.println("Arvosana: 4");
        });
        menuItem3.setOnAction(event -> {
            System.out.println("Arvosana: 3");
        });
        menuItem4.setOnAction(event -> {
            System.out.println("Arvosana: 2");
        });
        menuItem5.setOnAction(event -> {
            System.out.println("Arvosana: 1");
        });


        //GridPne-paneeli, teksikenttien ja painikkeiden asettelua siihen
        GridPane root = new GridPane();
        root.addRow(0, eka, tfKirja);
        root.addRow(1, toka, tfKirjailija);
        root.addRow(2, kolmas, tfSivumaara);
        root.addRow(3, neljas, paivaValitsin);
        root.addRow(4, viides, arvosanaValitsin);
        root.addRow(5, OKpainike);
        root.setVgap(5);
        root.setHgap(5);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500,200);
        primaryStage.setTitle("Koirapuisto");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
