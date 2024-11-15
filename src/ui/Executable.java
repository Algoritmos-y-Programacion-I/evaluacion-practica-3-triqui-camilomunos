package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {
        flag = false;

        while (!flag) {
            System.out.println("\n\nBienvenido al menú:\n");
            System.out.println("Opciones:\n" 
                    + "1. Imprimir tablero \n" 
                    + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" 
                    + "4. Verificar ganador \n" 
                    + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.out.println("Gracias por jugar. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("Ingrese la fila (0, 1 o 2): ");
        int fila = reader.nextInt();
        System.out.println("Ingrese la columna (0, 1 o 2): ");
        int columna = reader.nextInt();

        boolean jugadaValida = cont.jugadaHumano(fila, columna);
        if (jugadaValida) {
            System.out.println("Jugada realizada con éxito.");
        } else {
            System.out.println("La casilla está ocupada o las coordenadas son inválidas. Intente de nuevo.");
        }
        imprimirTablero();
    }

    private void validarGanador() {
        String ganador = cont.verificarGanador();
        if (ganador.equals("Ninguno")) {
            System.out.println("No hay ganador aún.");
        } else {
            System.out.println("El ganador es: " + ganador);
        }
    }
}
