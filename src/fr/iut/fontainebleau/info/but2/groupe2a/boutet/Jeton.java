package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Jeton extends JPanel {
    private char value;
    private int x, y;

    public Jeton(int x, int y, char value) {
        this.x = x;
        this.y = y;
        this.value = value;

        setOpaque(false);
        setForeground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // System.out.println("Jeton ajouté !");
        g.setColor(getForeground());
        g.fillOval(0, 0, getWidth() - 4, getHeight() - 4);
    }

    public void setValue(char c) {
        this.value = c;
    }

    public char getValue() {
        return this.value;
    }

    public int getPosX() {
        return this.x;
    }

    public int getPosY() {
        return this.y;
    }
}
