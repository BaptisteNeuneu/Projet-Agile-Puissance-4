package fr.iut.fontainebleau.info.but2.groupe2a.fouche;

import java.awt.*;
import javax.swing.*;

public class Fenetre{
    private JFrame fenetre;
    public Fenetre(int x,int y){
        /*la fenetre*/
        this.fenetre = new JFrame();
        this.fenetre.setSize(x,y);
        this.fenetre.setLocation((1920-x)/2,(1080-y)/2);

        /*le gestionnaire*/
        Gestionnaire gestionnaire = new Gestionnaire();
        GridBagLayout layout=gestionnaire.getLayout();
        fenetre.setLayout(layout);

        /*la grille*/
        //Grille grilleDeJeu= new Grille();
        //JPanel panneau=grilleDeJeu.getPanel();
        //fenetre.add(panneau);
        
        /*le texte*/
        JLabel nomDuJoueur = new JLabel();

        /*le bouton*/
    }
    public void affichage(){
        this.fenetre.setVisible(true);
    }
}