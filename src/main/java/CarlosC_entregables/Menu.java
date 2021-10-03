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
        
        // TODO code application logic here..
        Scanner ScannerInt = new Scanner(System.in);
        Scanner ScannerString = new Scanner(System.in);

        Rifa rifa = new Rifa();
        Aventura aventura = new Aventura();
//        System.out.println("Nombre: " + rifa.nombre);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(rifa.carton[i] + " ");
//        }

        int opcion;
        System.out.printf("Escribe un número del menú. \n");
        do {
            System.out.println(
                    "Pulsa:\n\t1. Juego de Rifa."
                    + "\n\t2. Juego de Aventura."
                    + "\n\t0. Salir.");
            opcion = ScannerInt.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Has escogido la opción 0.");
                    System.exit(opcion);
                    break;
                case 1:
                    System.out.println("Has escogido la opción 1.");
                    rifa.IniciarRifa();
                    break;
                case 2:
                    System.out.println("Has escogido la opción 2.\n");
                    aventura.IniciarAventura();
                    break;
                default:
                    System.out.println("Opcion incorrecta, elija de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
}
