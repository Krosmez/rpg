package Story;

import Personnage.MainCharacter;

import static utils.BattleBehavior.combat;

public class ChapterOne {
    public static void chapterOne(MainCharacter character, MainCharacter cypryMonster) {
        System.out.println("Chapter One: The beginning of your journey");
        System.out.println("Your encounter a CypryMonster.");
        combat(character, cypryMonster);
    }
}
