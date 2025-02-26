package utils;

import Stuff.BaseStuff;
import Stuff.Weapon.Sword;
import Stuff.Weapon.Arc;
import Stuff.Weapon.Hache;
import lombok.Getter;

import java.util.Scanner;

public class StuffCreator {

    public enum WeaponType {
        SWORD(1, "Sword", Sword.class),
        BOW(2, "Bow", Arc.class),
        AXE(3, "Axe", Hache.class);

        @Getter
        private final int choice;
        @Getter
        private final String name;
        private final Class<? extends BaseStuff> clazz;

        WeaponType(int choice, String name, Class<? extends BaseStuff> clazz) {
            this.choice = choice;
            this.name = name;
            this.clazz = clazz;
        }

        public BaseStuff createInstance() {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create weapon instance", e);
            }
        }

        public static WeaponType fromChoice(int choice) {
            for (WeaponType type : values()) {
                if (type.getChoice() == choice) {
                    return type;
                }
            }
            return null;
        }
    }

    public static BaseStuff createStuff() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a weapon:");
        for (WeaponType type : WeaponType.values()) {
            System.out.println(type.getChoice() + ". " + type.getName());
        }
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();

        WeaponType selectedType = WeaponType.fromChoice(choice);
        if (selectedType != null) {
            return selectedType.createInstance();
        } else {
            System.out.println("Invalid choice. No weapon selected.");
            return null;
        }
    }
}