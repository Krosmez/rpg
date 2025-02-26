package utils;

import Personnage.MainCharacter;

public class BattleBehavior {
    public static String combat(MainCharacter player1, MainCharacter player2) {
        int pv1 = player1.getPv();
        int pv2 = player2.getPv();
        int magie1 = player1.getMagie();
        int magie2 = player2.getMagie();
        String stuff1;
        String stuff2;
        int attaque1;
        int attaque2;

        while (pv1 > 0 && pv2 > 0) {
            boolean hasStuff1 = player1.getStuff() != null;
            boolean hasStuff2 = player2.getStuff() != null;
            boolean isMage1 = player1.getClassOfCombat().equalsIgnoreCase("mage");
            boolean isMage2 = player2.getClassOfCombat().equalsIgnoreCase("mage");
            boolean hasMagie1 = player1.getMagie() > 0;
            boolean hasMagie2 = player2.getMagie() > 0;

            if (hasStuff1 && (!isMage1 || hasMagie1)) {
                attaque1 = player1.attaqueAvecArme(player1.getStuff());
                stuff1 = player1.getStuff().name;
            } else {
                attaque1 = player1.attaqueSansArme();
                stuff1 = "combat à main nue";
            }


            if (hasStuff2 && (!isMage2 || hasMagie2)) {
                attaque2 = player2.attaqueAvecArme(player2.getStuff());
                stuff2 = player2.getStuff().name;
            } else {
                attaque2 = player2.attaqueSansArme();
                stuff2 = "combat à main nue";
            }


            int defense1 = player1.defense();
            int defense2 = player2.defense();

            int degats1 = attaque2 - defense1;
            int degats2 = attaque1 - defense2;

            if (degats1 < 0) {
                degats1 = 0;
            }

            if (degats2 < 0) {
                degats2 = 0;
            }

            magie1 -= player1.stuff.manaCost;
            magie2 -= player2.stuff.manaCost;
            player1.setMagie(magie1);
            player2.setMagie(magie2);

            pv1 -= degats1;
            pv2 -= degats2;
            player1.setPv(pv1);
            player2.setPv(pv2);

            if (pv1 <= 0 && pv2 <= 0) {
                System.out.println("Les deux joueurs sont morts");
            } else if (pv1 <= 0) {
                 System.out.println(player2.getName() + " a gagné");
            } else if (pv2 <= 0) {
                 System.out.println(player1.getName() + " a gagné");
            } else {
                System.out.println(player1.getName() + " utilise " + stuff1 + " : " + player1.getPv() + " pv" +
                        " | " + player1.getMagie() + " magie");

                System.out.println(player2.getName() + " utilise " + stuff2 + " : " + player2.getPv() + " pv" +
                        " | " + player2.getMagie() + " magie");

                System.out.println("Le combat continue");

                System.out.println("_______________________");
            }
        }
        return "Fin du combat";
    }
}
