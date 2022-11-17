package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;

import java.awt.*;
import javax.swing.*;

public class Extension extends View{
    //JPanel p; 
    public Extension(int l,int h){
        super(l,h);
        //this.p=super.p;
    }

    public JPanel getPanel(){
        return super.p;
    }
}