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
            System.out.println("Que voulez-vous faire ? J pour Jouer, Q pour Quitter");
            String rep = sc.nextLine();
            if ("J".equals(rep) ||"j".equals(rep)) {
                
                System.out.println("Coord x ?");
                int x = sc.nextInt();
                System.out.println("Coord y ?");
                int y = sc.nextInt();
                System.out.println("Nouveau x ?");
                int x2 = sc.nextInt();
                System.out.println("Nouveau y ?");
                int y2 = sc.nextInt();
                System.out.println(echequier.moves(x, y, x2, y2));
//                echequier.
//                echequier.setTab(x, y, x2, y2);
                
//                System.out.println("Vous souhaitez déplacer un(e) " + piece_wanted);

//                System.out.println("Quelle pièce souhaitez vous déplacer ?");
//                String piece_wanted = sc.nextLine();
//                System.out.println("Vous souhaitez déplacer un(e) " + piece_wanted);
//
//                if (piece_wanted.equals("0")) {
//                    System.out.println("Pourquoi vouloir déplacer une pièce qui n'existe pas gros débile ? \n");
//                } else {
//                    for (int ligne = 0; ligne < echequier.getEchequier().length; ligne++) {
//                        for (int colone = 0; colone < echequier.getEchequier().length; colone++) {
//                            if (piece_wanted.equals(echequier.getEchequier()[ligne][colone])) {
//                                System.out.println("Votre pièce " + piece_wanted + " est sur l'échéquier, à la case (" + ligne + "," + colone + ")");
//                                piece_on_echiquier[compteur] = echequier.getEchequier()[ligne][colone];
//                                compteur = compteur + 1;
//                            }
//
//                        }
//                    }
//                    System.out.println("Vous souhaitez déplacer " + piece_on_echiquier[0] + ", Indiquez les nouvelles coordonées (ligne, colonne) de " + piece_on_echiquier[0]);
//                    int ligne_piece = sc.nextInt();
//                    int colonne_piece = sc.nextInt();
//                    System.out.println("Vous souhaitez déplacer " + piece_on_echiquier[0] + " aux coordonées (" + ligne_piece + "," + colonne_piece + ")");
//                    System.out.println("\n Déplacement... \n");
//                    boolean move_done = false;
//                    // Appel de la fonction déplacement
//                    for (int ligne = 0; ligne < echequier.getEchequier().length; ligne++) {
//                        for (int colone = 0; colone < echequier.getEchequier().length; colone++) {
//
//                            if (echequier.getEchequier()[ligne][colone].equals(piece_on_echiquier[0]) && move_done == false) {
//                                echequier.getEchequier()[ligne_piece][colonne_piece] = echequier.getEchequier()[ligne][colone];
//                                echequier.getEchequier()[ligne][colone] = "0";
//                                move_done = true;
//                            }
//
//                        }
//                    }
//
//                    // Actualisation de l'échéquier
////                    echequier.affichage_echequier();
//                }
                echequier.affichage_tab();

            }
            if ("Q".equals(rep)||"q".equals(rep)) {
                System.out.println("Fermeture du programme");
                end = true;
            }

        }
    }

}
