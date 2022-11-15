package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Jeton extends JPanel {
    private char value;
    private int colonne, ligne;

    public Jeton(int colonne, int ligne, char value) {
        this.colonne = colonne;
        this.ligne = ligne;
        this.value = value;

        setOpaque(false);
    }

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
        g.fillOval(0, 0, getWidth() - 4, getHeight() - 4);
    }

    public void setValue(char c) {
        this.value = c;
    }

    public void setColonne(int a){
        this.colonne = a;
    }
    
    public void setLigne(int a){
        this.ligne = a;
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
}
