package src.fr.iut.fontainebleau.info.but2.groupe2a.boutet;

public class Grille {
    /* Taille légale de la grille (selon les règles) */
    protected int nombreLigne = 6; // rows
    protected int nombreColonne = 7; // collumns
    protected int width = 1050; //width
    protected int height = 660; //height

    /* Création de la grille avec les dimensions règlementaire */
    protected Jeton grille[][] ;

    /**
     * Objectif : Creer la grille de puissance 4, la grille d'un puissance 4 se
     * compose de 6 lignes et 7 colonnes.
     * Initialise la grille de "-", cette grille pourra indiquer via la valeur de sa
     * case ce qu'elle doit contenir :
     * +- '-' : Aucun jeton, case vide
     * +- 'r' : Jeton rouge dans cette case
     * +- 'j' : Jeton jaune dans cette case
     */
    public Grille(int width,int height) {
        this.width=width;
        this.height=height;
        this.grille = new Jeton[nombreColonne][nombreLigne];
        for (int i = 0; i < nombreColonne; i++) {
            for (int j = 0; j < nombreLigne; j++) {
                Jeton jeton = new Jeton(i,j,'-',this.width/this.nombreColonne,this.height/this.nombreLigne);
                this.grille[i][j]=jeton;
            }
        }
    }

    /**
     * Affiche la grille dans le terminal
     */
    public void PrintGrille() {
        System.out.println("La grile :");
        for (int i = 0; i < nombreColonne; i++) {
            for (int j = 0; j < nombreLigne; j++) {
                System.out.print(this.grille[i][j].getValue() + " ");
            }
            System.out.print("\n");
        }
    }

    /* ------- GETTEURS ------- */
    public int getNombreLigne() {
        return this.nombreLigne;
    }

    public int getNombreColonne() {
        return this.nombreColonne;
    }

    public Jeton[][] getGrille() {
        return this.grille;
    }

    public Jeton getJeton(int colonne, int ligne){
        return this.grille[colonne][ligne];
    }
    /**
     * Permet de trouver l'ordonnée (Y) de la premiere case vide dans la colonne du jeton passé en paramètre
     * @param jeton - Le jeton sur lequel on a cliqué
     * @return L'ordonnée de la premiere case vide
     */
    public int getLowestJeton(Jeton jeton){
        int colonneActuelle = jeton.getColonne();
        int i;
        for(i = 0; i<this.nombreLigne; i++ ){
            if(this.grille[colonneActuelle][i].getValue() == '-'){
                break; //On sort de la boucle une fois le premier jeton vide atteint
            }
        }
        return i;
    }
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
