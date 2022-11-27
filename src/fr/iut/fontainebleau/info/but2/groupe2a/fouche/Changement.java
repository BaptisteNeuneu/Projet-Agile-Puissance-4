package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//La classe changement indique ce que la fonction doit faire lrs de la victoire de l'un des joueurs 
public class Changement{

    //Les fonctions retirer enleve respectivement le JLabel et le DessinJeton du joueur qui a gagné
    public static void retirer(JFrame f,JLabel r,JLabel j,JLabel v,int n){
        if(n==2){
            f.remove(r);
            f.revalidate();
            Changement.augmenter(j);
            Changement.augmenter(v);
        }
        if(n==3){
            f.remove(j);
            f.revalidate();
            Changement.augmenter(r);
            Changement.augmenter(v);
        }
        if(n==1){
            f.remove(v);
            f.revalidate();
            Changement.augmenter(r);
            Changement.augmenter(j);
        }
    }
    public static void retirer(JFrame f,DessinJeton r,DessinJeton j,DessinJeton v,int n){
        if(n==2){
            f.remove(r);
            f.revalidate();
        }
        if(n==3){
            f.remove(j);
            f.revalidate();
        }
        if(n==1){
            f.remove(v);
            f.revalidate();
        }
    }
    //La fonction augmenter rajoute 7 jetons chaque joueur pour compléter la grille dans sa totalité
    public static void augmenter(JLabel t){
            String texte = t.getText();
            int n = Integer.parseInt(texte);
            n = n + 7;
            texte = Integer.toString(n);
            t.setText(texte);
    }
    //La fonction décoloriser appelle la fonction remove color pour retirer une couleur de la grille
    public static void decoloriser(Grille g,int n)
    {
        if(n==2){
            g.removeColor('r');
        }
        if(n==3){
            g.removeColor('j');
        }
        if(n==1){
            g.removeColor('v');
        }
    }
    //La fonction afficher aiche  nouveau la fenêtre 
    public static void afficher(JFrame f){
        f.setVisible(false);
        f.setVisible(true);
    }
}