package Bataille;

import Stuff.BaseStuff;

public interface ICombat {

    int attaqueAvecArme(BaseStuff stuff);
    int attaqueSansArme();
    int defense();
}
