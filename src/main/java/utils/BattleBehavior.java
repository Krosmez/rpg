package utils;

import Personnage.MainCharacter;

public class BattleBehavior {
    public static String combat(MainCharacter player1, MainCharacter player2) {
        int pv1 = player1.getPv();
        int pv2 = player2.getPv();

        while (pv1 > 0 && pv2 > 0) {
            boolean hasStuff1 = player1.getStuff() != null;
            boolean hasStuff2 = player2.getStuff() != null;
            int attaque1 = hasStuff1 ? player1.attaqueAvecArme(player1.getStuff()) : player1.attaqueSansArme() ;
            int attaque2 = hasStuff2 ? player2.attaqueAvecArme(player2.getStuff()) : player2.attaqueSansArme() ;

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

            pv1 -= degats1;
            pv2 -= degats2;
            player1.setPv(pv1);
            player2.setPv(pv2);
            getEndOfTurn(player1, player2, pv1, pv2);
        }
        return "Fin du combat";
    }

    private static void getEndOfTurn(MainCharacter player1, MainCharacter player2, int pv1, int pv2) {
        if (pv1 <= 0 && pv2 <= 0) {
            System.out.println("Les deux joueurs sont morts");
        } else if (pv1 <= 0) {
             System.out.println(player2.getName() + " a gagné");
        } else if (pv2 <= 0) {
             System.out.println(player1.getName() + " a gagné");
        } else {
            System.out.println("Le combat continue");
        }
    }
}
