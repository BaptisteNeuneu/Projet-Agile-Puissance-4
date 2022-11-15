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
    private JPanel Grille;
    private JLabel zoneJaune;
    private JLabel zoneRouge; 
    private JLabel zoneVert; 
    /*Le constructeur Vue prend comme paramètre dans l'ordre la longueur des cases, la hauteur des cases, le nombre de colonnes, le nombre de lignes, la longueur de la fenetre, la hauteur de la fenetre, */ 
    public Vue(int n) {
        this.horizontal=1050;
        this.vertical=480;
        this.colonne=7;
        this.ligne=6;
        this.numeroJoueur=n;

        this.ajouterFenetre();
        this.ajouterGrille();


        /*JButton test= new JButton("test");
        test.setPreferredSize(new Dimension(50,50));
        this.layoutOptions(0,0,1,1,GridBagConstraints.BOTH,GridBagConstraints.WEST,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(test,this.gbc);
        JButton test2= new JButton("test2");
        test2.setPreferredSize(new Dimension(200,500));
        this.layoutOptions(0,1,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(test2,this.gbc);
        JButton test3= new JButton("test3");
        test3.setPreferredSize(new Dimension(800,300));
        this.layoutOptions(1,0,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(test3,this.gbc);*/
        
        
        
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
        //this.creerVide(0,0);
        for (int i=0;i<decalage-1;i++){
            for (int j=0;j<2;j++){
                this.creerVide(i+1,this.ligne+2+j);
            }
        }
        for (int i=0;i<this.ligne;i++){
            this.creerVide(this.colonne+1,i+2);
        }
        for (int i=0;i<nb;i++){
            this.creerVide(i+decalage,this.ligne+1);
        }

        this.ajouterTexte(numeroJoueur,decalage,nb);
        this.ajouterBouton(decalage,nb);
        this.ajouterJeton(decalage,nb);

        this.VueFenetre.setVisible(true);
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
        espace.setBackground(Color.BLACK/*new Color(220,220,220)*/);
        this.layoutOptions(x,y,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(espace,this.gbc);
    }



    public void ajouterBouton(int decalage,int nb) {

        /* la VueBouton */
        final String valider = "Valider";
        this.VueBouton = new JButton(valider);
        this.VueBouton.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        this.layoutOptions(decalage,this.ligne+3,nb,1,GridBagConstraints.BOTH,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(this.VueBouton,this.gbc);
        this.VueBouton.addActionListener(new Action(this,0));
        this.VueFenetre.addMouseListener(new Action(this,0));
    }

    public void ajouterJeton(int decalage,int nb) {

        String texte = "21";
        this.zoneJaune  = new JLabel(texte);
        this.zoneRouge  = new JLabel(texte);
        this.zoneVert  = new JLabel(texte);
        DessinJeton dessinJaune = new DessinJeton(Color.YELLOW);
        dessinJaune.setPreferredSize(new Dimension(110,110));
        DessinJeton dessinRouge = new DessinJeton(Color.RED);
        dessinRouge.setPreferredSize(new Dimension(110,110));
        DessinJeton dessinVert = new DessinJeton(Color.GREEN);
        dessinVert.setPreferredSize(new Dimension(110,110));

        this.layoutOptions(this.colonne+2,3,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(zoneJaune,this.gbc);
        this.layoutOptions(this.colonne+2,2,1,2,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(dessinJaune,this.gbc);

        this.layoutOptions(this.colonne+2,5,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(zoneRouge,this.gbc);
        this.layoutOptions(this.colonne+2,4,1,2,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(dessinRouge,this.gbc);

        this.layoutOptions(this.colonne+2,7,1,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(zoneVert,this.gbc);
        this.layoutOptions(this.colonne+2,6,1,2,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(dessinVert,this.gbc);

    }

    public void ajouterTexte(int numeroJoueur,int decalage, int nb) {
        int nbJoueur=2;

        /* la VueTexte */
        final String joueur1 = "Joueur 1 : rouge";
        final String joueur2 = "Joueur 2 : jaune";
        final String joueur3 = "Joueur 3 : vert";
        if(numeroJoueur==1){
            this.VueTexte  = new JLabel(joueur1);
            this.VueTexte.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        }
        if(numeroJoueur==2){
            this.VueTexte  = new JLabel(joueur2);
            this.VueTexte.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        }
        if(numeroJoueur==3){
            this.VueTexte  = new JLabel(joueur3);
            this.VueTexte.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        }
        this.layoutOptions(decalage,this.ligne+2,nb,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(this.VueTexte,this.gbc);

        final String triple = "1 VS 1 VS 1";
        final String couple = "1 VS 1";
        JLabel battle=new JLabel();
        if(nbJoueur==3){
            battle = new JLabel(triple);
            battle.setFont(new Font(Font.SERIF,Font.PLAIN,40));
        }
        if(nbJoueur==2){
            battle = new JLabel(couple);
            battle.setFont(new Font(Font.SERIF,Font.PLAIN,40));
        }
        this.layoutOptions(decalage,0,nb,1,GridBagConstraints.NONE,GridBagConstraints.CENTER,0.0,0.0,new Insets(5, 5, 5, 5));
        this.VueFenetre.add(battle,this.gbc);
    }



    public void ajouterGrille() {
                /* la grille */
        //Controlleur liaison= new Controlleur();
        //Controlleur.getGrille();
        this.Grille=new JPanel();
        this.Grille.setPreferredSize(new Dimension(this.horizontal,this.vertical));
        GridLayout gestionnaire = new GridLayout(this.ligne,this.colonne);
        this.Grille.setLayout(gestionnaire);
        for(int i=0;i<this.colonne*this.ligne;i++){
            DessinGrille test=new DessinGrille(this.horizontal/this.colonne,this.vertical/this.ligne);
            test.setPreferredSize(new Dimension(this.horizontal/this.colonne,this.vertical/this.ligne));
            //System.out.println(test.getPreferredSize());
            this.Grille.add(test);
        }
        this.layoutOptions(1,2,this.colonne,this.ligne,GridBagConstraints.BOTH,GridBagConstraints.CENTER,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(this.Grille,this.gbc);

        DessinTotal d=new DessinTotal(this.colonne);
        d.setPreferredSize(new Dimension(this.horizontal/this.colonne,this.vertical/this.ligne));
        this.layoutOptions(1,1,this.colonne,1,GridBagConstraints.BOTH,GridBagConstraints.CENTER,0.0,0.0,new Insets(0, 0, 0, 0));
        this.VueFenetre.add(d,this.gbc);
    }


    public void ajouterFenetre(){
                
        /* la VueFenetre */
        this.VueFenetre = new JFrame();
        this.VueFenetre.setSize(1920, 1080);
        this.VueFenetre.setLocation(0,0);
        this.VueFenetre.getContentPane().setBackground(/*Color.WHITE*/new Color(220,220,220));

        /* le gestionnaire */
        this.layout = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.VueFenetre.setLayout(layout);
    }

    public void selectionner(int n1,int n2){
        for(int i=0;i<this.ligne*this.colonne;i++){
            DessinGrille test=new DessinGrille(this.horizontal/this.colonne,this.vertical/this.ligne);
            test.setPreferredSize(new Dimension(this.horizontal/this.colonne,this.vertical/this.ligne));
            //System.out.println(test.getPreferredSize());
            Grille.add(test);
        }
    }

    public void reduireJeton(int i) {
        if(i==1){
            String texte=this.zoneJaune.getText();
            int n=Integer.parseInt(texte);
            n=n-1;
            System.out.println(n);
            texte=Integer.toString(n);
            this.zoneJaune.setText(texte);
        }
        if(i==2){
            String texte=this.zoneRouge.getText();
            int n=Integer.parseInt(texte);
            n=n-1;
            texte=Integer.toString(n);
            this.zoneRouge = new JLabel(texte);
        }
        if(i==3){
            String texte=this.zoneVert.getText();
            int n=Integer.parseInt(texte);
            n=n-1;
            texte=Integer.toString(n);
            this.zoneVert = new JLabel(texte);
        }
    }
}