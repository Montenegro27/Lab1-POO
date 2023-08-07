//Universidad del valle de Guatemala - POO - Mauricio Montenegro - 23679
// Lab 1 - El objetivo de este programa es crear un juego en el cual sea basado en dados, el el cual los jugadores tendran oportunidades ilimitadas
// Pero si un jugador pasa de 20 puntos se le pasará el turno al siguiente, el jugador puede decidir cuando quiere dejar de tirar, si el dado
// Da el valor 1 se reinicia su puntaje y gana el primero en llegar a 100.
import java.util.Random;
import java.util.Scanner;
// Definición de la clase Dado que representa un dado con un número de caras especificado
class Dado {
    private int numCaras;

    public Dado(int numCaras) {
        this.numCaras = numCaras;
    }

    public int lanzar() {
        Random rand = new Random();
        return rand.nextInt(numCaras) + 1; // Genera un número aleatorio entre 1 y el número de caras
    }
}
// Definición de la clase Jugador que representa a un jugador del juego
class Jugador {
    private int puntajeTotal;

    public Jugador() {
        puntajeTotal = 0; // Inicia el puntaje total del jugador en 0
    }
    public void tirarDado(Dado dado) {
        int tiro = dado.lanzar(); // Lanza el dado y obtiene el valor del tiro

        if (tiro == 1) {
            puntajeTotal = 0; // Si el tiro es 1, se reinicia el puntaje del jugador
            System.out.println("¡Has sacado un 1! Puntaje reiniciado.");
        } else {
            puntajeTotal += tiro; // Suma el valor del tiro al puntaje total del jugador
        }

        System.out.println("Tiro de dado: " + tiro);
    }
    public int getPuntajeTotal() {
        return puntajeTotal;
    }
}
public class Pig {
    public static void main(String[] args) {
        Dado dado = new Dado(6);
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego PIG!");
        System.out.println("El objetivo es alcanzar 100 puntos.");
        System.out.println("Si sacas un 1, pierdes los puntos de ese turno.");
        System.out.println("Presiona Enter para comenzar...");

        scanner.nextLine();

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            System.out.println("Turno Jugador 1:");
            int opcion = 0;
            while (opcion != 2 && jugador1.getPuntajeTotal() < 100) {
                System.out.println("Presiona 1 para lanzar el dado o 2 para detenerte:");
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    jugador1.tirarDado(dado);
                    if (jugador1.getPuntajeTotal() >= 20) {
                        System.out.println("Puntaje actual Jugador 1: " + jugador1.getPuntajeTotal());
                        System.out.println("Has alcanzado 20 puntos en este turno. Turno finalizado.");
                        break;
                    } else {
                        System.out.println("Puntaje actual Jugador 1: " + jugador1.getPuntajeTotal());
                    }
                } else if (opcion == 2) {
                    break;
                }
            }
            System.out.println("Turno Jugador 2:");
            opcion = 0;
            while (opcion != 2 && jugador2.getPuntajeTotal() < 100) {
                System.out.println("Presiona 1 para lanzar el dado o 2 para detenerte:");
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    jugador2.tirarDado(dado);
                    if (jugador2.getPuntajeTotal() >= 20) {
                        System.out.println("Puntaje actual Jugador 2: " + jugador2.getPuntajeTotal());
                        System.out.println("Has alcanzado 20 puntos en este turno. Turno finalizado.");
                        break;
                    } else {
                        System.out.println("Puntaje actual Jugador 2: " + jugador2.getPuntajeTotal());
                    }
                } else if (opcion == 2) {
                    break;
                }
            }

            if (jugador1.getPuntajeTotal() >= 100 || jugador2.getPuntajeTotal() >= 100) {
                juegoTerminado = true;
            }
        }
        System.out.println("¡Fin del juego!");

        if (jugador1.getPuntajeTotal() >= 100 && jugador2.getPuntajeTotal() < 100) {
            System.out.println("¡Jugador 1 gana!");
        } else if (jugador2.getPuntajeTotal() >= 100 && jugador1.getPuntajeTotal() < 100) {
            System.out.println("¡Jugador 2 gana!");
        } else {
            System.out.println("¡Empate!");
        }
        scanner.close();
    }
}
