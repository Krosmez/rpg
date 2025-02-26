package Classe;

import Personnage.MainCharacter;
import Stuff.BaseStuff;

public class Guerrier extends MainCharacter {

    public Guerrier(String name, int pv, BaseStuff stuff) {
        this.name = name;
        this.pv = pv;
        degatsDeBase = 10;
        magie = 0;

        this.stuff = stuff;
        this.classOfCombat = "guerrier";
    }

    @Override
    public int attaqueAvecArme(BaseStuff stuff) {
        if(stuff.type.equalsIgnoreCase("melee")) {
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
