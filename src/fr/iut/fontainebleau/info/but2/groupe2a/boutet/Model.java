package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

public class Model {
    /* Taille légale de la grille (selon les règles) */
    protected int grilleLength = 7; // rows
    protected int grilleHeigth = 6; // collumns

    /* Création de la grille avec les dimensions règlementaire */
    protected char grille[][] = new char[grilleLength][grilleHeigth];

    /**
     * Objectif : Creer la grille de puissance 4, la grille d'un puissance 4 se
     * compose de 6 lignes et 7 colonnes.
     * Initialise la grille de "-", cette grille pourra indiquer via la valeur de sa
     * case ce qu'elle doit contenir :
     * +- '-' : Aucun jeton, case vide
     * +- 'r' : Jeton rouge dans cette case
     * +- 'j' : Jeton jaune dans cette case
     */
    public Model() {
        for (int i = 0; i < grilleLength; i++) {
            for (int j = 0; j < grilleHeigth; j++) {
                this.grille[i][j] = '-';
            }
        }
    }

    /**
     * Affiche la grille dans le terminal
     */
    public void PrintGrille() {
        System.out.println("La grile :");
        for (int i = 0; i < grilleLength; i++) {
            for (int j = 0; j < grilleHeigth; j++) {
                System.out.print(this.grille[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /* ------- GETTEURS ------- */
    public int getGrilleLength() {
        return this.grilleLength;
    }

    public int getGrilleHeigth() {
        return this.grilleHeigth;
    }

    public char[][] getGrille() {
        return this.grille;
    }
}
