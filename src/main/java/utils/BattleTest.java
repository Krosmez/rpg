package utils;

import Personnage.MainCharacter;
import java.util.Scanner;

public class BattleTest {

    public static void battle(MainCharacter player, MainCharacter monster) {
        Scanner scanner = new Scanner(System.in);
        while (player.getPv() > 0 && monster.getPv() > 0) {
            System.out.println("Choose your action: 1. Attack 2. Defend 3. Use Magic");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playerAttack(player, monster);
                    break;
                case 2:
                    playerDefend(player);
                    break;
                case 3:
                    playerUseMagic(player, monster);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            if (monster.getPv() > 0) {
                monsterAttack(monster, player);
            }
            displayStatus(player, monster);
        }
        scanner.close();
        System.out.println("Battle ended.");
    }

    private static void playerAttack(MainCharacter player, MainCharacter monster) {
        int damage = player.attaqueSansArme();
        monster.setPv(monster.getPv() - damage);
        System.out.println(player.getName() + " attacks " + monster.getName() + " for " + damage + " damage.");
    }

    private static void playerDefend(MainCharacter player) {
        System.out.println(player.getName() + " defends.");
        // Implement defense logic here
    }

    private static void playerUseMagic(MainCharacter player, MainCharacter monster) {
        if (player.getMagie() > 0) {
            int magicDamage = player.getMagie();
            monster.setPv(monster.getPv() - magicDamage);
            player.setMagie(player.getMagie() - 10); // Example magic cost
            System.out.println(player.getName() + " uses magic on " + monster.getName() + " for " + magicDamage + " damage.");
        } else {
            System.out.println(player.getName() + " has no magic left.");
        }
    }

    private static void monsterAttack(MainCharacter monster, MainCharacter player) {
        int damage = monster.attaqueSansArme();
        player.setPv(player.getPv() - damage);
        System.out.println(monster.getName() + " attacks " + player.getName() + " for " + damage + " damage.");
    }

    private static void displayStatus(MainCharacter player, MainCharacter monster) {
        System.out.println(player.getName() + ": " + player.getPv() + " PV, " + player.getMagie() + " Magic");
        System.out.println(monster.getName() + ": " + monster.getPv() + " PV");
    }
}