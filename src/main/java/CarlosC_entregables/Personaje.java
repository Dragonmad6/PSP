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
}
