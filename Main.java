import src.fr.iut.fontainebleau.info.but2.groupe2a.boutet.*;

public class Main {
    public static void main(String[] args) {
        new Model();
        View v = new View(800, 600);
        v.affichage();
    }
}