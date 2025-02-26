package org.example;

import Classe.Archer;
import Classe.Guerrier;
import Classe.Mage;
import Personnage.MainCharacter;
import Stuff.Sort.FireBall;
import Stuff.Weapon.Arc;
import Stuff.Weapon.Sword;
import utils.BattleBehavior;

public class Main {
    public static void main(String[] args) {

        MainCharacter personnage1 = new Archer("Archer", 100, new Arc());
        MainCharacter personnage2 = new Mage("Mage", 100, new FireBall());

        BattleBehavior.combat(personnage1, personnage2);
    }
}