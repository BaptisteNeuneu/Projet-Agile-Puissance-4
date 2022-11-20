package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;



import javax.swing.*;
//import src.fr.iut.fontainebleau.info.but2.groupe2a.fouche.*;

public class Model {
    char value;
    boolean victoire = false;



    private Grille grille = new Grille(0,0);
    private JFrame fenetre = new JFrame();

    public Model(Grille grille, JFrame fenetre) {
        this.grille = grille;
        this.fenetre = fenetre;
    }

    /**
     * Affiche la victoire du joueur
     * si c'est la victoire de la première partie lance la deuxième
     * en vérifiant si victoire est true ou false
     * 
     * @param numerojoueur
     */

    private void Popup(int numerojoueur) {
        if (victoire == true) {
            JOptionPane.showMessageDialog(fenetre, "Le joueur" + numerojoueur + "a gagné le 1 vc 1");
            System.out.println("Le joueur" + numerojoueur + " a gagné le 1 vc 1");
            return;   
        } else {
            JOptionPane.showMessageDialog(fenetre, "Vicoire du joueur " + numerojoueur);
            System.out.println("Le joueur " + numerojoueur + " a gagné");
            System.out.println("lancement partie 2");
            victoire = true;
            // Partie2(numerojoueur);
        }
    }

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
    public void CoupVictorieux(int colonne, int ligne, int numerojoueur) {
        
         int jetonvictorieu = 3;
          if(victoire == true){
          jetonvictorieu = 4;
          }
         
        switch (numerojoueur) {

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

        // Vertical win ?
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

        // Horizontal win ?
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

        // Up Left --> Down Right win ?

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

        // Down Left --> Up Right win ?

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
