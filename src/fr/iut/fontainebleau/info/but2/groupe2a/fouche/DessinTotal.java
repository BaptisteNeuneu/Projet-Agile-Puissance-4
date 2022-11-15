package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import javax.swing.*;
import java.awt.*;
import java.io.*;
 
public class DessinTotal extends JComponent{
    private LecteurXPM bouton;
    private String[] portrait;
    private int nombre;
    public DessinTotal(int n) {
      this.bouton = new LecteurXPM(); 
	    this.portrait=this.bouton.lireImage(new File("./src/fr/iut/fontainebleau/info/but2/groupe2a/fouche/fleches.xpm"));
      this.nombre=n;
    }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    for(int i=0;i<this.nombre;i++){
      for(int k=0;k<80;k++){
	      for(int l=0;l<150;l++){
		      secondPinceau.setColor(Color.decode(this.portrait[k*150+l]));
		      secondPinceau.fillRect(i*150+l,0+k,1,1);
	      }
	    }
    }
  }
}