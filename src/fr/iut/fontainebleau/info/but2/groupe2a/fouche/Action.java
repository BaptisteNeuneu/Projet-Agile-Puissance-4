package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Action implements MouseListener{
    //private int position;
    private Vue fenetre;
    public Action(Vue f){
        //this.position=p;
        this.fenetre=f;
    }

    public void mouseExited(MouseEvent e){
        
    }
    
    public void mouseEntered(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){
        
    }

    public void mousePressed(MouseEvent e){
        System.out.println(e.getX());
        System.out.println(e.getY());
        if(e.getX()>=0 && e.getX()<=150 && e.getY()>=880 && e.getY()<=990){
            //JOptionPane.showMessageDialog(this.fenetre.getFrame(),"login:");
            Modal m= new Modal(this.fenetre);
        }
        /*for(int i=0;i<6;i++){
            if(e.getX()>=320+i*150 && e.getX()<=469+i*150 && e.getY()>=280 && e.getY()<=759){
                if(this.position==i){
                    this.position=0;
                    //this.fenetre.selectionner(0,this.position);
                }else{
                    this.position=i;
                    //this.fenetre.selectionner(i,this.position);
                }
            }
        }*/
    }

    public void mouseClicked(MouseEvent e){
        
    }
}