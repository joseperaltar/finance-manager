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
                if(entries.isEmpty()) {
                    System.out.println("***Lista de registros***");
                    entries.forEach(System.out::println);
                } else {
                    System.out.println("No hay registros que mostrar.");
                }
            }

        } while(userInput != 0);


        scanner.close();        
    }

}
