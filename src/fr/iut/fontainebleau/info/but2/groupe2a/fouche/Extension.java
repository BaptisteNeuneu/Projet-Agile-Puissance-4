package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;

import java.awt.*;
import javax.swing.*;

public class Extension extends View{
    private JPanel p; 
    public Extension(int l,int h){
        super(l,h);
        this.p=super.p;
    }

    public JPanel getPanel(){
        Grille grille=new Grille();
        this.p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int i = 0; i < grille.getNombreColonne(); i++) {
            for (int j = 0; j < grille.getNombreLigne(); j++) {
                Jeton jeton = grille.getJeton(i, j);
                //System.out.println("x = " + jeton.getLigne() + " y = " + jeton.getColonne() +
                //" Value = " + jeton.getValue());
                jeton.addMouseListener(this);
                gbc.gridx = grille.getNombreLigne() - i;
                gbc.gridy = grille.getNombreColonne() - j;
                gbc.ipadx = 50;
                gbc.ipady = 50;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.fill = GridBagConstraints.BOTH;
                this.p.add(jeton, gbc);
            }
        }
        this.p.setBackground(Color.BLUE);
        this.p.setPreferredSize(new Dimension(485, 400));
        this.p.setMinimumSize(new Dimension(485, 400));
        this.p.setMaximumSize(new Dimension(485, 400));
        this.p.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        //this.fenetre.add(p);
        return this.p;
    }
}