/*package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;

import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class ActionGrille implements MouseListener {

private Grille grille;
private JFrame VueFenetre;
private Model a;
private short numerojoueur;
    public ActionGrille(Grille grille, JFrame VueFenetre,Model a,short numerojoueur){
        this.grille = grille;
        this.VueFenetre = VueFenetre;
        this.a = a;
        this.numerojoueur = numerojoueur;
    }

    public void mouseClicked(MouseEvent e) {
        this.reduireJeton(this.numerojoueur);
        // System.out.println(e.getComponent());
        Component j = e.getComponent();// Récupere le jeton ayant recu le clique
        Jeton jeton = (Jeton) j;
        int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
        // this.grille.PrintGrille();
        this.colorier(jeton, ligneNouveauJeton, this.premier);
        // System.out.println(this.numerojoueur);
        if (this.a.getPassage()) {
            this.premier = (this.numerojoueur % 3 + 1) % 3 + 1;
            this.changement();
            this.a.setPassage(false);
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getComponent().getForeground() == Color.BLACK) {
            if (numerojoueur == 2) {// Tour du joueur Jaune
                Component j = e.getComponent();// Récupere le jeton ayant recu le clique
                Jeton jeton = (Jeton) j;
                int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setForeground(Color.GRAY);
            } else if (numerojoueur == 1) {// tour du joueur Rouge
                Component j = e.getComponent();// Récupere le jeton ayant recu le clique
                Jeton jeton = (Jeton) j;
                int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setForeground(Color.GRAY);
            } else if (numerojoueur == 3) {
                Component j = e.getComponent();// Récupere le jeton ayant recu le clique
                Jeton jeton = (Jeton) j;
                int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setForeground(Color.GRAY);
            }
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getComponent().getForeground() == Color.gray) {
            e.getComponent().setForeground(Color.BLACK);
            System.out.print(" -> Couleur changée \n");
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void changement() {
        Changement.retirer(this.VueFenetre, this.zoneRouge, this.zoneJaune, this.zoneVert, this.numerojoueur);
        Changement.retirer(this.VueFenetre, this.dessinRouge, this.dessinJaune, this.dessinVert, this.numerojoueur);
        Changement.decoloriser(this.grille, this.numerojoueur);
        Changement.afficher(this.VueFenetre);
    }

    public void colorier(Jeton jeton, int ligneNouveauJeton, int n) {
        if (n == 0) {
            switch (this.numerojoueur) {
                case 1:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('r');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 2;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Jaune");
                    this.VueTexte.setText("Joueur 2 : Couleur Jaune");
                    break;
                case 2:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('j');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 3;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Vert");
                    this.VueTexte.setText("Joueur 3 : Couleur Vert");
                    break;
                case 3:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('v');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 1;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Rouge");
                    this.VueTexte.setText("Joueur 1 : Couleur Rouge");
                    break;
            }
        }
        if (n == 1) {
            switch (this.numerojoueur) {
                case 2:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('j');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 3;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Vert");
                    this.VueTexte.setText("Joueur 3 : Couleur Vert");
                    break;
                case 3:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('v');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 2;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Jaune");
                    this.VueTexte.setText("Joueur 2 : Couleur Jaune");
                    break;
            }
        }
        if (n == 2) {
            switch (this.numerojoueur) {
                case 1:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('r');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 3;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Vert");
                    this.VueTexte.setText("Joueur 3 : Couleur Vert");
                    break;
                case 3:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('v');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 1;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Rouge");
                    this.VueTexte.setText("Joueur 1 : Couleur Rouge");
                    break;
            }
        }
        if (n == 3) {
            switch (this.numerojoueur) {
                case 1:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('r');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 2;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Jaune");
                    this.VueTexte.setText("Joueur 2 : Couleur Jaune");
                    break;
                case 2:
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('j');
                    this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                    a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                    this.numerojoueur = 1;
                    this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Rouge");
                    this.VueTexte.setText("Joueur 1 : Couleur Rouge");
                    break;
            }
        }
    }
}
*/