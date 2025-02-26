package org.example;

import Classe.Guerrier;
import Personnage.MainCharacter;
import Stuff.Weapon.Sword;
import utils.BattleBehavior;

public class Main {
    public static void main(String[] args) {

        MainCharacter personnage1 = new Guerrier("Guerrier Folichon", 100, null);
        MainCharacter personnage2 = new Guerrier("Guerrier Avec une grosse epee", 100, new Sword());

        BattleBehavior.combat(personnage1, personnage2);
    }
}