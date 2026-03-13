package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.MenuType;
import miscs.Menu;
import models.Entry;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Entry> entries = new ArrayList<>();
        int userInput = -1;

        Menu.printWelcome();

        do {
            userInput = Menu.readChoice(scanner, MenuType.MAIN);
            
            if (userInput == 1) {
                Entry entry = Entry.createEntry(scanner);
                entries.add(entry);
                System.out.println(entry.toString());
            } else if(userInput == 2) {
                if(!entries.isEmpty()) {
                    System.out.println("***Lista de registros***");
                    entries.forEach(System.out::println);
                } else {
                    System.out.println("No hay registros que mostrar.");
                }
            } else if(userInput == 3) { 
                final boolean isEntriesEmpty = Entry.isEmpty(entries, "No existen registros para eliminar.");

                if(!isEntriesEmpty) {
                    Entry.deleteEntry(scanner, entries);
                }

            } else if(userInput == 4) {
                final boolean isEntriesEmpty = Entry.isEmpty(entries, "No existen registros para buscar.");

                if(!isEntriesEmpty) {
                    System.out.println("");
                    System.out.println("Ingresa el monto referencial para buscar");

                    List<Entry> filteredEntries = Entry.searchEntriesByAmount(entries, scanner);

                    if(filteredEntries.isEmpty()) {
                        System.out.println("No hay registros que cumplan con el criterio de búsqueda");
                    } else {
                        filteredEntries.forEach(System.out::println);
                    }
                }
            }

        } while(userInput != 0);


        scanner.close();        
    }

}
