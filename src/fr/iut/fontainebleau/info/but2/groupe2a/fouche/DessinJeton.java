package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import javax.swing.*;
import java.awt.*;
import java.io.*;
 
public class DessinJeton extends JComponent{
    private Color couleur;
    public DessinJeton(Color c) {
        this.couleur=c;
    }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    secondPinceau.setColor(this.couleur);
    secondPinceau.fillOval(5,5,100,100);
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.drawRect(0,0,109,109);
  }
}