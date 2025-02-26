package Classe;

import Bataille.ICombat;
import Personnage.MainCharacter;
import Stuff.BaseStuff;

public class Sebastien extends MainCharacter implements ICombat {

    @Override
    public int attaqueAvecArme(BaseStuff stuff) {
        return 0;
    }

    @Override
    public int attaqueSansArme() {
        return 0;
    }

    @Override
    public int defense() {
        return 0;
    }
}
