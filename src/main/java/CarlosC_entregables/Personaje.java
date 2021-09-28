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
    
    int fuerza, destreza, constitucion;
    int carisma, manipulacion, compostura;
    int inteligencia, astucia, aplomo;
    int vida;

     public Personaje() {
    }

    public Personaje(String nombre, String especie, String arma, int fuerza, int destreza, int constitucion, int carisma, int manipulacion, int compostura, int inteligencia, int astucia, int aplomo, int vida) {
        this.nombre = nombre;
        this.especie = especie;
        this.arma = arma;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.carisma = carisma;
        this.manipulacion = manipulacion;
        this.compostura = compostura;
        this.inteligencia = inteligencia;
        this.astucia = astucia;
        this.aplomo = aplomo;
        this.vida = 5 + constitucion;
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

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getManipulacion() {
        return manipulacion;
    }

    public void setManipulacion(int manipulacion) {
        this.manipulacion = manipulacion;
    }

    public int getCompostura() {
        return compostura;
    }

    public void setCompostura(int compostura) {
        this.compostura = compostura;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAstucia() {
        return astucia;
    }

    public void setAstucia(int astucia) {
        this.astucia = astucia;
    }

    public int getAplomo() {
        return aplomo;
    }

    public void setAplomo(int aplomo) {
        this.aplomo = aplomo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
}
