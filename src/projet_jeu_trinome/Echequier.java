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

    public void deplacement_Affichage() {

    }

    public void capture() {

    }

//    public void create_Echequier() {
//
//        for (int i = 0; i < echequier.length; i++) {
//            for (int j = 0; j < echequier[i].length; j++) {
//                echequier[i][j] = "0";
//            }
//        }
//    }

//    public void affichage_echequier() {
//        System.out.println("Affichage de l'échéquier ! \n ");
//        for (int i = 0; i < 11; i++) {
//            System.out.print(Arrays.toString(echequier[i]) + "\n");
//        }
//    }

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

//    public void create_PiecesVerte() {
//
//        int compteur = 0;
//        int cT = cubeTab.length;
//        int pT = pyramideTab.length;
//        int dST = dShpèreTab.length;
//        int compteurPyra = 0;
//        int compteurCube = 0;
//        int compteurDemiSphère = 0;
//
//        for (int create = 0; create < cubeTab.length; create++) {
//            cubeTab[create] = "Cr" + create + "V";
//            pyramideTab[create] = "Pr" + create + "V";
//
//            // A chaque boucle for, je génère 2 pièces, un carré et une pyramide
//            compteur = compteur + 2;
//        }
//        for (int create = 0; create < dShpèreTab.length; create++) {
//            dShpèreTab[create] = "Ds" + create + "V";
//            // A chaque for, je génére 1 pièce, une demie-sphère
//            compteur = compteur + 1;
//        }
//
//        System.arraycopy(cubeTab, 0, this.liste_PieceVerte, 0, cT);
//        System.arraycopy(pyramideTab, 0, this.liste_PieceVerte, cT, pT);
//        System.arraycopy(dShpèreTab, 0, this.liste_PieceVerte, cT + pT, dST);
//
//        //Application des pièces sur la première ligne
//        for (int i = 0; i < 11; i++) {
//            if (i < 2 || i == 9 || i == 10) {
//                compteurPyra = compteurPyra + 1;
//                echequier[0][i] = pyramideTab[compteurPyra - 1];
//
//            }
//            if (i == 2 || i == 8) {
//                compteurCube = compteurCube + 1;
//                echequier[0][i] = cubeTab[compteurCube - 1];
//
//            }
//            if (i == 3 || i == 7) {
//                echequier[0][i] = "0";
//            }
//            if (i == 4 || i == 5 || i == 6) {
//                compteurDemiSphère = compteurDemiSphère + 1;
//                echequier[0][i] = dShpèreTab[compteurDemiSphère - 1];
//
//            }
//        }
//        // Application des pièces sur la deuxième ligne
//        for (int i = 0; i <= 11; i++) {
//            if (i == 0 || i == 10) {
//                compteurPyra = compteurPyra + 1;
//                for (int j = 0; j < pyramideTab.length; j++) {
//                    if (pyramideTab[j] != "0") {
//                        echequier[1][i] = pyramideTab[compteurPyra - 1];
//                    }
//                }
//                pyramideTab[compteurPyra - 1] = "0";
//            }
//            if (i == 1 || i == 9) {
//                compteurCube = compteurCube + 1;
//                for (int j = 0; j < cubeTab.length; j++) {
//                    if (cubeTab[j] != "0") {
//                        echequier[1][i] = cubeTab[compteurCube - 1];
//                    }
//                }
//                cubeTab[compteurCube - 1] = "0";
//            }
//            if (i > 1 && i < 9) {
//                echequier[1][i] = "0";
//            }
//        }
//        // Application des pièces sur la troisème ligne
//        for (int i = 0; i <= 11; i++) {
//            if (i == 0 || i == 10) {
//                compteurCube = compteurCube + 1;
//                for (int j = 0; j < cubeTab.length; j++) {
//                    if (cubeTab[j] != "0") {
//                        echequier[2][i] = cubeTab[compteurCube - 1];
//                    }
//                }
//                cubeTab[compteurCube - 1] = "0";
//            }
//            if (i > 0 && i < 10) {
//                echequier[2][i] = "0";
//            }
//        }
//    }
//
//    public void create_PiecesRouge() {
//
//        int compteur = 0;
//        int cT = cubeTab.length;
//        int pT = pyramideTab.length;
//        int dST = dShpèreTab.length;
//        int compteurPyra = 0;
//        int compteurCube = 0;
//        int compteurDemiSphère = 0;
//
//        for (int create = 0; create < cubeTab.length; create++) {
//
//            cubeTab[create] = "Cr" + create + "R";
//            pyramideTab[create] = "Pr" + create + "R";
//
//            // A chaque boucle for, je génère 2 pièces, un carré et une pyramide
//            compteur = compteur + 2;
//        }
//        for (int create = 0; create < dShpèreTab.length; create++) {
//
//            dShpèreTab[create] = "Ds" + create + "R";
//
//            // A chaque for, je génére 1 pièce, une demie-sphère
//            compteur = compteur + 1;
//        }
//
//        System.arraycopy(cubeTab, 0, this.liste_PieceRouge, 0, cT);
//        System.arraycopy(pyramideTab, 0, this.liste_PieceRouge, cT, pT);
//        System.arraycopy(dShpèreTab, 0, this.liste_PieceRouge, cT + pT, dST);
//
//        //Application des pièces sur la première ligne
//        for (int i = 0; i < 11; i++) {
//            if (i < 2 || i == 9 || i == 10) {
//                compteurPyra = compteurPyra + 1;
//                echequier[10][i] = pyramideTab[compteurPyra - 1];
//
//            }
//            if (i == 2 || i == 8) {
//                compteurCube = compteurCube + 1;
//                echequier[10][i] = cubeTab[compteurCube - 1];
//
//            }
//            if (i == 3 || i == 7) {
//                echequier[10][i] = "0";
//            }
//            if (i == 4 || i == 5 || i == 6) {
//                compteurDemiSphère = compteurDemiSphère + 1;
//                echequier[10][i] = dShpèreTab[compteurDemiSphère - 1];
//
//            }
//        }
//        // Application des pièces sur la deuxième ligne
//        for (int i = 0; i <= 11; i++) {
//            if (i == 0 || i == 10) {
//                compteurPyra = compteurPyra + 1;
//                for (int j = 0; j < pyramideTab.length; j++) {
//                    if (pyramideTab[j] != "0") {
//                        echequier[9][i] = pyramideTab[compteurPyra - 1];
//                    }
//                }
//                pyramideTab[compteurPyra - 1] = "0";
//            }
//            if (i == 1 || i == 9) {
//                compteurCube = compteurCube + 1;
//                for (int j = 0; j < cubeTab.length; j++) {
//                    if (cubeTab[j] != "0") {
//                        echequier[9][i] = cubeTab[compteurCube - 1];
//                    }
//                }
//                cubeTab[compteurCube - 1] = "0";
//            }
//            if (i > 1 && i < 9) {
//                echequier[9][i] = "0";
//            }
//        }
//        // Application des pièces sur la troisème ligne
//        for (int i = 0; i <= 11; i++) {
//            if (i == 0 || i == 10) {
//                compteurCube = compteurCube + 1;
//                for (int j = 0; j < cubeTab.length; j++) {
//                    if (cubeTab[j] != "0") {
//                        echequier[8][i] = cubeTab[compteurCube - 1];
//                    }
//                }
//                cubeTab[compteurCube - 1] = "0";
//            }
//            if (i > 0 && i < 10) {
//                echequier[8][i] = "0";
//            }
//        }
//    }

    //Getters
    public String[] getListe_PieceVerte() {
        return liste_PieceVerte;
    }

    public String[] getListe_PieceRouge() {
        return liste_PieceRouge;
    }

    public boolean isZone_Rouge() {
        return zone_Rouge;
    }

    public boolean isZone_Verte() {
        return zone_Verte;
    }

    public String[][] getEchequier() {
        return echequier;
    }
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
        if(tab[x][y] != null){
            if (tab[x][y].calculMovePossible(wish) && tab[x2][y2]==null){
                this.setTab(x, y, x2, y2);
                return "Mouvement effectue.";
            }
            if(tab[x][y].calculMovePossible(wish) && tab[x2][y2]!=null){
                return this.capture(x,y,x2,y2);
            }else{
                return "Mouvement impossible.";
            }
        }else{
            return "La piece n'existe pas zebi";
        }
    }
    
    public String capture(int x, int y, int x2, int y2){
        Piece pieceUne = tab[x][y];
        Piece pieceDeux = tab[x2][y2];
        if ((Jun.verfifList(pieceUne) && Jun.verfifList(pieceDeux)) || (Jdeux.verfifList(pieceUne) && Jdeux.verfifList(pieceDeux))){
            return "Mouvement impossible.";
        }
        if (Jun.verfifList(pieceUne) && Jdeux.verfifList(pieceDeux)){
            this.setTab(x, y, x2, y2);
            Jdeux.remove(pieceDeux);
            return "Mouvement effectue.";
        }
        if (Jdeux.verfifList(pieceUne) && Jun.verfifList(pieceDeux)){
            this.setTab(x, y, x2, y2);
            Jdeux.remove(pieceUne);
            return "Mouvement effectue.";
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

}
