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
public class DemiSphere extends Piece{
    
//----------------------------------------------
//              Attributs       
    private int[][] moves ;
    private boolean capture_DemiSphère;
//----------------------------------------------
//              Constructeur       
    public DemiSphere(String couleur_Pièce, int[] position) {
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
        moves[0][1] = y+1;
        
        moves[1][0] = x+1;
        moves[1][1] = y+1;
        
        moves[2][0] = x+1;
        moves[2][1] = y-1;
        
        moves[3][0] = x-1;
        moves[3][1] = y-1;
        
        moves[4][0] = x-1;
        moves[4][1] = y;
        
        moves[5][0] = x;
        moves[5][1] = y+1;
        
        moves[6][0] = x+1;
        moves[6][1] = y;
        
        moves[7][0] = x;
        moves[7][1] = y-1;
        
        if(super.déplacement(wish, moves)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCapture_DemiSphère() {
        return capture_DemiSphère;
    }
    public String toString(){
        return "Ds" + super.toString();
    }
    
}