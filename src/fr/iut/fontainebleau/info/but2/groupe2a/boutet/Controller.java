package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

public class Controller extends Model {

    /* ---------- GETTEURS ---------- */
    public char[][] RecupGrille() {
        return getGrille();
    }

    public int RecupGridHeigth() {
        return grilleHeigth;
    }

    public int RecupGridLength() {
        return grilleLength;
    }
}