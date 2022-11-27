//a supprimer
/*package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import javax.swing.*;
import java.awt.*;
import java.io.*;
 
public class DessinGrille extends JComponent{
    private int t_h;
    private int t_v;
    public DessinGrille(int taille_h,int taille_v) {
        this.t_h=taille_h;
        this.t_v=taille_v;
    }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    secondPinceau.setColor(Color.BLUE);
    secondPinceau.fillRect(0,0,t_h,t_v);
    secondPinceau.setColor(Color.WHITE);
    if(t_h<t_v){
      secondPinceau.fillOval(t_h/10,t_h/10+(t_v-t_h)/2,t_h-t_h/5,t_h-t_h/5);
    }else{
      secondPinceau.fillOval(t_v/10+(t_h-t_v)/2,t_v/10,t_v-t_v/5,t_v-t_v/5);
    }
  }
}*/