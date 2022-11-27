package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Jeton extends JPanel {
    private char value;
    private int colonne, ligne,width,height;

    /**
     * Initialise le jeton.
     * @param colonne : sa position dans la grille(colonne).
     * @param ligne : sa position dans la grille (ligne).
     * @param value : sa valeur.
     * @param width : sa largeur.
     * @param height : sa longueur.
     */
    public Jeton(int colonne, int ligne, char value, int width, int height) {
        this.colonne = colonne;
        this.ligne = ligne;
        this.value = value;
        this.width = width;
        this.height = height;

        setOpaque(false);
    }

    /**
     * Repeint le composant pour lui creer une forme de cercle.
     * @param g : le composant à modifier.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // System.out.println("Jeton ajouté !");
        switch(this.value){
            case '-':
                g.setColor(Color.BLACK);
                break;
            case 'j':
                g.setColor(Color.YELLOW);
                break;
            case 'r':
                g.setColor(Color.RED);
                break;
            case 'v':
                g.setColor(Color.GREEN);
            
        }
        //System.out.println(this.getWidth()*this.getColonne());
        if(this.getWidth()<this.getHeight()){
            g.fillOval(2,(this.getHeight()-this.getWidth())/2+2,this.getWidth()-4,this.getWidth()-4);
        }else{
            g.fillOval((this.getWidth()-this.getHeight())/2+2,2,this.getHeight()-4,this.getHeight()-4);
        }
        //g.fillOval(0, 0, this.getWidth() - 4, this.getHeight() - 4);
    }

    /* -------------  Getteurs  -------------*/
    /* Je pense que leurs noms sont assez explicit pour ne pas avoir à les commenter */
    public void setValue(char c) {
        this.value = c;
    }

    public void setColonne(int a){
        this.colonne = a;
    }
    
    public void setLigne(int a){
        this.ligne = a;
    }

    public void setWidth(int a){
        this.width = a;
    }
    
    public void setHeight(int a){
        this.height = a;
    }

    public char getValue() {
        return this.value;
    }

    public int getColonne() {
        return this.colonne;
    }

    public int getLigne() {
        return this.ligne;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
