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
        String texte1="Puissance 3 & 4:"; 
        String texte2="Pour être le premier gagnant parmi les 3 participants d'une partie de puissance 3,";
        String texte3="il suffit d'être le premier à aligner 3 jetons de sa couleur horizontalement, verticalement ou diagonalement. ";
        String texte4="Le gagnant sortira de l'arène pour laisser place à la bataille entre les 2 perdants qui se fera en puissance 4 pour déclarer";
        String texte5="le second vainqueur ! Le principe est le même qu'un puissance 3 mais avec 4 jetons ! Si lors d'une partie, tous les";
        String texte6="jetons sont joués sans qu'il y est d'alignement de jetons, la partie est déclaré nulle. Pour jouer,";
        String texte7="cliquez sur une colonne chacun à votre tour. Que les meilleurs gagnent. ";
        String texte8="Bon jeu ! ";
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.fillOval(60,25,700,260);
    secondPinceau.setColor(Color.WHITE);
    secondPinceau.fillOval(65,30,690,250);
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.fillArc(15,195,280,90,230,90);
    secondPinceau.setColor(Color.WHITE);
    secondPinceau.fillArc(35,205,260,70,240,90);
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.drawString(texte1,350,60);
    secondPinceau.drawString(texte2,180,90);
    secondPinceau.drawString(texte3,120,120);
    secondPinceau.drawString(texte4,80,150);
    secondPinceau.drawString(texte5,100,180);
    secondPinceau.drawString(texte6,150,210);
    secondPinceau.drawString(texte7,200,240);
    secondPinceau.drawString(texte8,380,270);
  }
}