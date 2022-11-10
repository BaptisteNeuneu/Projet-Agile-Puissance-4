package src.fr.iut.fontainebleau.info.but2.groupe2a.nevejans;

import javax.swing.JOptionPane;
import javax.swing.Popup;

public class Model{
    char value;
    boolean victoire = false; 

    /**
     * Affiche la victoire du joueur
     * si c'est la victoire de la première partie lance la deuxième
     * en vérifiant si victoire est true ou false
     * @param numerojoueur
     */

    private void Popup(int numerojoueur){
        JOptionPane.showMessageDialog(fenetre,"Vicoire du joueur " + numerojoueur);
        if(victoire == true){
            Partie2(numerojoueur);
        }
    }

    /**
     * Vérifie 
     * @param colonne
     * @param ligne
     * @param numerojoueur
     */
    private void CoupVictorieux(int colonne, int ligne, int numerojoueur) {
        switch(numerojoueur){

            case 1:
                value = 'r';
                break;

            case 2:
                value = 'j';
                break;

            case 3:
                value = 'v';
                break;
        }


        //Vertical win ?
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (Jeton[colonne][i].getValue() == value) count++; else count = 0;
            if (count == 3) {
                Popup(numerojoueur);
                return;
            }
        }

        //Horizontal win ?
        count = 0;
        for (int i = 0; i < 7; i++) {
            if (Jeton[i][ligne] == value) count++; else count = 0;
            if (count == 3) {
                Popup(numerojoueur);
                return;
            }
        }

        //Up Left --> Down Right win ?

        int cx = colonne;
        int cy = ligne;

        while (true) {
            if (cx == 0 || cy == 0) break;
            cx--;
            cy--;
        }

        count = 0;
        while(true) {
            if (cx > 6 || cy > 5) break;

            if (Jeton[cx][cy].getValue() == value) count++; else count = 0;
            if (count == 3) {
                Popup(numerojoueur);
                return;
            }

            cx++;
            cy++;
        }


        //Down Left --> Up Right win ?

        cx = colonne;
        cy = ligne;

        count = 0;
        while (true) {
            if (cx == 0 || cy == 5) break;
            cx--;
            cy++;
        }

        while(true) {
            if (cx == 6 || cy == 0) break;
            if (Jeton[cx][cy].getValue() == value) count++; else count = 0;
            if (count == 3) {
                Popup(numerojoueur);
                return;
            }

            cx++;
            cy--;
        }
    }
    
    private void CoupLegal(int colonne){
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (Jeton[colonne][i].getValue() == value) count++; else count = 0;
            if (count == 6) {

            }
        }
    }    

    private void JouerCoup(int colonne,int ligne,int numerojoueur){
        switch(numerojoueur){

            case 1:
                value = 'r';
                break;

            case 2:
                value = 'j';
                break;

            case 3:
                value = 'v';
                break;
        }
        Jeton[colonne][ligne].setValue(value);
    }
} 

