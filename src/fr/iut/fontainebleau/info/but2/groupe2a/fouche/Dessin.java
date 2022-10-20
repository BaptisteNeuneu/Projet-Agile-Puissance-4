import javax.swing.*;
import java.awt.*;
 
public class Dessin extends JComponent{
    String texte;
   public Dessin(String t){
    this.texte=t;
   } 
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    secondPinceau.setColor(Color.YELLOW);
    secondPinceau.drawString(this.texte,10,10);
    //secondPinceau.drawRect(0,0,100,100);
  }
}