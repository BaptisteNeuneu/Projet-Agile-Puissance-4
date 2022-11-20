package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;

/*Voici la fonction Vue elle ouvre une fenètre avec une fausse grille dedans*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Changement{
    public static void retirer(JFrame f,JLabel r,JLabel j,JLabel v,int n){
        if(n==1){
            f.remove(r);
            f.revalidate();
            f.setVisible(false);
            f.setVisible(true);
        }
        if(n==2){
            f.remove(j);
            f.revalidate();
            f.setVisible(false);
            f.setVisible(true);
        }
        if(n==3){
            f.remove(v);
            f.revalidate();
            f.setVisible(false);
            f.setVisible(true);
        }
    }
    public static void retirer(JFrame f,DessinJeton r,DessinJeton j,DessinJeton v,int n){
        if(n==1){
            f.remove(r);
            f.revalidate();
            f.setVisible(false);
            f.setVisible(true);
        }
        if(n==2){
            f.remove(j);
            f.revalidate();
            f.setVisible(false);
            f.setVisible(true);
        }
        if(n==3){
            f.remove(v);
            f.revalidate();
            f.setVisible(false);
            f.setVisible(true);
        }
    }
}