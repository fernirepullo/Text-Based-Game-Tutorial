package AdventureTextBasedTutorial;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Objetos del sistema

        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();

        // Variables del juego

        String[] enemigos = {"Esqueleto", "Snake", "Guerrero", "Dragon"};

        int vidaEnemigo = 0;

        int maxVidaEsq = 75;
        int maxVidaSna = 50;
        int maxVidaGue = 100;
        int maxVidaDra = 250;

        int maxAtaEsq = 30;
        int maxAtaSna = 20;
        int maxAtaGue = 55;
        int maxAtaDrag = 80;


        // Variables del jugador

        int vidaJugador = 120;
        int manaJugador = 100;
        int ataqueJugador = 40;
        int pociones = 4;

        int healthPotionHealAmount = 40;
        int healthPotionDropChance = 50; // Porcentaje de posibilidad de un enemigo de soltar una poción

//        String[] nombreMagia = {"Pyro", "Cryo", "Electro"};
//        int magDamagePyro = 150;
//        int costeMagiaPyro = 40;
//
//        int magDamageCryo = 100;
//        int costeMagiaCryo = 25;
//
//        int magDamageElectro = 120;
//        int costeMagiaElectro = 30;

        boolean running = true;

        System.out.println("¡Bienvenido a la mazmorra!");


        GAME:
        while (running) {

            System.out.println("----------------------------------------------------");

            String enemy = enemigos[rand.nextInt(enemigos.length)];

            if (enemy.equals("Esqueleto")) {

                vidaEnemigo = rand.nextInt(maxVidaEsq);
            }

            if (enemy.equals("Snake")) {

                vidaEnemigo = rand.nextInt(maxVidaSna);
            }

            if (enemy.equals("Guerrero")) {

                vidaEnemigo = rand.nextInt(maxVidaGue);
            }

            else if(enemy.equals("Dragon")) {

                vidaEnemigo = rand.nextInt(maxVidaDra);
            }

            System.out.println("\t# " + enemy + " ha aparecido! #\n");
            //              Esqueleto ha aparecido! #

            while (vidaEnemigo > 0) {

                System.out.println("\tVida actual: " + vidaJugador);
                System.out.println("\t" + enemy + "'s HP: " + vidaEnemigo);
                System.out.println("\n Elija una opción");
                System.out.println("\t1. Atacar");
                System.out.println("\t2. Tomar una poción");
                System.out.println("\t3. Huir");

                System.out.print("Tu elección > ");
                String eleccion = userInput.nextLine();
                System.out.println("\t");


                if (eleccion.equals("1")){

                    int damageDealt = rand.nextInt(ataqueJugador);
                    int damageTaken;

                    if (enemy.equals("Esqueleto")){

                        damageTaken = rand.nextInt(maxAtaEsq);

                    }

                    else if (enemy.equals("Snake")){

                        damageTaken = rand.nextInt(maxAtaSna);
                    }

                    else if (enemy.equals("Guerrero")){

                        damageTaken = rand.nextInt(maxAtaGue);
                    }

                    else {

                        damageTaken = rand.nextInt(maxAtaDrag);

                    }

                    vidaEnemigo -= damageDealt;
                    vidaJugador -= damageTaken;

                    System.out.println("\t > Has atacado al enemigo " + enemy + " y le has hecho " + damageDealt + " de daño!");
                    System.out.println("\t > El enemigo " + enemy + " te ha atacado y has recibido " + damageTaken + " de daño! \t");

                    if (vidaJugador < 1){

                        System.out.println("\t\n ¡Han acabado contigo! ¡Sigue entrenando y vuelve a intentarlo!\n");
                        break GAME;
                    }

                }

                else if (eleccion.equals("2")){

                    if (pociones > 0){

                        vidaJugador += healthPotionHealAmount;
                        pociones --;

                        System.out.println("Has usado una poción y te has curado + " + healthPotionHealAmount + " puntos de vida \n\t " +
                                "> Ahora tienes " + vidaJugador + " puntus de vida y te quedan " + pociones + " pociones disponibles. \n");
                    }

                    else {

                        System.out.println("\t No te quedan pociones disponibles. Derrota enemigos para obtener pociones.");
                    }

                }

                else if (eleccion.equals("3")) {

                    System.out.println("\t Has escapado del " + enemy + "!");

                    continue GAME;
                }

                else {

                    System.out.println("Número inválido");
                }

                if(vidaJugador < 1){

                    System.out.println("Eres demasiado débil para seguir");
                    break;
                }

            }

            System.out.println("----------------------------------------------------");
            System.out.println(" # " + enemy + " ha sido derrotado! ");
            System.out.println(" # Tienes " + vidaJugador + " puntos de vida restantes");

            if(rand.nextInt(100) < healthPotionDropChance){

                pociones++;
                System.out.println(" # El enemigo " + enemy + " ha soltado una poción! # ");
                System.out.println(" # Tienes " +  pociones + " pociones disponibles # ");

            }

            System.out.println("----------------------------------------------------");
            System.out.println("¿Cuál es tu siguiente movimiento?");
            System.out.println("1. Seguir jugando");
            System.out.println("2. Salir de la mazmorra");

            String eleccionFinal = userInput.nextLine();

            while(!eleccionFinal.equals("1") && !eleccionFinal.equals("2")){

                System.out.println("Elección errónea");
                eleccionFinal = userInput.nextLine();
            }

            if (eleccionFinal.equals("1")){

                System.out.println("Sigues adentrándote en la mazmorra.");
            }

            else {

                System.out.println("Has salido de la mazmorra \t");
                break;
            }
        }

        System.out.println("########################################");
        System.out.println("# GRACIAS POR JUGAR #");
        System.out.println("########################################");
    }
}
