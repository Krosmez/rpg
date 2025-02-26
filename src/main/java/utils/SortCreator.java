package utils;

import Stuff.BaseStuff;
import Stuff.Sort.FireBall;
import Stuff.Sort.Heal;
import lombok.Getter;

import java.util.Scanner;

public class SortCreator {

    public enum SortType {
        FIREBALL(1, "Boule de feu", FireBall.class),
        HEAL(2, "Soin", Heal.class);

        @Getter
        private final int choice;
        @Getter
        private final String name;
        private final Class<? extends BaseStuff> clazz;

        SortType(int choice, String name, Class<? extends BaseStuff> clazz) {
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

        public static SortCreator.SortType fromChoice(int choice) {
            for (SortCreator.SortType type : values()) {
                if (type.getChoice() == choice) {
                    return type;
                }
            }
            return null;
        }
    }

    public static BaseStuff createSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a spell:");
        for (SortCreator.SortType type : SortCreator.SortType.values()) {
            System.out.println(type.getChoice() + ". " + type.getName());
        }
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();

        SortCreator.SortType selectedType = SortCreator.SortType.fromChoice(choice);
        if (selectedType != null) {
            return selectedType.createInstance();
        } else {
            System.out.println("Invalid choice. No spell selected.");
            return null;
        }
    }
}
