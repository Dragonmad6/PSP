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
    
    Personaje ninfa = new Personaje("Mercedes", "ninfa", "baston", 3, 2, 4, 3, 0, 2, 3, 2, 1, 3);
    Personaje botones = new Personaje("Bob", "minotauro", "baston", 4, 3, 1, 2, 1, 1, 2, 1, 3, 2);
    
    Personaje[] grupo = new Personaje[4];
    Prueba foso = new Prueba("Foso", 2, 3);
    
    
    public Aventura() {
    }

    public void IniciarAventura() {

        Introduccion();
        SaltarFoso();
        PeleaAMuerte(prota,ninfa);
        
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
    
    public void Golpear(Personaje atacante, Personaje defensor){
        int daño = LanzarDados(atacante.fuerza + atacante.destreza - defensor.astucia);
        //defensor.vida = defensor.vida - daño;
        defensor.vida -= daño;
        System.out.println("\n" + atacante.nombre + "golpea a " + defensor.nombre + "causandole: " + daño + " puntos de daño.\n");
        System.out.println("\n" + defensor.nombre + "le quedan" + defensor.vida + " puntos de vida");
 
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
        prota.vida = 5 + prota.constitucion;
    }

    public void Introduccion() {
        System.out.println("Bienvenido al mundo de Elgyon.");
        System.out.println("Elgyon es la tierra de ");
    }

    public void SaltarFoso() {
        for (int i = 0; i < grupo.length; i++) {
            System.out.println(grupo[i].nombre + "intenta saltar el foso");
            int exitos = LanzarDados(prota.fuerza + prota.destreza);
            System.out.println("Exitos: " + exitos);
            if (LanzarDados(prota.fuerza + prota.destreza) >=  foso.dificultad) {
                System.out.println("");
                System.out.println(prota.nombre + "salta el foso.");
            }else{
                System.out.println(prota.nombre + "se cae al foso y sufre " + foso.daño + "puntos de daño.");
                
            }
            if(LanzarDados(prota.fuerza + prota.destreza) >= foso.dificultad){
                System.out.println("");
                System.out.println(prota.nombre + "se cae al foso y sufre " + foso.daño + "puntos de daño.");
            }
        }
    }
    
    public void CrearGrupo(){
        grupo[0] = prota;
        grupo[1] = ninfa;
        grupo[2] = botones;
    }
    
    public void PeleaAMuerte(Personaje personaje1, Personaje personaje2){
        System.out.println("\n" + personaje1.nombre + "se va a pelear con " + personaje2.nombre);
        while(personaje1.vida > 0 && personaje2.vida > 0){
            if(personaje1.vida > 0){
                Golpear(personaje1, personaje2);
            }
            if(personaje2.vida > 0){
                Golpear(personaje2, personaje1);
            }
        }
        if(personaje1.vida > 0 && personaje2.vida <= 0){
            System.out.println(personaje1.nombre + " ha ganado la pelea.");
        }else{
            System.out.println(personaje2.nombre + " ha ganado la pelea.");

        }
    }
    
    public void PeleaEnGrupo(Personaje[] grupo, Personaje enemigo){
        System.out.println("\n El grupo de aventureros se dispone a enfrentarse a " + enemigo.nombre);
        int objetivo = grupo.length;
        while(grupo[0].vida > 0 && enemigo.vida > 0){
            for (int i = 0; i < grupo.length; i++) {
                if(grupo[i].vida > 0){
                    Golpear(grupo[i], enemigo);
                }
            }
            if(enemigo.vida > 0){
                Golpear(enemigo, grupo[objetivo]);
                if(grupo[objetivo].vida <= 0){
                    objetivo--;
                }
            }
        }
        if(enemigo.vida <= 0){
            System.out.println("\nEl grupo ha ganado la pelea, ha derrotado a " + enemigo.nombre);
        }else{
            System.out.println("\n" + enemigo.nombre + " ha vencido al grupo. ¿Será este el fin?");
        }
    }
    
}








