//Universidad del valle de Guatemala - POO - Mauricio Montenegro - 23679
// Lab 1 - El objetivo de este programa es crear un juego en el cual sea basado en dados.
import java.util.Random;
import java.util.Scanner;
class Dado {
    private int numCaras;

    public Dado(int numCaras) {
        this.numCaras = numCaras;
    }

    public int lanzar() {
        Random rand = new Random();
        return rand.nextInt(numCaras) + 1;
    }
}
class Jugador {
    private int puntajeTotal;

    public Jugador() {
        puntajeTotal = 0;
    }
    public void tirarDado(Dado dado) {
        int tiro = dado.lanzar();

        if (tiro == 1) {
            puntajeTotal = 0;
            System.out.println("¡Has sacado un 1! Puntaje reiniciado.");
        } else {
            puntajeTotal += tiro;
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
