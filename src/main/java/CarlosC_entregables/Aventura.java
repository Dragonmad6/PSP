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
    
    Personaje ninfa = new Personaje("Meliany", "ninfa", "baston", 3, 2, 4, 3, 0, 2, 3, 2, 1, 3);
    Personaje minotauro = new Personaje("Bob", "minotauro", "maza", 4, 3, 5, 2, 1, 1, 2, 1, 3, 2);
    Personaje escarabajo = new Personaje("Larvesta", "insecto", "residuos", 5, 1, 4, 2, 0, 5, 4, 3, 1, 1);
    
    Personaje[] grupo = new Personaje[4];
    Personaje bossfinal = new Personaje ("Ragnork", "BESTIA", "Martillo", 5, 5, 5, 4, 1, 3, 3, 3, 2, 4);
    Prueba grieta = new Prueba("Grieta", 2, 3);
    
    
    public Aventura() {
    }

    public void IniciarAventura() {

        Introduccion();
        CrearProta();
        CrearGrupo();
        DecisionCamino();
        //PrimeraLucha();
        //PeleaEnGrupo(grupo,bossfinal);
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
        System.out.println("\n" + atacante.nombre + " golpea a " + defensor.nombre + " causandole: " + daño + " puntos de daño.\n");
        System.out.println("\n" + defensor.nombre + " le quedan " + defensor.vida + " puntos de vida");
 
    }

    public void CrearProta() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre: ");
        prota.nombre = sc.nextLine();
        System.out.println("Especie: ");
        prota.especie = sc.nextLine();
        System.out.println("Arma: ");
        prota.arma = sc.nextLine();
        
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
        
        System.out.println("Aplomo: ");
        prota.aplomo = Integer.parseInt(sc.nextLine());
        prota.vida = 5 + prota.constitucion;
    }

    public void Introduccion() {
        System.out.println("Bienvenido al mundo de Elgyon invocador.\n");
        System.out.println("Elgyon es la tierra de los insectos subterráneos, nuestra misión es llegar de vuelta a la superficie.");
        System.out.println("Para poder recuperar el martillo de la esperanza.");
        System.out.println("En este fantástico viaje te acompañarán:");
        System.out.println(ninfa.nombre + " la " + ninfa.especie);
        System.out.println(minotauro.nombre + " el " + minotauro.especie);
        System.out.println(escarabajo.nombre + " el " + escarabajo.especie);
        System.out.println("Ahora que conoces a todos vayamos a por ese martillo.");
    }

    public void SaltarGrieta() {
        System.out.println("Empezamos a caminar en la direccion que habiamos tomado, para nuestra sorpresa vemos una pequeña grieta la cual podiamos intentar saltar.");
        for (int i = 0; i < grupo.length; i++) {
            System.out.println(grupo[i].nombre + " intenta saltar la grieta");
            
            int exitos = LanzarDados(grupo[i].fuerza + grupo[i].destreza);
            System.out.println("Exitos: " + exitos);
            
            if (LanzarDados(grupo[i].fuerza + grupo[i].destreza) >=  grieta.dificultad) {
                System.out.println("");
                System.out.println(grupo[i].nombre + " salta la grieta.");
            }else{
                System.out.println(grupo[i].nombre + " se cae a la grieta y sufre " + grieta.daño + " puntos de daño.");
            }
        }
    }
    
    public void CrearGrupo(){
        grupo[0] = prota;
        grupo[1] = ninfa;
        grupo[2] = minotauro;
        grupo[3] = escarabajo;
    }
    
    public void PeleaAMuerte(Personaje personaje1, Personaje personaje2){
        System.out.println("\n" + personaje1.nombre + " se va a pelear con " + personaje2.nombre);
        
            if(personaje1.vida > 0){
                Golpear(personaje1, personaje2);
            }
            if(personaje2.vida > 0){
                Golpear(personaje2, personaje1);
            }
        
        if(personaje1.vida > 0 && personaje2.vida <= 0){
            System.out.println(personaje1.nombre + " ha ganado la pelea.");
        }else{
            System.out.println(personaje2.nombre + " ha ganado la pelea.");

        }
        if(escarabajo.vida > minotauro.vida){
            System.out.println("Larvesta se levanta tras el combate y le dice al minotauro.\n");
            System.out.println("Larvesta: Minotauro no es necesario pelear, debemos proseguir nuestro camino");
            System.out.println("\n 'Le ayuda a levantarse.'");
        }else{
            System.out.println("Levanta insecto no eres rival para mí.");
            System.out.println("\n" + ninfa.nombre + "se acerca a " + escarabajo.nombre + " y lo cura");
            escarabajo.vida = escarabajo.vida + 1;
        }
    }
    
    public void DecisionCamino(){
        Scanner ScannerInt = new Scanner(System.in);
        
        System.out.println("Nuestros aventureros se están acercando a una bifurcación que deberían de hacer...\n");
        System.out.println(minotauro.nombre + " el " + minotauro.especie + " piensa que deberíamos de ir por el camino de la izquierda\n");
        System.out.println(escarabajo.nombre + " el " + escarabajo.especie + " piensa que deberíamos de ir por el camino de la derecha\n");
        System.out.println("¿A quién deberíamos de hacer caso?\n");
        
        System.out.println("Pulsa 1 para ir a la izquierda.");
        System.out.println("Pulsa 2 para ir a la derecha");
        
        
        int camino;
        camino = ScannerInt.nextInt();
        switch (camino){
            case 1:
                System.out.println("Has decidido ir por el camino de la izquierda.");
                System.out.println("Nuestro amigo el escarabajo " + escarabajo.nombre + " agacha la cabeza y no rechista sabiendo qeu no puede hacer frente al minotauro.");
                System.out.println("Nuestra compañera " + ninfa.nombre + " anima al escarabajo y proseguimos nuestra camino.");
                SaltarGrieta();
                break;
            
            case 2:
                System.out.println("Has decidido seguir el instinto del insecto y prosigues tu camino.");
                System.out.println("Nuestro compañero el minotauro " + minotauro.nombre + " no está muy contento con nuestra decisión.");
                System.out.println("Nuestra compañera " + ninfa.nombre + " intenta relajarlo, pero este lo impide, proseguimos nuestro camino.");
                PeleaAMuerte(minotauro, escarabajo);
                break;
            
        }
    }
    
    public void PrimeraLucha(){
        System.out.println("Consiguen llegar a la primera parte de nuestro tronco.");        
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








