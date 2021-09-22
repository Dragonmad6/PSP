/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarlosC_entregables;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlosc
 */
public class Rifa {

    String nombre;
    int carton[] = new int[5];

    ArrayList<Rifa> baseDatos = new ArrayList<Rifa>();
    int cartonGanador[] = new int[5];
    int aciertosJugador;
    int aciertosTotales = 0;
    public Rifa() {
    }

    public Rifa(String nombre) {
        this.nombre = nombre;
        for (int i = 0; i < carton.length; i++) {
            carton[i] = (int) (Math.random() * 25 + 1);
        }
    }

    //.
    public void IniciarRifa() {
        int opcion;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Elige una opcion:\n");
            System.out.println("1. Añadir jugador");
            System.out.println("2. Empezar partida");
            //Solo es necesario un Scanner
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    AñadirJugador();
                    System.out.println("Nombre: " + baseDatos.get(0).nombre);
                    for (int i = 0; i < baseDatos.get(0).carton.length; i++) {
                        System.out.println(baseDatos.get(0).carton[i] + "");
                    }
                    break;
                case 2:
                    GenerarPremiados();
                    for (int aux : cartonGanador) {
                        System.out.println(aux);
                    }
                    ContarAciertos();
                    RepartirPremios();
                    break;
            }
        } while (opcion != 2);
        System.out.println("\nHasta pronto compañer@!!!");
    }

    public void AñadirJugador() {
        Scanner sc = new Scanner(System.in);
        String nombreAuxiliar;

        System.out.println("Como te llamas?");
        nombreAuxiliar = sc.nextLine();

        baseDatos.add(new Rifa(nombreAuxiliar));

    }

    public void GenerarPremiados() {
        for (int i = 0; i < cartonGanador.length; i++) {
            cartonGanador[i] = (int) (Math.random() * 25 + 1);
        }
    }

    public void ContarAciertos() {
        for(Rifa aux : baseDatos){
            for (int i = 0; i < aux.carton.length; i++) {
                for (int j = 0; j < cartonGanador.length; j++) {
                    if(aux.carton[i] == cartonGanador[j]){
                        aux.aciertosJugador++;
                        aciertosTotales++;
                    }
                }
            }
        }
    }
//
    public void RepartirPremios() {

    }
}
