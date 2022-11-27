package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;



import javax.swing.*;
//import src.fr.iut.fontainebleau.info.but2.groupe2a.fouche.*;

public class Model1 {
    char value;
    boolean victoire = false;
    short numvicgagnant;



    private Grille grille = new Grille(0,0);
    private JFrame fenetre = new JFrame();

    public Model1(Grille grille, JFrame fenetre) {
        this.grille = grille;
        this.fenetre = fenetre;
    }

    /**
     * Affiche la victoire du joueur 
     * @param numerojoueur
     */

    private void Popup(short numerojoueur) {
            JOptionPane.showMessageDialog(fenetre, "Vicoire du joueur " + numerojoueur);
    }
    
    /**
     * Affiche que la partie est nulle
     */
    private void Popup2() {
         JOptionPane.showMessageDialog(fenetre,"Personne ne gagne");
    }

    /**
     * Vérifie
     * 
     * @param colonne
     * @param ligne
     * @param numerojoueur
     */
    public void CoupVictorieux1(int colonne, int ligne, short numerojoueur) {
        
         int jetonvictorieu = 3;
        switch (numerojoueur) {

            case 1:
                value = 'r';
                break;

            case 2:
                value = 'j';
                break;

        }
    


        /**
         * Vérifie si la victoire est vertical
         */
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (this.grille.getGrille()[colonne][i].getValue() == value)
                count++;
            else
                count = 0;
            if (count == jetonvictorieu) {
                Popup(numerojoueur);
                return;
            }
        }

        /**
         * Vérifie si la victoire est horizontal
         */
        count = 0;
        for (int i = 0; i < 7; i++) {
            if (this.grille.getGrille()[i][ligne].getValue() == value)
                count++;
            else
                count = 0;
            if (count == jetonvictorieu) {
                Popup(numerojoueur);
                return;
            }
        }

        /**
         * Vérifie si la victoire est sur la diagonale en haut à gauche à en bas droite
         */

        int cx = colonne;
        int cy = ligne;

        while (true) {
            if (cx == 0 || cy == 0)
                break;
            cx--;
            cy--;
        }

        count = 0;
        while (true) {
            if (cx > 6 || cy > 5)
                break;

            if (this.grille.getGrille()[cx][cy].getValue() == value)
                count++;
            else
                count = 0;
            if (count == jetonvictorieu) {
                Popup(numerojoueur);
                return;
            }

            cx++;
            cy++;
        }

        /**
         * Vérifie si la victoire est sur la diagonale en bas à gauche vers en haut à
         * droite
         */

        cx = colonne;
        cy = ligne;

        count = 0;
        while (true) {
            if (cx == 0 || cy == 5)
                break;
            cx--;
            cy++;
        }

        while (true) {
            if (cx == 6 || cy == 0)
                break;
            if (this.grille.getGrille()[cx][cy].getValue() == value)
                count++;
            else
                count = 0;
            if (count == jetonvictorieu) {
                Popup(numerojoueur);
                return;
            }

            cx++;
            cy--;
        }

        CheckNull();
    }
    
    /**
     * Vérifie si la partie est nulle
     */
    public void CheckNull() {
        char a = '-';
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 6; y++) {
                if (this.grille.getGrille()[x][y].getValue() == a) {
                    return;
                }

            }
        }
        System.out.println("La partie est null");
        Popup2();
    }

}
