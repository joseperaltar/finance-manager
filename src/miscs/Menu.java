package miscs;

import java.util.InputMismatchException;
import java.util.Scanner;

import enums.MenuType;

public class Menu {
    private Menu() {
        /* This utility class should not be instantiated */
    }

    public static void printWelcome() {
        System.out.println("***Bienvenido***");
        System.out.println("Ingresa una opción del menú");
    }

    public static int readChoice(Scanner scanner, MenuType menu) {
        int userInput = -1;

        while (!menu.isValid(userInput)) {
            try {
                System.out.println(menu.getOptions());
                System.out.print("> ");
                userInput = scanner.nextInt();
                if(!menu.isValid(userInput)) {
                    System.out.println("ERROR: Opción fuera de rango");
                }

            } catch(InputMismatchException e) {
                System.out.println("ERROR: Debes ingresar un número");  
                scanner.next(); // Línea para limpiar buffer.
                userInput = -1;
            }
        }

        return userInput;
    }
}
