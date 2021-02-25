/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_jeu_trinome;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hugop
 */
public class Projet_Jeu_Trinome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        gestion_Partie();
    }

    public static void gestion_Partie() throws IOException {
        Player player1 = new Player("zebi",1);
        Player player2 = new Player("zebi",2);
        Echequier echequier = new Echequier(player1, player2);
        Scanner sc = new Scanner(System.in);
        System.out.println("Charger ? O/N");
        String rep = sc.nextLine();
        
        if (rep.equals("n")){
        echequier.create_Piece();
        echequier.affichage_tab();
        }
        if (rep.equals("o")){       
        echequier.charger();
        echequier.affichage_tab();
        }
        
        boolean end = false;
        boolean j1 = false;
        boolean j2 = false;
        while (end == false) {
            String[] piece_on_echiquier = new String[1];
            int compteur = 0;
            
            System.out.println("Que voulez-vous faire ? J pour Jouer, Q pour Quitter");
            rep = sc.nextLine();
//            if ("J".equals(rep) ||"j".equals(rep)) {
            if (!end){
                while(!j1){
                    System.out.println("Tour du joueur vert.");
                    int[] resultat = ask(sc);
                    int x = resultat[0];
                    int y = resultat[1];
                    int x2 = resultat[2];
                    int y2 = resultat[3];

                    j1 = player1.Game(echequier, x, y, x2, y2);
                    j2=false;
                }
                echequier.affichage_tab();
                if(player1.getWin()){
                    j2 = true;
                    System.out.println("Le joueur vert a gagné, félicitation bg.");
                    System.out.println("Fermeture du programme");
                    end = true;
                }
                while(!j2){
                    System.out.println("Tour du joueur rouge.");
                    int[] resultat = ask(sc);
                    int x = resultat[0];
                    int y = resultat[1];
                    int x2 = resultat[2];
                    int y2 = resultat[3];

                    j2 = player2.Game(echequier, x, y, x2, y2);
                    j1=false;
                }
                echequier.affichage_tab();
                if(player2.getWin()){
                    j1 = true;
                    System.out.println("\nLe joueur vert a gagné, félicitation bg.");
                    System.out.println("Fermeture du programme.");
                    end = true;
                }

            }
            if ("Q".equals(rep)||"q".equals(rep)) {
                System.out.println("Fermeture du programme");
                echequier.sauvegarder();
                end = true;
            }

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
