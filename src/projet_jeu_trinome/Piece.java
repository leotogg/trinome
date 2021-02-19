/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_jeu_trinome;

/**
 *
 * @author hugop
 */
public class Piece {
    
//----------------------------------------------
//              Attributs   
    private String couleur_Pièce;
    private int[] position_Piece = new int[2];
    private boolean capture;
    private boolean moveAble;
//----------------------------------------------
//              Constructeur   
    public Piece(String couleur_Pièce, int[] position) {
        this.couleur_Pièce = couleur_Pièce;
        position_Piece = position;
    }
//----------------------------------------------
//              Méthodes       
    public boolean déplacement(int[] wish, int[][] move){
        for (int i=0; i<move.length; i++){
            if (move[i][0]== wish[0] && move[i][1] == wish[1] && move[i][2] == 1){
                return true;
            }
        }
        return false;
    }
    
    public String toString(){
        return String.valueOf(position_Piece[0]) + String.valueOf(position_Piece[1]+ couleur_Pièce);
    }
    public int[] getPosition(){
        return position_Piece;
    }
    public void setPosition(int a, int b){
        position_Piece[0] = a;
        position_Piece[1] = b;
    }
    public boolean calculMovePossible(int[] wish) {
        int[][] move = null;
        move[0][0] = 0;
        move[0][1] = 0;
        
        return false;
    }
}
