package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class VGrille extends GridLayout {


    public VGrille(Context context) {
        super(context);

    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr );
    }

    private int nombreRangees;

    // mémoriser les en-têtes ajoutées
    private List<VEntete> entetes;

    // mémoriser les VCase ajoutées (avec un tableau à deux dimensions)
    private VCase[][] lesCases;

    // OU: mémoriser les VCase ajoutées (avec des listes)
    private class Colonne extends ArrayList<VCase> {}
    private List<Colonne> colonnesDeCases;


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Atelier06", VGrille.class.getSimpleName() + "::onFinishInflate");
    }

    void creerGrille(int hauteur, int largeur) {

    }


    private void initialiserTableauDeCases(int hauteur, int largeur) {

    }


    private void initialiserColonnes(int largeur) {

    }

    private void ajouterEnTetes(int largeur) {

    }

    private LayoutParams getMiseEnPageEntete(int colonne) {

        return null;
    }

    private void ajouterCases(int hauteur, int largeur) {

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne) {
        return null;
    }
}

