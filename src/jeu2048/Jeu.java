package jeu2048;

import jeu2048.alert.AlertGagnee;

import java.util.Random;

import static java.lang.Math.pow;

public class Jeu  extends SujetObserve{
    private int col ;
    private int lig ;

    private int objectif ;
    private int[][] tab ;
    private int nbPartie ;
    private int nbGagnees ;
    public Jeu(int lig,int col , int objectif){
        this.lig = lig ;
        this.col = col ;
        this.objectif = objectif ;
        this.tab = new int[lig][col] ;
        this.nbPartie = -1 ;
        this.nbGagnees = 0 ;
    }
    public int getLig() {
        return this.lig ;
    }
    public int getCol() {
        return this.col ;
    }
    public void nouveau(){
        this.tab = new int[lig][col] ;
        this.nbPartie++ ;
        for (int i = 0; i < this.col; i++) {
            for (int j = 0; j < this.lig; j++) {
                this.tab[i][j] = genererValeur(genererPuissance());
            }
        }
        this.notifierObservateur();
    }

    private int genererPuissance() {
        int pui = 1 ;
        while (pow(2,pui) < objectif){
            pui++ ;

        }
        if (pui-1 > 0){
            pui-- ;
        }
        return pui ;
    }

    private int genererValeur(int puissance) {
        Random rand = new Random() ;

        return (int) pow(2,rand.nextInt(puissance)+1);
    }

    public int getCase(int i ,int j){
        return this.tab[i][j] ;
    }
    public void setCase(int i ,int j,int value){
        this.tab[i][j]  = value ;
    }
    public void jouer(int lig,int col){
        int caseDroite = 0;
        int caseGauche = 0;
        int caseHaut = 0;
        int caseBas = 0;
        int caseValue = getCase(lig,col);

        int newValue = caseValue ;
        Random rand = new Random() ;
        if (col != 0) {
            if (this.getCase(lig, col - 1) == caseValue) {
                newValue = newValue + this.getCase(lig, col - 1);
                this.setCase(lig, col - 1, (int) pow(2,rand.nextInt(10)+1)) ;
            }
        }
        if (lig != 0) {
            if (this.getCase(lig - 1, col) == caseValue) {
                newValue = newValue + this.getCase(lig - 1, col) ;
                this.setCase(lig - 1, col, (int) pow(2,rand.nextInt(10)+1)) ;
            }
        }
        if (lig != this.lig-1)
            if (this.getCase(lig+1,col) == caseValue ) {
                newValue = newValue + this.getCase(lig+1,col) ;
                this.setCase(lig+1,col, (int) pow(2,rand.nextInt(10)+1)) ;
            }
        if (col != this.col-1)
            if (this.getCase(lig,col+1) == caseValue ) {
                newValue = newValue + this.getCase(lig,col+1) ;
                this.setCase(lig,col+1, (int) pow(2,rand.nextInt(10)+1)) ;
            }
        this.setCase(lig,col,newValue);
        this.notifierObservateur();
        if (newValue >= objectif){
            this.partieGagnee();
        }
    }
    public int getNbGagnees(){
        return this.nbGagnees ;
    }
    public int getNbPartie(){
        return this.nbPartie ;
    }
    public void partieGagnee(){
        this.nbGagnees ++ ;
        this.nouveau();
        AlertGagnee alert = new AlertGagnee();

    }
    public void lanceOption(){
        new FenetreOption(this) ;

    }

    public int getObjectif() {
        return this.objectif ;
    }

    public void setSize(int lig,int col) {
        this.col = col ;
        this.lig = lig ;
    }

    public void setObjectif(int e) {
        this.objectif = e ;
    }
}
