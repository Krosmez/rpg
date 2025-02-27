package Stuff;

public class Sword extends BaseStuff {
    public Sword(String name, String type, int degats, int defense, int manaCost) {
        this.name = name;
        this.type = type;
        this.degats = degats;
        this.defense = defense;
        this.manaCost = manaCost;
    }

    public Sword() {
        this.name = "Epee";
        this.type = "Melee";
        this.degats = 10;
        this.defense = 0;
        this.manaCost = 0;
    }
}
