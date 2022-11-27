package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import javax.swing.*;
import java.awt.*;
import java.io.*;
//La classe odal va apelé la fenêtre d'aide
public class Modal extends JComponent{
    //private Color couleur;
    public Modal(Vue f) {
        JDialog popup= new JDialog(f.getFrame());
        popup.setSize(500,500);
        popup.setLocation(0,0);
        DessinBulle bubulle= new DessinBulle();
        bubulle.setSize(300,300);
        bubulle.setLocation(0,0);
        popup.add(bubulle);
        
        popup.setVisible(true);
    }
}