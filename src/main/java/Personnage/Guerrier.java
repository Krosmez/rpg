package Personnage;

import Stuff.BaseStuff;

public class Guerrier extends Personnage {

    public Guerrier(String name, BaseStuff stuff) {
        this.name = name;
        this.stuff = stuff;
        this.classOfCombat = "guerrier";

        pv = 100;
        degatsDeBase = 10;
        magie = 0;
    }

    @Override
    public int attaqueAvecArme(BaseStuff stuff) {
        if (stuff.type.equalsIgnoreCase("melee")) {
            return stuff.degats + degatsDeBase;
        } else if (stuff.type.equalsIgnoreCase("distance")) {
            return degatsDeBase;
        } else {
            return 0;
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
