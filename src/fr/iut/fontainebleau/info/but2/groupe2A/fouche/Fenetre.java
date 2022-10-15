package fr.iut.fontainebleau.info.but2.groupe2A.fouche;

public class Main{
    public Fenetre(int x,int y){
        /*la fenetre*/
        JFrame fenetre = new JFrame;
        fenetre.setSize(x,y);
        fenetre.setLocation((1920-x)/2,(1080-y)/2);

        /*le gestionnaire*/
        Gestionnaire gestionnaire = new Gestionnaire();
        GridBagLayout layout=gestionnaire.getLayout();
        fenetre.add(layout);

        /*la grille*/
        Grille grilleDeJeu= new Grille();
        JPanel panneau=grilleDeJeu.getPanel();
        fenetre.add(panneau);
        
        /*le texte*/
        JLabel nomDuJoueur = new JPanel()

        /*le bouton*/
    }
}