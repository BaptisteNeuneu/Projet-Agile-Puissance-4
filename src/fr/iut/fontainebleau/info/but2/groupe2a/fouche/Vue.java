package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;

/*Voici la fonction Vue elle ouvre une fenètre avec une fausse grille dedans*/
import java.awt.*;
import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;
import javax.swing.*;
import java.awt.event.*;

public class Vue implements MouseListener {
    private JFrame VueFenetre;
    private JLabel VueTexte;
    private GridBagConstraints gbc;
    private GridBagLayout layout;
    private Grille grille;
    private Model a;
    private final int colonne;
    private final int ligne;
    private final int horizontal;
    private final int vertical;
    private JPanel Grille;
    private JLabel zoneJaune;
    private JLabel zoneRouge;
    private JLabel zoneVert;
    private short numerojoueur = 1;

    /*
     * Le constructeur Vue prend comme paramètre dans l'ordre la longueur des cases,
     * la hauteur des cases, le nombre de colonnes, le nombre de lignes, la longueur
     * de la fenetre, la hauteur de la fenetre,
     */
    public Vue() {
        this.horizontal = 1050;
        this.vertical = 660;
        this.colonne = 7;
        this.ligne = 6;

        this.ajouterFenetre();
        this.ajouterGrille();

        /* le Vide */
        int nb = 0, parite = -1, decalage;
        if (this.colonne % 2 == 0) {
            parite = 0;
        } else if (this.colonne % 2 == 1) {
            parite = 1;
        }
        for (int i = parite, j = i * i; j < this.colonne; i++) {
            j = i * i;
            nb = i;
        }
        decalage = (this.colonne - nb) / 2 + 1;
        for (int i = 0; i < decalage - 1; i++) {
            this.creerVide(i + 2, this.ligne + 2);
        }
        for (int i = 0; i < 2; i++) {
            this.creerVide(this.colonne + i + 2, 1);
        }
        for (int i = 0; i < this.ligne + 1; i++) {
            for (int j = 0; j < 2; j++) {
                this.creerVide(j, 2 + i);
            }
        }
        for (int i = 0; i < nb; i++) {
            this.creerVide(i + decalage, this.ligne + 1);
        }
        this.ajouterTexte(numerojoueur, decalage, nb);
        this.ajouterJeton(3);
        this.ajouterAide();

        this.VueFenetre.addMouseListener(new Action(this));
    }

    public void affichage() {
        this.VueFenetre.setVisible(true);
    }

    /*
     * C'est une fonction qui prend les arguments et définit les options d'un
     * GridBagLayout
     */
    public void layoutOptions(int x, int y, int width, int height, int fill, int anchor, double weightx, double weighty,
            Insets insets) {
        // JButton b = new JButton("OK");
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

    /*
     * C'est une fonction qui remplit les lignes et les colonnes pour placer les
     * éléments au bon endroit
     */
    public void creerVide(int x, int y) {
        JPanel espace = new JPanel();
        espace.setPreferredSize(new Dimension(this.horizontal / this.colonne, this.vertical / this.ligne));
        espace.setBackground(/* Color.BLACK */new Color(220, 220, 220));
        this.layoutOptions(x, y, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(0, 0, 0, 0));
        this.VueFenetre.add(espace, this.gbc);
    }

    public void ajouterAide() {
        JButton aide = new JButton("Aide");
        this.layoutOptions(0, this.ligne + 2, 1, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(0, 0, 0, 0));
        this.VueFenetre.add(aide, this.gbc);
    }

    public void ajouterJeton(int nbJoueur) {
        String texte = "";
        if (nbJoueur == 2) {
            texte = "21";
        }
        if (nbJoueur == 3) {
            texte = "14";
        }
        this.zoneJaune = new JLabel(texte);
        this.zoneRouge = new JLabel(texte);
        this.zoneVert = new JLabel(texte);
        DessinJeton dessinJaune = new DessinJeton(Color.YELLOW);
        dessinJaune.setPreferredSize(new Dimension(110, 110));
        DessinJeton dessinRouge = new DessinJeton(Color.RED);
        dessinRouge.setPreferredSize(new Dimension(110, 110));
        DessinJeton dessinVert = new DessinJeton(Color.GREEN);
        dessinVert.setPreferredSize(new Dimension(110, 110));

        this.layoutOptions(this.colonne + 2, 2, 2, 2, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(5, 5, 5, 5));
        this.VueFenetre.add(zoneJaune, this.gbc);
        this.layoutOptions(this.colonne + 2, 2, 2, 2, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(5, 5, 5, 5));
        this.VueFenetre.add(dessinJaune, this.gbc);

        this.layoutOptions(this.colonne + 2, 4, 2, 2, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(5, 5, 5, 5));
        this.VueFenetre.add(zoneRouge, this.gbc);
        this.layoutOptions(this.colonne + 2, 4, 2, 2, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(5, 5, 5, 5));
        this.VueFenetre.add(dessinRouge, this.gbc);

        this.layoutOptions(this.colonne + 2, 6, 2, 2, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(5, 5, 5, 5));
        this.VueFenetre.add(zoneVert, this.gbc);
        this.layoutOptions(this.colonne + 2, 6, 2, 2, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(5, 5, 5, 5));
        this.VueFenetre.add(dessinVert, this.gbc);

    }

    public void ajouterTexte(int numeroJoueur, int decalage, int nb) {
        int nbJoueur = 3;

        /* la VueTexte */
        final String joueur1 = "Joueur 1 : rouge";
        final String joueur2 = "Joueur 2 : jaune";
        final String joueur3 = "Joueur 3 : vert";
        if (numeroJoueur == 1) {
            this.VueTexte = new JLabel(joueur1);
            this.VueTexte.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        }
        if (numeroJoueur == 2) {
            this.VueTexte = new JLabel(joueur2);
            this.VueTexte.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        }
        if (numeroJoueur == 3) {
            this.VueTexte = new JLabel(joueur3);
            this.VueTexte.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        }
        this.layoutOptions(decalage + 2, this.ligne + 2, nb, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0,
                0.0, new Insets(5, 5, 5, 5));
        this.VueFenetre.add(this.VueTexte, this.gbc);

        final String triple = "1 VS 1 VS 1";
        final String couple = "1 VS 1";
        JLabel battle = new JLabel();
        if (nbJoueur == 3) {
            battle = new JLabel(triple);
            battle.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
        }
        if (nbJoueur == 2) {
            battle = new JLabel(couple);
            battle.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
        }
        this.layoutOptions(decalage + 2, 0, nb, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(5, 5, 5, 5));
        this.VueFenetre.add(battle, this.gbc);
    }

    public void ajouterGrille() {
        this.grille = new Grille(this.horizontal,this.vertical);
        //grille.PrintGrille();
        this.a = new Model(this.grille, this.VueFenetre);
        JPanel Grille = new JPanel();
        Grille.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel pan = new JPanel();
        GridLayout layout = new GridLayout(this.ligne,this.colonne);
        pan.setPreferredSize(new Dimension(this.horizontal,this.vertical));
        pan.setMinimumSize(new Dimension(this.horizontal,this.vertical));
        pan.setMaximumSize(new Dimension(this.horizontal,this.vertical));
        pan.setLayout(layout);
        for (int i = grille.getNombreLigne()-1; i >= 0; i--) {
            for (int j =  grille.getNombreColonne()-1; j >=0; j--) {
                Jeton jeton = this.grille.getJeton(j, i);
                // System.out.println("x = " + jeton.getLigne() + " y = " + jeton.getColonne() +
                // " Value = " + jeton.getValue());
                jeton.addMouseListener(this);
                //System.out.println(this.horizontal/this.colonne*i);
                //System.out.println(this.vertical/this.ligne*j);
                gbc.gridx = this.horizontal/this.colonne*i;
                gbc.gridy = this.vertical/this.ligne*j;
                gbc.ipadx = 0;
                gbc.ipady = 0;
                gbc.gridwidth = this.horizontal/this.colonne;
                gbc.gridheight = this.vertical/this.ligne;
                gbc.fill = GridBagConstraints.BOTH;
                pan.add(jeton);
            }
        }
        pan.setBackground(Color.BLUE);
        Grille.add(pan, gbc);
        Grille.setPreferredSize(new Dimension(this.horizontal,this.vertical));
        Grille.setMinimumSize(new Dimension(this.horizontal,this.vertical));
        Grille.setMaximumSize(new Dimension(this.horizontal,this.vertical));
        Grille.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.layoutOptions(2, 2, this.colonne, this.ligne, GridBagConstraints.NONE, GridBagConstraints.CENTER, 0.0, 0.0,
                new Insets(0, 0, 0, 0));
        this.VueFenetre.add(Grille, this.gbc);
    }

    public void ajouterFenetre() {

        /* la VueFenetre */
        this.VueFenetre = new JFrame();
        this.VueFenetre.setSize(1920, 1080);
        this.VueFenetre.setLocation(0, 0);
        this.VueFenetre.getContentPane().setBackground(/* Color.WHITE */new Color(220, 220, 220));

        /* le gestionnaire */
        this.layout = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.VueFenetre.setLayout(layout);
    }

    /*
     * public void selectionner(int n1,int n2){
     * for(int i=0;i<this.ligne*this.colonne;i++){
     * DessinGrille test=new
     * DessinGrille(this.horizontal/this.colonne,this.vertical/this.ligne);
     * test.setPreferredSize(new
     * Dimension(this.horizontal/this.colonne,this.vertical/this.ligne));
     * //System.out.println(test.getPreferredSize());
     * Grille.add(test);
     * }
     * }
     */

    public void reduireJeton(int i) {
        if (i == 1) {
            String texte = this.zoneJaune.getText();
            int n = Integer.parseInt(texte);
            n = n - 1;
            System.out.println(n);
            texte = Integer.toString(n);
            this.zoneJaune.setText(texte);
        }
        if (i == 2) {
            String texte = this.zoneRouge.getText();
            int n = Integer.parseInt(texte);
            n = n - 1;
            texte = Integer.toString(n);
            this.zoneRouge = new JLabel(texte);
        }
        if (i == 3) {
            String texte = this.zoneVert.getText();
            int n = Integer.parseInt(texte);
            n = n - 1;
            texte = Integer.toString(n);
            this.zoneVert = new JLabel(texte);
        }
    }

    public JFrame getFrame() {
        return this.VueFenetre;
    }

    public void mouseClicked(MouseEvent e) {

        System.out.println(e.getComponent());
        Component j = e.getComponent();// Récupere le jeton ayant recu le clique
        Jeton jeton = (Jeton) j;
        int ligneNouveauJeton = this.grille.getLowestJeton(jeton);
        this.grille.PrintGrille();
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