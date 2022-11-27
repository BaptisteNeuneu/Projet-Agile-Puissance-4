package src.fr.iut.fontainebleau.info.but2.groupe2a.nevejans;

import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.event.*;

import src.fr.iut.fontainebleau.info.but2.groupe2a.fouche.*;

public class ActionMenu implements ActionListener{
    private JButton puissance3,puissance4,quitter; 
    public ActionMenu(JButton puissance3,JButton puissance4,JButton quitter){
        this.puissance3=puissance3;
        this.puissance4=puissance4;
        this.quitter=quitter;
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == puissance3) {
            Vue vu = new Vue();
            vu.affichage();

        }
        if (e.getSource() == puissance4){
            Vue1 vu2 = new Vue1();
            vu2.affichage1();
        }
        if(e.getSource() == quitter){
            System.exit(0);
        }
    }
}
