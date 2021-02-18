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
public class Cube extends Piece{
    
//----------------------------------------------
//              Attributs       
    private int[][] moves = new int[4][2];
    private boolean capture_Cube;
//----------------------------------------------
//              Constructeur       
    public Cube(String couleur_Pièce, int[] position) {
        super(couleur_Pièce, position);
        
    }
//----------------------------------------------

    
    //Code
    
    
//----------------------------------------------
//              Getters   
    public boolean calculMovePossible(int[] wish) {
        int [] position = super.getPosition();
        int x = position[0];
        int y = position[1];
        moves[0][0] = x-1;
        moves[0][1] = y;
        
        moves[1][0] = x;
        moves[1][1] = y+1;
        
        moves[2][0] = x+1;
        moves[2][1] = y;
        
        moves[3][0] = x;
        moves[3][1] = y-1;
        
        if(super.déplacement(wish, moves)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCapture_Cube() {
        return capture_Cube;
    }
    public String toString(){
        return "Cu" + super.toString();
    }
    
    
}
