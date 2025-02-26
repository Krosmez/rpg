package Classe;

import Personnage.MainCharacter;
import Stuff.BaseStuff;

public class Mage extends MainCharacter{
    public Mage(String name, int pv, BaseStuff stuff) {
        this.name = name;
        this.pv = pv;
        degatsDeBase = 10;
        magie = 5;

        this.stuff = stuff;
    }

    @Override
    public int attaqueAvecArme(BaseStuff stuff) {
        if(stuff.type.equalsIgnoreCase("magie")) {
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
