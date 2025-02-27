package Story;

import Personnage.Guerrier;
import Personnage.MainCharacter;
import utils.CharacterCreator;

public class Start {

    public void start() {
        System.out.println("Welcome to the world of Eldoria!");
        System.out.println("In this land, heroes are born and legends are made.");
        System.out.println("Your journey begins now. Choose your path wisely.");

        // Create a character
        MainCharacter character = CharacterCreator.createCharacter();

        // Start the adventure
        if (character != null) {
            System.out.println("Your adventure begins, " + character.getName() + "!");
            // Add more story elements and game logic here
            MainCharacter cypryMonster = new Guerrier("CypryMonster", null);
            ChapterOne.chapterOne(character, cypryMonster);
        } else {
            System.out.println("Character creation failed. Please restart the game.");
        }
    }
}
