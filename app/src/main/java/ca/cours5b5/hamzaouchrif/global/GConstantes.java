package ca.cours5b5.hamzaouchrif.global;


import android.util.Log;

public class GConstantes {

    static{
        Log.d("Atelier04", GConstantes.class.getSimpleName() + "::static");
    }

    public static final int LARGEUR_MIN = 4;
    public static final int LARGEUR_MAX = 10;
    public static final int LARGEUR_PAR_DEFAUT = 7;

    public static final int HAUTEUR_MIN = 4;
    public static final int HAUTEUR_MAX = 10;
    public static final int HAUTEUR_PAR_DEFAUT = 6;

    public static final int POUR_GAGNER_MIN = 3;
    public static final int POUR_GAGNER_MAX = 5;
    public static final int POUR_GAGNER_PAR_DEFAUT = 4;

    public static final String SEPARATEUR_DE_CHEMIN="/";

    public static final int MARGE_GRILLE = 5;
    public static final int ENTETE_RANGEE =0;
    public static final float ENTETE_POIDS_COLONNE =1;
    public static final float ENTETE_POIDS_RANGEE =3;
    public static final float CASE_POIDS_COLONNE = 1;
    public static final float CASE_POIDS_RANGEE = 1;
}
