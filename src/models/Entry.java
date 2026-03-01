package models;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import enums.MenuType;
import miscs.Menu;

public class Entry {
    private boolean type;
    private float amount;
    private String description;

    public static Entry createEntry(Scanner scanner) {
        System.out.println("====================");
        System.out.println("CREACIÓN DE REGISTRO");
        System.out.println("Ingresa el tipo de registro");
        boolean type;
        int typeInput = Menu.readChoice(scanner, MenuType.ENTRY_TYPE);

        type = typeInput == 1;

        float amount = -1;
        while (amount == -1) {
            System.out.println("Ingresa el monto del registro");
            System.out.print("> ");
            try {
                amount = scanner.nextFloat();
                if(amount <= 0) {
                    amount = -1;
                    System.out.println("ERROR: Debes ingresar un monto mayor que 0");
                }
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Debes ingresar un número");
                amount = -1;
                scanner.next();
            }
        }
        
        scanner.nextLine(); // Línea para limpiar buffer.
        String description = "";
        
        while (description.equals("")) {
            System.out.println("Ingresa la descripción del registro (Máximo 20 caracteres)");
            System.out.print("> ");
            description = scanner.nextLine();
            if(description.length() > 20) {
                System.out.println(String.format("ERROR: Máximo 20 caracteres (%d)", description.length()));
                description = "";
            }
        }

        return new Entry(type, amount, description);
    }

    public static void deleteEntry(Scanner scanner, List<Entry> entries) {
        System.out.println("=================");
        System.out.println("Eliminar registro");
        int recordNumber = -1;
        do {
            System.out.println("Inserta el número del registro que quieras eliminar:");
            System.out.println("0. Salir\n");
            System.out.print("> ");
            try {
                recordNumber = scanner.nextInt();

                if(recordNumber < 0) {
                    recordNumber = -1;
                    System.out.println("ERROR: El número debe ser mayor que 0.");
                } else if(recordNumber > entries.size()) {
                    recordNumber = -1;
                    System.out.println("ERROR: El número de registro no existe en la lista.");
                }
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Debe ingresar un número");
                recordNumber = -1;
                scanner.next();
            }
        } while(recordNumber == -1);

        if(recordNumber > 0) {
            System.out.println("REGISTRO ELIMINADO CON EXITO");
            entries.remove(recordNumber - 1);
        } 
    }

    public Entry(boolean type, float amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean getType() {
        return type;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s | Monto: %,.2f | Descripción: %s", (type) ? "Ingreso" : "Egreso", amount, description);
    }
}
