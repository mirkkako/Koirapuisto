import java.io.Serializable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * Luokka toteuttaa koirapuisto-ohjelman,
 * jonka kenttia ovat puiston nimi, puiston osoite, ja kävijamäärä
 *
 */

public class Koirapuisto implements Serializable {
    /**
     * Puiston nimi merkkijonona
     */
    private String Nimi;
    /**
     * Puiston osoite merkkijonona
     */
    private String Osoite;
    /**
     * Puiston kävijämäärä kokonaislukuna
     */
    private int Kavijat;

    /**
     * Parametritön alustaja, joka luo uuden koirapuiston
     */
    public Koirapuisto(){

    }


}
