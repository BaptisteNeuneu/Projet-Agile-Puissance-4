package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;

public class View extends Controller implements MouseListener {
    protected JFrame fenetre = new JFrame("Puissance 4");
    protected JPanel p = new JPanel();
    private char g[][] = new char[6][7];
    private boolean turn = false; // tour du joueur jaune turn=false | tour du joueur rouge turn=true

    public View(int x, int y) {
        /* la fenetre */
        this.fenetre = new JFrame("Puissance 4");
        this.fenetre.setSize(x, y);
        this.fenetre.setLocation((1920 - x) / 2, (1080 - y) / 2);
        this.fenetre.setDefaultCloseOperation(3);

        /* la grille */
        GridSetUp();
        PrintGrille();

        /* Faire en sorte que le plateau reste toujours au centre de la fenetre */
        Box box = new Box(BoxLayout.Y_AXIS);

        box.add(Box.createVerticalGlue());
        box.add(p);
        box.add(Box.createVerticalGlue()); // causes a deformation

        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int i = 0; i < getGrilleLength(); i++) {
            for (int j = 0; j < getGrilleHeigth(); j++) {
                Jeton jeton = new Jeton(i, j, g[i][j]);
                System.out.println("x = " + jeton.getPosX() + " y = " + jeton.getPosY() + " Value = " + jeton.getValue());
                jeton.addMouseListener(this);
                gbc.gridx = i;
                gbc.gridy = j;
                gbc.ipadx = 50;
                gbc.ipady = 50;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.fill = GridBagConstraints.BOTH;
                p.add(jeton, gbc);
            }
        }

        this.p.setBackground(Color.BLUE);
        this.p.setPreferredSize(new Dimension(485, 400));
        this.p.setMinimumSize(new Dimension(485, 400));
        this.p.setMaximumSize(new Dimension(485, 400));
        this.p.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.fenetre.add(box);
        /* le texte */

        /* le bouton */
    }

    public void affichage() {
        this.fenetre.setVisible(true);
    }

    public void GridSetUp() {
        this.g = RecupGrille();
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getComponent());
        if (turn == false) {// Tour du joueur Jaune
            e.getComponent().setForeground(Color.YELLOW);
            this.fenetre.setTitle("Puissance 4 : Tour du joueur Rouge");
            this.turn = true;
        } else {// tour du joueur Rouge
            this.fenetre.setTitle("Puissance 4 : Tour du joueur Jaune");
            e.getComponent().setForeground(Color.RED);
            // System.out.println(e.getComponent());
            this.turn = false;
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        System.out.print("En entrée : " + e.getComponent().getForeground());
        /* Si la case est "vide" donc noire, alors je la peints en gris */
        if (e.getComponent().getForeground() == Color.BLACK) {
            e.getComponent().setForeground(Color.gray);
            System.out.print(" -> Couleur changée ");
        }
    }

    public void mouseExited(MouseEvent e) {
        System.out.print(" ---- En sortie : " + e.getComponent().getForeground());
        /*
         * Si la case est grise, donc survolée et que je quitte la case, alors je remets
         * ma case en noire
         */
        if (e.getComponent().getForeground() == Color.gray) {
            e.getComponent().setForeground(Color.BLACK);
            System.out.print(" -> Couleur changée \n");
        }

    }

    public void mouseReleased(MouseEvent e) {
    }
}
