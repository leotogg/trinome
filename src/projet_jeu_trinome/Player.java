/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_jeu_trinome;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leoto
 */
public class Player {
    private ArrayList<Piece> listPiece = new ArrayList<>();
    private String nom;
    private String couleur;
    
    public Player(String nom, int nb){
        this.nom = nom;
        if (nb == 1){
            couleur = "verte";
        }else{
            couleur = "rouge";
        }
    }
    public void ajoutPiece(Piece piece){
        listPiece.add(piece);
    }
    public boolean verfifList(Piece piece){
        return listPiece.contains(piece);
    }
    public void remove(Piece piece){
        listPiece.remove(piece);
    }
    public void Game(Echequier echequier, int x, int y, int x2, int y2){
        if (listPiece.contains(echequier.getCase(x, y))){
            System.out.println(echequier.moves(x, y, x2, y2));
        }else{
            System.out.println("La piece ne vous appartient pas.");
        }
                
    }
}


