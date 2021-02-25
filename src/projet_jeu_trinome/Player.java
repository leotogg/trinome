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
    private boolean win = false;
    
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
    public boolean Game(Echequier echequier, int x, int y, int x2, int y2){
        if (listPiece.contains(echequier.getCase(x, y))){
            return(echequier.moves(x, y, x2, y2));
//            return true;
        }else{
            System.out.println("La piece ne vous appartient pas.");
            return false;
        }
                
    }
    public boolean verifLose(){
        int dm = 0; int cb =0; int py =0;
        for (int i=0; i< listPiece.size(); i++){
           if (listPiece.get(i) instanceof DemiSphere){dm++;}
           if (listPiece.get(i) instanceof Cube){cb++;}
           if (listPiece.get(i) instanceof Pyramide){py++;}
        }
        if(dm == 0 || py == 0 || cb == 0){return true;}
        else{return false;}
    }

    public void win(){
        win = true;
    }
    public boolean getWin(){
        return win;
    }
    public void afficher(){
        for (int i =0; i<listPiece.size(); i++)
            System.out.println(listPiece.get(i));
    }
}


