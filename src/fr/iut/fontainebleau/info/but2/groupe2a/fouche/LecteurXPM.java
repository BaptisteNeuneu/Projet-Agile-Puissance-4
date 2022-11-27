package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
//La classe LecteurXPM consiste à lire le fichier fleches.xpm
public class  LecteurXPM {
    private int nb_x;
    private int nb_y;
    public LecteurXPM() {
	nb_x=0;
	nb_y=0;
    }
    public String[] lireImage(File input) {
	String[] l=new String[1];
	try{    
	    FileReader isr= new FileReader(input);
	    BufferedReader br = new BufferedReader(isr);
	    try{
		String temp="";
		String ligne="";
		int x=0,y=0,nb_color=0,pixel=0;
		String[] color=new String[1],symbol= new String[1];
		for(int i=0;temp!=null;i++){
		    temp=br.readLine();
			if(i==3){
			int[] quatuor =new int[4];
			int t=0,indent=0;
			for(int j=1;j<temp.length();j++){
			    if(temp.charAt(j)==' ' || temp.charAt(j)=='"'){
				quatuor[t]=indent;
				t=t+1;
				indent=0;
			    }else{
				indent=indent+1;
			    }
			}
			y=Integer.parseInt(temp.substring(1,1+quatuor[0]));
			x=Integer.parseInt(temp.substring(2+quatuor[0],2+quatuor[0]+quatuor[1]));
			this.nb_x=x;
			this.nb_y=y;
			nb_color=Integer.parseInt(temp.substring(3+quatuor[0]+quatuor[1],3+quatuor[0]+quatuor[1]+quatuor[2]));
			pixel=Integer.parseInt(temp.substring(4+quatuor[0]+quatuor[1]+quatuor[2],4+quatuor[0]+quatuor[1]+quatuor[2]+quatuor[3]));
			color= new String[nb_color];
			symbol= new String[nb_color];
			l=new String[y*x];
		    }
		    if(i>3 && i<4+nb_color){
			symbol[i-4]=temp.substring(1,2);
			color[i-4]=temp.substring(5,12);
		    }
		    if(i>4+nb_color && i<5+nb_color+x){
			ligne=temp.substring(1,y+1);
			for(int j=0;j<y;j++){
			    for(int k=0;k<nb_color;k++){
				char[] unique = {ligne.charAt(j)};
				String t=new String(unique);
				if(t.equals(symbol[k])){
				    l[(i-5-nb_color)*y+j]=color[k];
				}
			    }
			    
			}
		    }
		}
		}
	    catch(IOException e){
		System.out.println("Erreur de lecture");
	    }try{
		br.close();
	    }catch(IOException e){
		System.out.println("Erreur de fermeture");
		}
	}
	catch(FileNotFoundException e2){
	    System.out.println("Erreur d'ouverture");
	    }
	return l;
    }
    public int getX(){
	return this.nb_x;
    }
    public int getY(){
	return this.nb_y;
    }

}
