package utils;

import Personnage.Guerrier;
import Personnage.MainCharacter;
import Stuff.BaseStuff;

import java.util.Scanner;

import static utils.SortCreator.createSort;
import static utils.StuffCreator.createStuff;

public class CharacterCreator {

    public static MainCharacter createCharacter() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String type = null;
        MainCharacter character = null;

        System.out.println("Enter character name:");
        String name = scanner.nextLine();

        choice = getChoice(choice, scanner);
        type = getCharacterType(choice, type);
        BaseStuff stuff = null;

        if (choice == 2) {
            stuff = createSort();
        } else {
            stuff = createStuff();
        }

        character = getMainCharacter(type, character, name, stuff);

        return character;
    }

    private static MainCharacter getMainCharacter(String type, MainCharacter character, String name, BaseStuff stuff) {
        if (type != null) {
            switch (type) {
                case "Guerrier" -> character = new Guerrier(name, stuff);
                case "Mage" -> {
                    // character = new Mage(name, stuff); // Uncomment and implement Mage class
                }
                case "Archer" -> {
                    // character = new Archer(name, stuff); // Uncomment and implement Archer class
                }
            }
        }
        return character;
    }

    private static int getChoice(int choice, Scanner scanner) {
        while (choice < 1 || choice > 3) {
            System.out.println("Choose a class:");
            System.out.println("1. Guerrier");
            System.out.println("2. Mage");
            System.out.println("3. Archer");
            System.out.print("Enter your choice (1-3): ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return choice;
    }

    private static String getCharacterType(int choice, String type) {
        if (choice == 1) {
            type = "Guerrier";
        } else if (choice == 2) {
            type = "Mage";
        } else if (choice == 3) {
            type = "Archer";
        }
        return type;
    }

}