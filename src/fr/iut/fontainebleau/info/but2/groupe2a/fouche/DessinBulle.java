package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import javax.swing.*;
import java.awt.*;
import java.io.*;
 
public class DessinBulle extends JComponent{
    //private Color couleur;
    public DessinBulle() {
        //this.couleur=c;
    }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    //secondPinceau.setColor(this.couleur);
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.fillOval(5,5,200,100);
    secondPinceau.setColor(Color.WHITE);
    secondPinceau.fillOval(10,10,190,90);
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.fillArc(15,75,50,25,225,90);
    secondPinceau.setColor(Color.WHITE);
    secondPinceau.fillArc(25,70,50,25,225,90);
  }
}