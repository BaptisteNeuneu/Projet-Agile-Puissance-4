package fr.iut;

import javax.swing.JOptionPane;
import javax.swing.Popup;

public class Model{
    private void Popup(){
        JOptionPane.showMessageDialog(Vue,"Vicoire du joueur " + c);
    }

    private void CoupVictorieux(int colonne, int ligne, boolean joueur) {
        Color c = joueur == JOUEUR1 ? Color.RED : Color.YELLOW;

        //Vertical win ?
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (grid[colonne][i].getBackground() == c) count++; else count = 0;
            if (count == 4) {
                Popup(c);
                return;
            }
        }

        //Horizontal win ?
        count = 0;
        for (int i = 0; i < 7; i++) {
            if (grid[i][y].getBackground() == c) count++; else count = 0;
            if (count == 4) {
                Popup(c);
                return;
            }
        }

        //Up Left --> Down Right win ?

        int ox = colonne;
        int oy = ligne;

        while (true) {
            if (ox == 0 || oy == 0) break;
            ox--;
            oy--;
        }

        count = 0;
        while(true) {
            if (ox > 6 || oy > 5) break;

            if (grid[ox][oy].getBackground() == c) count++; else count = 0;
            if (count == 4) {
                Popup(c);
                return;
            }

            ox++;
            oy++;
        }


        //Down Left --> Up Right win ?

        ox = colonne;
        oy = ligne;

        count = 0;
        while (true) {
            if (ox == 0 || oy == 5) break;
            ox--;
            oy++;
        }

        while(true) {
            if (ox == 6 || oy == 0) break;
            if (grid[ox][oy].getBackground() == c) count++; else count = 0;
            if (count == 4) {
                Popup(c);
                return;
            }

            ox++;
            oy--;
        }
    } 

    private void CoupLegal(int colonne)
    {

     if(){
        
     }   
    }

    private void JouerCoup(int colonne,int ligne,boolean joueur){
        Color c = player == JOUEUR1 ? Color.RED : Color.YELLOW;
    }
} 

