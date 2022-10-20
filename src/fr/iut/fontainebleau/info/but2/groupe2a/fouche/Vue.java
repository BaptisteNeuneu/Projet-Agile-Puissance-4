//package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;

import java.awt.*;
import javax.swing.*;

public class Vue {
    private JFrame VueFenetre;
    private JButton VueBouton;
    private JLabel VueTexte;
    private GridBagConstraints gbc;
    private GridBagLayout layout;
    private boolean numeroJoueur;

    public Vue() {

    }
    public void startGame(int x, int y) {
        numeroJoueur=false;
        /* la VueFenetre */
        this.VueFenetre = new JFrame();
        this.VueFenetre.setSize(x, y);
        this.VueFenetre.setLocation((1920 - x) / 2, (1080 - y) / 2);
        this.VueFenetre.getContentPane().setBackground( Color.BLACK);

        /* le gestionnaire */
        this.layout = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.VueFenetre.setLayout(layout);

        /* la grille */
        //Controlleur liaison= new Controlleur();
        //Controlleur.getGrille();

        JPanel Grille=new JPanel();
        JLabel test=new JLabel("grille");
        Grille.add(test);
        this.layoutOptions(1,1,7,7,GridBagConstraints.VERTICAL,GridBagConstraints.EAST,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(Grille,this.gbc);

        /* la VueTexte */
        final String joueur1 = "Joueur 1";
        final String joueur2 = "Joueur 2";
        if(numeroJoueur==true){
            System.out.println("putain");
            this.VueTexte  = new JLabel(joueur1);
            this.VueTexte.setForeground(Color.YELLOW);
        }
        if(numeroJoueur==false){
            this.VueTexte  = new JLabel(joueur2);
            this.VueTexte.setForeground(Color.RED);
        }
        this.layoutOptions(7,8,1,1,GridBagConstraints.BOTH,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(this.VueTexte,this.gbc);

        /* la VueBouton */
        final String valider = "Valider";
        this.VueBouton = new JButton(valider);
        this.layoutOptions(7,9,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(this.VueBouton,this.gbc);

        this.VueFenetre.setVisible(true);
    }
    public void layoutOptions(int x,int y,int width,int height,int fill,int anchor,double weightx,double weighty,Insets insets) {
        //JButton b = new JButton("OK");
        this.gbc.gridx = x;      
        this.gbc.gridy = y;      
        this.gbc.gridwidth = width;  
        this.gbc.gridheight = height; 
        this.gbc.fill = fill;     
        this.gbc.anchor = anchor; 
        this.gbc.weightx = weightx;  
        this.gbc.weighty = weighty;  
        this.gbc.insets = insets;
    }
    public void endGame() {
        this.VueFenetre.setVisible(true);
    }
    public void jouerCoup(int colonne) {
        this.VueFenetre.setVisible(true);
    }
    public void affichage() {
        this.VueFenetre.setVisible(true);
    }
}