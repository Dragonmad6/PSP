/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarlosC_entregables;

/**
 *
 * @author CMaster
 */
public class Personaje {
    
    //Variables
    String nombre;
    String especie;
    String arma;
    
    int fuerza;
    int fortaleza;
    int conocimiento;
    int agilidad;

     public Personaje() {
    }
    
    public Personaje(String nombre, String especie, String arma, int fuerza, int fortaleza, int conocimiento, int agilidad) {
        this.nombre = nombre;
        this.especie = especie;
        this.arma = arma;
        this.fuerza = fuerza;
        this.fortaleza = fortaleza;
        this.conocimiento = conocimiento;
        this.agilidad = agilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(int fortaleza) {
        this.fortaleza = fortaleza;
    }

    public int getConocimiento() {
        return conocimiento;
    }

    public void setConocimiento(int conocimiento) {
        this.conocimiento = conocimiento;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
       
}
