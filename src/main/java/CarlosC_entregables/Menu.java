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
public class Menu {
    
    public static void main(String[] args){
        
        //Scanner
        Scanner sc = new Scanner(System.in);
        Rifa rifa = new Rifa("Carlos");
        
        //Comprobacion de metodo
//        System.out.println("Nombre:" +rifa.nombre);
//        for(int i=0; i<5; i++){
//            System.out.println(rifa.carton[i]+"");
//        }
        //Variables
        int opcion;
        
        //Presentacion
        System.out.println("Bienvenido, por favor eliga la modalidad de juego que desea participar.\n");
        
        do{
            //Seleccionar el juego
            System.out.println("Selecciona una opcion.");
                System.out.println("1. Jugar | La rifa |");
                System.out.println("2. Jugar | Aventura |");
                System.out.println("3. Salir.\n");
            
            //Solo es necesario un Scanner
            opcion = Integer.parseInt(sc.nextLine());
                    
            switch(opcion){
             //Opciones del menu
                case 1:
                    System.out.println("¡Qué empiece el juego!");
                    rifa.IniciarRifa();
                    break;
                case 2:
                    System.out.println("¡Qué empiece el juego!");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no aceptada seleccione de nuevo.");
                    break;
        }
        }while(opcion != 3);
        System.out.println("GAME OVER");
    }
}
