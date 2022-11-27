package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

//La class Action est un MouseListener en plus de la vue pour appeler la fenetre aide
public class Action implements MouseListener{
    private Vue fenetre;
    public Action(Vue f){
        this.fenetre=f;
    }

    public void mouseExited(MouseEvent e){
        
    }
    
    public void mouseEntered(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){
        
    }
    //On appelle la fonction aidedans le MousePressed 
    public void mousePressed(MouseEvent e){
        System.out.println(e.getX());
        System.out.println(e.getY());
        if(e.getX()>=0 && e.getX()<=150 && e.getY()>=880 && e.getY()<=990){
            Modal m= new Modal(this.fenetre);
        }
    }

    public void mouseClicked(MouseEvent e){
        
    }
}