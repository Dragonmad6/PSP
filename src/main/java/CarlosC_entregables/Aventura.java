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

    //Pertenecientes a grupo
    Personaje ninfa = new Personaje("Meliany", "ninfa", "baston", 3, 2, 4, 3, 0, 2, 3, 2, 1, 4);
    Personaje minotauro = new Personaje("Bob", "minotauro", "maza", 4, 3, 5, 2, 1, 1, 2, 1, 3, 2);
    Personaje escarabajo = new Personaje("Larvesta", "insecto", "residuos", 5, 1, 4, 2, 0, 5, 4, 3, 1, 2);

    //Pertenecientes a grupomobs
    Personaje cienpies = new Personaje("Cimpios", "cienpies", "dientes", 1, 2, 2, 2, 0, 2, 2, 2, 2, 2);
    Personaje gusano = new Personaje("Gusanito", "gusano", "Golpe Cuerpo", 1, 2, 1, 1, 0, 1, 1, 1, 1, 1);
    Personaje termita = new Personaje("Terminator", "termita", "pinzas", 3, 1, 2, 1, 1, 1, 3, 1, 1, 1);
    Personaje arana = new Personaje("Spider", "arana", "escupitajo", 2, 1, 2, 1, 1, 1, 2, 3, 1, 1);

    Personaje[] grupo = new Personaje[4];
    Personaje[] grupomobs = new Personaje[4];
    Personaje gnomo = new Personaje("Javier", "Gnomo", "rastrillo", 1, 2, 2, 4, 2, 3, 1, 2, 2, 5);
    Personaje bossfinal = new Personaje("Ragnork", "BESTIA", "Martillo", 5, 5, 5, 4, 1, 3, 3, 3, 2, 4);

    Prueba grieta = new Prueba("Grieta", 2, 3);
    Prueba acertijo = new Prueba("Acertijo", 2, 1);
    Prueba fatiga = new Prueba("Fatiga", 1, 1);

    public Aventura() {
    }

    public void IniciarAventura() {

        Introduccion();
        ComienzoEvento();
        CrearProta();
        CrearGrupo();
        CrearGrupoMOBS();
        ComienzoEvento();
        DecisionCamino();
        ComienzoEvento();
        PrimeraLucha(grupo, grupomobs);
        ComienzoEvento();
        TomarDescanso();
        ComienzoEvento();
        ElAcertijo();
        ComienzoEvento();
        PeleaEnGrupo(grupo, bossfinal);
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

    public void Golpear(Personaje atacante, Personaje defensor) {
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
        System.out.println("Empezamos a caminar en la direccion que habiamos tomado, para nuestra sorpresa vemos una pequeña grieta la cual podiamos intentar saltar.\n");
        for (int i = 0; i < grupo.length; i++) {
            System.out.println(grupo[i].nombre + " intenta saltar la grieta");

            int exitos = LanzarDados(grupo[i].fuerza + grupo[i].destreza);
            System.out.println("Exitos: " + exitos);

            if (LanzarDados(grupo[i].fuerza + grupo[i].destreza) >= grieta.dificultad) {
                System.out.println("");
                System.out.println(grupo[i].nombre + " salta la grieta.");
            } else {
                System.out.println(grupo[i].nombre + " se cae a la grieta y sufre " + grieta.daño + " puntos de daño.");
            }
        }
    }

    public void CrearGrupo() {
        grupo[0] = prota;
        grupo[1] = ninfa;
        grupo[2] = minotauro;
        grupo[3] = escarabajo;
    }

    public void CrearGrupoMOBS() {
        grupomobs[0] = cienpies;
        grupomobs[1] = gusano;
        grupomobs[2] = termita;
        grupomobs[3] = arana;
    }

    public void PeleaAMuerte(Personaje personaje1, Personaje personaje2) {
        System.out.println("\n" + personaje1.nombre + " se va a pelear con " + personaje2.nombre);

        if (personaje1.vida > 0) {
            Golpear(personaje1, personaje2);
        }
        if (personaje2.vida > 0) {
            Golpear(personaje2, personaje1);
        }

        if (personaje1.vida > 0 && personaje2.vida <= 0) {
            System.out.println(personaje1.nombre + " ha ganado la pelea.");
        } else {
            System.out.println(personaje2.nombre + " ha ganado la pelea.");

        }
        if (escarabajo.vida > minotauro.vida) {
            System.out.println("Larvesta se levanta tras el combate y le dice al minotauro.\n");
            System.out.println("Larvesta: Minotauro no es necesario pelear, debemos proseguir nuestro camino");
            System.out.println("\n 'Le ayuda a levantarse.'");
        } else {
            System.out.println("Bob: Levanta insecto no eres rival para mí.");
            System.out.println("\n" + ninfa.nombre + " se acerca a " + escarabajo.nombre + " y lo cura");
            escarabajo.vida = escarabajo.vida + 1;
        }
    }

    public void DecisionCamino() {
        Scanner ScannerInt = new Scanner(System.in);

        System.out.println("Nuestros aventureros se están acercando a una bifurcación que deberían de hacer...\n");
        System.out.println(minotauro.nombre + " el " + minotauro.especie + " piensa que deberíamos de ir por el camino de la izquierda\n");
        System.out.println(escarabajo.nombre + " el " + escarabajo.especie + " piensa que deberíamos de ir por el camino de la derecha\n");
        System.out.println("¿A quién deberíamos de hacer caso?\n");

        System.out.println("Pulsa 1 para ir a la izquierda.");
        System.out.println("Pulsa 2 para ir a la derecha");

        int camino;
        camino = ScannerInt.nextInt();
        switch (camino) {
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

    public void ElAcertijo() {
        System.out.println("Llegando ya al tronco...");
        System.out.println("Nos encontramos con " + gnomo.nombre + " el " + gnomo.especie);
        System.out.println("Gnomo: No os dejaré pasar hasta que adivineis mi acertijo.");
        System.out.println("Estás escapando de un laberinto, y hay tres puertas frente a ti."
                + "\n La puerta de la izquierda conduce a un infierno. "
                + "\nLa puerta en el centro te lleva a un asesino mortal."
                + "\n La puerta de la derecha te conduce a un león que no ha comido en tres meses."
                + "\n ¿Qué puerta eliges?\n");

        for (int i = 0; i < grupo.length; i++) {
            System.out.println(grupo[i].nombre + " intenta el acertijo");

            int exitos = LanzarDados(grupo[i].inteligencia + grupo[i].astucia);
            System.out.println("Exitos: " + exitos);

            if (exitos >= acertijo.dificultad) {
                System.out.println("");
                System.out.println(grupo[i].nombre + " acierta el acertijo y lo dejan pasar.");
            } else {
                System.out.println(grupo[i].nombre + " falla la respuesta " + acertijo.daño + " puntos de daño con el " + gnomo.arma);
            }
        }

    }

    public void PrimeraLucha(Personaje[] grupo, Personaje[] grupomobs) {
        System.out.println("Consiguen llegar a la primera parte de nuestro tronco.");
        System.out.println("Pero en el camino derrepente aparecen diversos enemigos.");
        System.out.println("De la nada se avalanzan hasta nosotros tres criaturas eran:\n");

        System.out.println(cienpies.nombre + " el " + cienpies.especie);
        System.out.println(gusano.nombre + " el " + gusano.especie);
        System.out.println(termita.nombre + " la " + termita.especie);
        System.out.println(arana.nombre + " la " + arana.especie);

        System.out.println("\n El grupo de aventureros se dispone a luchar contra los bichos");

        int mobRecibePega = grupomobs.length - 1;
        int perRecibe = 0;
        while (grupo[perRecibe].vida > 0 && grupomobs[mobRecibePega].vida > 0) {
            for (int i = 0; i < grupo.length; i++) {
                if (grupo[i].vida > 0 && grupomobs[mobRecibePega].vida > 0) {
                    Golpear(grupo[i], grupomobs[mobRecibePega]);
//                  Golpear(grupomobs[i], grupo[i]);
                }
                if (grupomobs[mobRecibePega].vida > 0 && grupo[perRecibe].vida > 0) {
                    Golpear(grupomobs[mobRecibePega], grupo[perRecibe]);
                }
                if (grupo[perRecibe].vida > 0 && grupomobs[mobRecibePega].vida <= 0) {
                    System.out.println(grupo[i].nombre + " ha ganado la pelea.");
                    System.out.println(grupomobs[mobRecibePega].nombre + " HA MUERTO");
                }
                if (grupo[perRecibe].vida <= 0 && grupomobs[mobRecibePega].vida > 0) {
                    System.out.println(grupomobs[mobRecibePega].nombre + " ha ganado la pelea.");
                    System.out.println(grupo[perRecibe].nombre + " HA MUERTO");
                }
                if (grupomobs[mobRecibePega].vida <= 0 && mobRecibePega > 0) {
                    mobRecibePega--;
                }
                if (grupo[perRecibe].vida <= 0 && perRecibe < 3) {
                    perRecibe++;
                }
            }
        }
    }

    public void PeleaEnGrupo(Personaje[] grupo, Personaje finals) {
        System.out.println("Después de una larga travesia nuestro grupo exausto llega a la copa del arbol.");
        System.out.println("Lo que no sabían es que les esperaba una horrible criatura indescriptible para los ojos de nuestros protagonistas,");
        System.out.println("\nEl grupo de aventureros se dispone a enfrentarse a " + finals.nombre);
        System.out.println(prota.nombre + " levanta su " + prota.arma + "y se dispone a luchar.");

        int objetivo = grupo.length - 1;  //4
        while (grupo[0].vida > 0 && finals.vida > 0) {
            for (int i = 0; i < grupo.length; i++) {
                if (grupo[i].vida > 0) {
                    Golpear(grupo[i], finals);
                }
            }
            if (finals.vida > 0) {
                Golpear(finals, grupo[objetivo]); //grupo[4];
                if (grupo[objetivo].vida <= 0) {
                    objetivo--;
                }
            }
        }
        if (finals.vida <= 0) {
            System.out.println("\nEl grupo ha ganado la pelea, ha derrotado a " + finals.nombre);
            System.out.println("El grupo orgulloso levanta el martillo y desaparecen de aquel lugar magicamente...");
        } else {
            System.out.println("\n" + finals.nombre + " ha vencido al grupo. El martillo de la esperanza se desvanece.");
            System.out.println("Ya que no existia esperanza ni para " + finals.nombre + "ni para nuestros aventureros.");
        }
    }

    public void ComienzoEvento() {
        System.out.println("\n---------------------------------------------------\n");
    }

    public void TomarDescanso() {
        Scanner ScannerInt = new Scanner(System.in);
        System.out.println("Nuestros heroes depsues de la ultima pelea se ven cansados\n");

        System.out.println("Pulsa 1 para proponer descansar un rato y recuperar fuerzas.");
        System.out.println("Pulsa 2 para continuar total ya estamos al lado.\n");

        int descanso;
        descanso = ScannerInt.nextInt();
        switch (descanso) {
            case 1:
                System.out.println("Todos toman un descanso y te lo agradecen.");
                for (int i = 0; i < grupo.length; i++) {
                    System.out.println(grupo[i].nombre + " obtiene un punto de vida.");
                    grupo[i].fuerza = grupo[i].fuerza + 1; 
                    System.out.println("La fatiga a desaparecido");
                }
                break;

            case 2:
                System.out.println("Has decidido no tomar el descanso.");
                for (int i = 0; i < grupo.length; i++) {
                    System.out.println(grupo[i].nombre + " comienza a tener fatiga");

                    int exitos = LanzarDados(grupo[i].fuerza + grupo[i].compostura);
                    System.out.println("Exitos: " + exitos);

                    if (LanzarDados(grupo[i].fuerza + grupo[i].compostura) >= fatiga.dificultad) {
                        System.out.println("");
                        System.out.println(grupo[i].nombre + " no se cansa demasiado se recupera rapidamente.");
                    } else {
                        System.out.println(grupo[i].nombre + " se cae al suelo del agotamiento sufre" + fatiga.daño + " puntos de daño.");
                    }
                }
                break;

        }
    }
}
