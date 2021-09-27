/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarlosC_entregables;

import java.util.Scanner;

/**
 *
 * @author Carlosc
 */
public class Aventura {

    Personaje prota = new Personaje();

    Personaje ninfa = new Personaje("Mercedes", "ninfa", "baston", 3, 2, 4, 3, 0, 2, 3, 2, 1);
    Personaje botones = new Personaje("Bob", "minotauro", "baston", 4, 3, 1, 2, 1, 1, 2, 1, 3);
    Personaje ninfa = new Personaje("Mercedes", "ninfa", "baston", 3, 2, 4, 3, 0, 2, 3, 2, 1);
    Prueba foso = new Prueba("Foso", 2, 3);

    public Aventura() {
    }

    public void IniciarAventura() {

        Introduccion();
        SaltarFoso();
    }

    public int LanzarDados(int numeroDados) {
        int exitos = 0;
        int resultado;
        for (int i = 0; i < numeroDados; i++) {
            resultado = (int) (Math.random() * 10 + 1);
            if (resultado > 7) {
                exitos++;
            }
        }
        return exitos;
    }

    public void CrearProta() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre: ");
        prota.nombre = sc.nextLine();
        System.out.println("Especie: ");
        prota.especie = sc.nextLine();

        System.out.println("Fuerza: ");
        prota.fuerza = Integer.parseInt(sc.nextLine());

        System.out.println("Destreza: ");
        prota.destreza = Integer.parseInt(sc.nextLine());

        System.out.println("Constitucion: ");
        prota.constitucion = Integer.parseInt(sc.nextLine());

        System.out.println("Carisma: ");
        prota.carisma = Integer.parseInt(sc.nextLine());

        System.out.println("Manipulacion: ");
        prota.manipulacion = Integer.parseInt(sc.nextLine());

        System.out.println("Compostura: ");
        prota.compostura = Integer.parseInt(sc.nextLine());

        System.out.println("Inteligencia: ");
        prota.inteligencia = Integer.parseInt(sc.nextLine());

        System.out.println("Astucia: ");
        prota.astucia = Integer.parseInt(sc.nextLine());

        System.out.println("Compostura: ");
        prota.compostura = Integer.parseInt(sc.nextLine());

        System.out.println("Aplomo: ");
        prota.aplomo = Integer.parseInt(sc.nextLine());
        prota.vida = 5 + constitucion;
    }
    
    public void CrearGrupo(){
        
    }

    public void Introduccion() {
        System.out.println("Bienvenido al mundo de Elgyon.");
        System.out.println("Elgyon es la tierra de ");
    }

    public void SaltarFoso() {
        int exitos;
        for (int i = 0; i < grupo.length , i++) {
            System.out.println(prota.nombre + "Intenta saltar el foso.");
            int exitos = LanzarDados(prota.fuerza + prota.destreza);
            System.out.println("Exitos: " + exitos);
            if (LanzarDados(prota.fuerza + prota.destreza) >= foso.dificultad) {
                System.out.println(prota.nombre + "Salta el foso");
            } else {
                System.out.println(prota.nombre + "Se cae al foso y sufre " + foso.daño + " puntos de daño");
            }
        }
    }
}
