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
public class Pyramide extends Piece{
    
//----------------------------------------------
//              Attributs   
    private int[][] moves = new int[4][3];
    private boolean capture_Pyramide;
    private boolean capture = true;
//----------------------------------------------
//              Constructeurs   
    public Pyramide(String couleur_Pièce, int[] position) {
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
        if (x-1>=0 && y+1<11){
            moves[0][2]= 1;
        }else{
            moves[0][2]= 0;
        }        
        moves[1][0] = x+1;
        moves[1][1] = y+1;
        if (x+1<11 && y+1<11){
            moves[1][2]= 1;
        }else{
            moves[1][2]= 0;
        }        
        moves[2][0] = x+1;
        moves[2][1] = y-1;
        if (y-1>=0 && x+1<11){
            moves[2][2]= 1;
        }else{
            moves[2][2]= 0;
        }        
        moves[3][0] = x-1;
        moves[3][1] = y-1;
        if (x-1>=0 && y-1>=0){
            moves[3][2]= 1;
        }else{
            moves[3][2]= 0;
        }        
        if(super.déplacement(wish, moves)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCapture_Pyramide() {
        return capture_Pyramide;
    }
    public String toString(){
        return "Py" + super.toString();
    }
    public boolean getCapture(){
        return capture;
    }
//----------------------------------------------    
}
