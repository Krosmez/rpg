package Personnage;

import Bataille.ICombat;
import Stuff.BaseStuff;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MainCharacter implements ICombat {
    public String name;
    public int pv;
    protected int magie;
    public int degatsDeBase = 0;

    public BaseStuff stuff;
}
