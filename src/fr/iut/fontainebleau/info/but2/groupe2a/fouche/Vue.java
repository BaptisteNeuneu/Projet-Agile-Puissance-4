package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
/*Voici la fonction Vue elle ouvre une fenètre avec une fausse grille dedans*/
import java.awt.*;
import javax.swing.*;

public class Vue {
    private JFrame VueFenetre;
    private JButton VueBouton;
    private JLabel VueTexte;
    private GridBagConstraints gbc;
    private GridBagLayout layout;
    private int numeroJoueur;
    private final int colonne;
    private final int ligne;
    private final int horizontal;
    private final int vertical;

    /*Le constructeur Vue prend comme paramètre dans l'ordre la longueur des cases, la hauteur des cases, le nombre de colonnes, le nombre de lignes, la longueur de la fenetre, la hauteur de la fenetre, */ 
    public Vue(int longueur,int hauteur,int c,int l, int x, int y,int n) {
        this.horizontal=longueur;
        this.vertical=hauteur;
        this.colonne=c;
        this.ligne=l;
        this.numeroJoueur=n;
        /* la VueFenetre */
        this.VueFenetre = new JFrame();
        this.VueFenetre.setSize(x, y);
        this.VueFenetre.setLocation((1920 - x) / 2, (1080 - y) / 2);
        this.VueFenetre.getContentPane().setBackground(Color.BLACK);

        /* le gestionnaire */
        this.layout = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.VueFenetre.setLayout(layout);

        /* la grille */
        //Controlleur liaison= new Controlleur();
        //Controlleur.getGrille();

        JPanel Grille=new JPanel();
        Grille.setPreferredSize(new Dimension(this.horizontal,this.vertical));
        System.out.println(Grille.getPreferredSize());
        GridLayout gestionnaire = new GridLayout(this.ligne,this.colonne);
        Grille.setLayout(gestionnaire);
        for(int i=0;i<this.colonne*this.ligne;i++){
            DessinGrille test=new DessinGrille(this.horizontal/this.colonne,this.vertical/this.ligne);
            test.setPreferredSize(new Dimension(this.horizontal/this.colonne,this.vertical/this.ligne));
            //System.out.println(test.getPreferredSize());
            Grille.add(test);
        }
        this.layoutOptions(1,1,this.colonne,this.ligne,GridBagConstraints.BOTH,GridBagConstraints.CENTER,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(Grille,this.gbc);

        /*le Vide */
        int nb=0,parite=-1,decalage;
        if(this.colonne%2==0){
            parite=0;
        }else if(this.colonne%2==1){
            parite=1;
        }
        for(int i=parite,j=i*i;j<this.colonne;i++){
            j=i*i;
            nb=i;
        }
        decalage=(this.colonne-nb)/2+1;
        for (int i=0;i<decalage-1;i++){
            for (int j=0;j<4;j++){
                this.creerVide(i+1,this.ligne+1+j);
            }
        }
        for (int i=0;i<nb;i++){
            this.creerVide(i+decalage,this.ligne+3);
        }
        System.out.println(decalage);
        System.out.println(nb);

        /* la VueTexte */
        final String joueur1 = "Joueur 1";
        final String joueur2 = "Joueur 2";
        final String joueur3 = "Joueur 3";
        if(numeroJoueur==0){
            this.VueTexte  = new JLabel(joueur1);
            this.VueTexte.setForeground(Color.YELLOW);
        }
        if(numeroJoueur==1){
            this.VueTexte  = new JLabel(joueur2);
            this.VueTexte.setForeground(Color.RED);
        }
        if(numeroJoueur==2){
            this.VueTexte  = new JLabel(joueur3);
            this.VueTexte.setForeground(Color.BLUE);
        }

        this.layoutOptions(decalage,this.ligne+2,nb,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(this.VueTexte,this.gbc);

        /* la VueBouton */
        final String valider = "Valider";
        this.VueBouton = new JButton(valider);
        this.layoutOptions(decalage,this.ligne+4,nb,1,GridBagConstraints.BOTH,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(this.VueBouton,this.gbc);

        this.VueFenetre.setVisible(true);
        this.VueBouton.addActionListener(new Action());
    }
    /*C'est une fonction qui prend les arguments et définit les options d'un GridBagLayout */
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
    /*C'est une fonction qui remplit les lignes et les colonnes pour placer les éléments au bon endroit*/
    public void creerVide(int x,int y){
        JPanel espace = new JPanel();
        espace.setPreferredSize(new Dimension(this.horizontal/this.colonne,this.vertical/this.ligne));
        espace.setBackground(Color.WHITE);
        this.layoutOptions(x,y,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(espace,this.gbc);
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