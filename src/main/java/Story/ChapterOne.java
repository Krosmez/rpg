package Story;

import Personnage.Personnage;

import java.util.Scanner;

import static utils.BattleBehavior.combat;

public class ChapterOne {
    public static void chapterOne(Personnage character, Personnage cypryMonster) {
        System.out.println("Chapter One: The beginning of your journey");
        System.out.println("You encounter a CypryMonster.");
        combat(character, cypryMonster);

        if(character.getPv() > 0) {
            System.out.println("You defeated the CypryMonster!");
            System.out.println("A Druid is on your path and propose you a weird potion. Do you want to drink it ? (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if(choice.equals("yes")) {
                System.out.println("You drink the potion and feel stronger.");
                character.setPv(character.getPv() + 30);
                System.out.println("Your health is now " + character.getPv());
            } else {
                System.out.println("The Druid feel sad and leave you here.");
            }
            // Add more story elements and game logic here

        } else {
            System.out.println("You were defeated by the CypryMonster.");
            System.out.println("Game Over loser.");
        }
    }
}
