/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_jeu_trinome;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hugop
 */
public class Echequier {

//----------------------------------------------
//              Attributs   
    private String[] liste_PieceVerte = new String[15];
    private String[] liste_PieceRouge = new String[15];
    
    private boolean zone_Rouge;
    private boolean zone_Verte;
    private String[] cubeTab = new String[6];
    private String[] pyramideTab = new String[6];
    private String[] dShpèreTab = new String[3];
    private String[][] echequier = new String[11][11];
    
    private Piece[][] tab = new Piece[11][11];
    private ArrayList<Piece> listPiece = new ArrayList<Piece>();
    private Player Jun;
    private Player Jdeux;
//----------------------------------------------
//              Constructeur       

    public Echequier(Player j1, Player j2) {
        Jun = j1;
        Jdeux = j2;
    }
//----------------------------------------------
//              Méthodes       

    public void affichage_tab() {
        System.out.println("Affichage de l'échéquier ! \n ");
        for (int i = 0; i < 11; i++) {
            System.out.print(Arrays.toString(tab[i]) + "\n");
        }
    }
    public void create_Piece(){
        for (int i = 0; i<11; i++){
            for (int j=0;j<11;j++){
                int[] tab = new int[2];
                    tab[0]=i;
                    tab[1]=j;
                if ((i==0 && (j==0 || j==1 ||j==9||j==10)) || (i==1 &&(j==0 || j==10))){                    
                    Piece piece = new Pyramide("verte",tab);
                    listPiece.add(piece);
                    Jun.ajoutPiece(piece);
                    this.tab[i][j] = piece;
                }
                if ((i==0 && (j==2 || j==9)) ||(i==1 && (j==0 || j==1 ||j==9)) || (i==2 &&(j==0 ||j==10))){
                    Piece piece = new Cube("verte",tab);
                    listPiece.add(piece);
                    Jun.ajoutPiece(piece);
                    this.tab[i][j] = piece;
                }
                if (i==0 && (j==0 || j==4 ||j==5||j==6)){
                    Piece piece = new DemiSphere("verte",tab);
                    listPiece.add(piece);
                    Jun.ajoutPiece(piece);
                    this.tab[i][j] = piece;
                }
                
                if ((i==10 && (j==0 || j==1 ||j==9||j==10)) || (i==9 &&(j==0 || j==10))){
                    Piece piece = new Pyramide("rouge",tab);
                    listPiece.add(piece);
                    Jdeux.ajoutPiece(piece);
                    this.tab[i][j] = piece;
                }
                if ((i==10 && (j==2 || j==9)) ||(i==9 && (j==0 || j==1 ||j==9)) || (i==8 &&(j==0 ||j==10))){
                    Piece piece = new Cube("rouge",tab);
                    listPiece.add(piece);
                    Jdeux.ajoutPiece(piece);
                    this.tab[i][j] = piece;
                }
                if (i==10 && (j==0 || j==4 ||j==5||j==6)){
                    Piece piece = new DemiSphere("rouge",tab);
                    listPiece.add(piece);
                    Jdeux.ajoutPiece(piece);
                    this.tab[i][j] = piece;
                }
            }
        }
    }


    //Getters


    public Piece[][] getTab() {
        return tab;
    }
    public Piece getCase(int x, int y) {
        return tab[x][y];
    }
    public String moves(int x, int y, int x2, int y2) {
        int[] wish = new int[2];
        wish[0] = x2;
        wish[1] = y2;
        if(tab[x][y] != null && tab[x][y].getMoved()){
            if (tab[x][y].calculMovePossible(wish) && tab[x2][y2]==null){
                this.setTab(x, y, x2, y2);
                this.verifZone(tab[x2][y2]);
                return "Mouvement effectue.";
            }
            if(tab[x][y].calculMovePossible(wish) && tab[x2][y2]!=null){
                return this.capture(x,y,x2,y2);
            }else{
                return "Mouvement impossible.";
            }
        }else{
            return "La piece n'existe pas ou ne peut plus bouger.";
        }
    }
    
    public String capture(int x, int y, int x2, int y2){
        Piece pieceUne = tab[x][y];
        Piece pieceDeux = tab[x2][y2];
        if ((Jun.verfifList(pieceUne) && Jun.verfifList(pieceDeux)) || (Jdeux.verfifList(pieceUne) && Jdeux.verfifList(pieceDeux))){
            return "Mouvement impossible.";
        }
        if (Jun.verfifList(pieceUne) && Jdeux.verfifList(pieceDeux) && tab[x][y].getCapture()){
            this.setTab(x, y, x2, y2);
            Jdeux.remove(pieceDeux);
            this.verifZone(tab[x2][y2]);
            return "Capture effectuee.";
        }
        if (Jdeux.verfifList(pieceUne) && Jun.verfifList(pieceDeux) && tab[x][y].getCapture()){
            this.setTab(x, y, x2, y2);
            Jdeux.remove(pieceUne);
            this.verifZone(tab[x2][y2]);
            return "Capture effectuee.";
        }else {
            return "Mouvement impossible.";
                    }
    }
    
    public void setTab(int x, int y, int a, int b) {
        tab[x][y].setPosition(a, b);
        Piece temp = tab[x][y];
        tab [x][y] = null ;
        tab [a][b] = temp;
    }
    public void verifZone(Piece piece){
        int x = piece.getPosition()[0];
        int y = piece.getPosition()[1];
        if (((x ==0 && y==4) ||(x ==0 && y==5 )||( x==0 && y==6 ))&& Jdeux.verfifList(piece)){
            piece.setCaptured();
            piece.setMoved();
        }
        if (((x ==10 && y==4) ||(x ==10 && y==5 )||( x==10 && y==6 ))&& Jun.verfifList(piece)){
            piece.setCaptured();
            piece.setMoved();
        }
    }

}
