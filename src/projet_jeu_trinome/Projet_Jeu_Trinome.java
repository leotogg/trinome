/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_jeu_trinome;

import java.util.Scanner;

/**
 *
 * @author hugop
 */
public class Projet_Jeu_Trinome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        gestion_Partie();
    }

    public static void gestion_Partie() {
        Player player1 = new Player("zebi",1);
        Player player2 = new Player("zebi",2);
        Echequier echequier = new Echequier(player1, player2);
        
        echequier.create_Piece();
        echequier.affichage_tab();
//        echequier.create_Echequier();
//        echequier.create_PiecesVerte();
//        echequier.create_PiecesRouge();
//        echequier.affichage_echequier();
        boolean end = false;
        while (end == false) {
            String[] piece_on_echiquier = new String[1];
            int compteur = 0;
            Scanner sc = new Scanner(System.in);
//            System.out.println("Que voulez-vous faire ? J pour Jouer, Q pour Quitter");
//            String rep = sc.nextLine();
//            if ("J".equals(rep) ||"j".equals(rep)) {
            if (!end){
                int x = ask(sc)[0];
                int y = ask(sc)[1];
                int x2 = ask(sc)[2];
                int y2 = ask(sc)[3];
                
                player1.Game(echequier, x, y, x2, y2);
                
                x = ask(sc)[0];
                y = ask(sc)[1];
                x2 = ask(sc)[2];
                y2 = ask(sc)[3];
                
                player2.Game(echequier, x, y, x2, y2);
//                System.out.println(echequier.moves(x, y, x2, y2));
//               
//                }
                echequier.affichage_tab();

            }
//            if ("Q".equals(rep)||"q".equals(rep)) {
//                System.out.println("Fermeture du programme");
//                end = true;
//            }

        }
    }
    public static int[] ask(Scanner sc){
        System.out.println("Coord x ?");
                int x = sc.nextInt();
                System.out.println("Coord y ?");
                int y = sc.nextInt();
                System.out.println("Nouveau x ?");
                int x2 = sc.nextInt();
                System.out.println("Nouveau y ?");
                int y2 = sc.nextInt();
                int[] resultat = {x, y, x2, y2};
        return resultat;
    }

}
