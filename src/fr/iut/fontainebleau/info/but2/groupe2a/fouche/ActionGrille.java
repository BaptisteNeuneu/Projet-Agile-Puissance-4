package fr.iut.fontainebleau.info.but2.groupe2a.fouche;

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

    }

    public void mouseClicked(MouseEvent e) {

        System.out.println(e.getComponent());
        Component j = e.getComponent();// Récupere le jeton ayant recu le clique
        Jeton jeton = (Jeton) j;
        int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
        switch (numerojoueur) {

            case 1:
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('r');
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                this.numerojoueur = 2;
                this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Jaune");
                break;

            case 2:
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('j');
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                this.numerojoueur = 3;
                this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Vert");
                break;

            case 3:
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].setValue('v');
                this.grille.getGrille()[jeton.getColonne()][ligneNouveauJeton].repaint();
                a.CoupVictorieux(jeton.getColonne(), ligneNouveauJeton, numerojoueur);
                this.numerojoueur = 1;
                this.VueFenetre.setTitle("Puissance 4 : Tour du joueur Rouge");
                break;
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
}
