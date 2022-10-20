package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class View extends Controller {
    protected JFrame fenetre = new JFrame("Puissance 4");
    protected JPanel p = new JPanel();
    private char g[][] = new char[6][7];

    public View(int x, int y) {
        /* la fenetre */
        this.fenetre = new JFrame("Puissance 4");
        this.fenetre.setSize(x, y);
        this.fenetre.setLocation((1920 - x) / 2, (1080 - y) / 2);
        this.fenetre.setDefaultCloseOperation(3);

        /* la grille */
        GridSetUp();

        Box box = new Box(BoxLayout.Y_AXIS);

        box.add(Box.createVerticalGlue());
        box.add(p);
        box.add(Box.createVerticalGlue()); // causes a deformation

        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int i = 0; i < getGrilleLength(); i++) {
            for (int j = 0; j < getGrilleHeigth(); j++) {
                JLabel label = new JLabel(Character.toString(g[i][j]));
                gbc.gridx = i;
                gbc.gridy = j;
                gbc.ipadx = 1;
                gbc.ipady = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.fill = GridBagConstraints.BOTH;
                p.add(label, gbc);
            }
        }

        this.p.setBackground(Color.BLUE);
        this.p.setPreferredSize(new Dimension(200, 200));
        this.p.setMinimumSize(new Dimension(200, 200));
        this.p.setMaximumSize(new Dimension(200, 200));
        this.p.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.fenetre.add(box);
        /* le texte */
        // JLabel nomDuJoueur = new JLabel();

        /* le bouton */
    }

    public void affichage() {
        this.fenetre.setVisible(true);
    }

    public void GridSetUp() {
        this.g = RecupGrille();
    }
}
