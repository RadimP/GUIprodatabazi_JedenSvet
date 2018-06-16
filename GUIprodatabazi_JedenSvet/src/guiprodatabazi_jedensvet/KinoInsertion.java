/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprodatabazi_jedensvet;

import java.io.Serializable;

/**
 *
 * @author RadimP
 */
public class KinoInsertion implements Serializable {

    private String Nazev;
    private String Ulice;
    private String C_popisne;
    private String C_orientacni;
    private String Obec;
    private String PSC;

    KinoInsertion(String Nazev, String Ulice, String C_popisne, String C_orientacni, String Obec, String PSC) {
        this.Nazev = Nazev;
        this.Ulice = Ulice;
        this.C_popisne = C_popisne;
        this.C_orientacni = C_orientacni;
        this.Obec = Obec;
        this.PSC = PSC;
    }

    public String getNazev() {
        return this.Nazev;
    }

    public String getUlice() {
        return this.Ulice;
    }

    public String getC_popisne() {
        return this.C_popisne;
    }

    public String getC_orientacni() {
        return this.C_orientacni;
    }

    public String getObec() {
        return this.Obec;
    }

    public String getPSC() {
        return this.PSC;
    }

}
