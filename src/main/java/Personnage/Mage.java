package Personnage;

import Stuff.BaseStuff;

public class Mage extends Personnage {
    public Mage(String name, int pv, BaseStuff stuff) {
        this.name = name;
        this.pv = pv;
        this.stuff = stuff;
        this.classOfCombat = "mage";

        degatsDeBase = 10;
        magie = 5;
    }

    @Override
    public int attaqueAvecArme(BaseStuff stuff) {
        if (stuff.type.equalsIgnoreCase("magie")) {
            if (magie > 0) {
                magie -= stuff.manaCost;
            }
            return stuff.degats + degatsDeBase;
        } else {
            return degatsDeBase;
        }
    }

    @Override
    public int attaqueSansArme() {
        return degatsDeBase;
    }

    @Override
    public int defense() {
        return 0;
    }
}
