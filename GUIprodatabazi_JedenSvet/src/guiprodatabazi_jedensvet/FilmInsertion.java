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
public class FilmInsertion implements Serializable {
private String JmenoF;
private String Reziser;
private String Rok;
private String Popis;

FilmInsertion(String JmenoF, String Reziser, String Rok, String Popis) {
this.JmenoF = JmenoF;
this.Reziser = Reziser;
this.Rok = Rok;
this.Popis = Popis;
}

public String getJmenoF() {
return this.JmenoF;
}

public String getReziser() {
return this.Reziser;
}

public String getRok() {
return this.Rok;
}

public String getPopis() {
return this.JmenoF;
}
}
