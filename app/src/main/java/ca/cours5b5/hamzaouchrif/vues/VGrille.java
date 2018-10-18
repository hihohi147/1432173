package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.GridLayout;

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




    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Atelier06", VGrille.class.getSimpleName() + "::onFinishInflate");
    }

    void creerGrille(int hauteur, int largeur) {
        initialiserTableauDeCases(hauteur, largeur);
        ajouterEnTetes(largeur);

        ajouterCases(hauteur, largeur);


    }


    private void initialiserTableauDeCases(int hauteur, int largeur) {
        lesCases = new VCase[hauteur][largeur];
    }


    private void ajouterEnTetes(int largeur) {

        for (int i =0; i<largeur; i++) {

            VEntete entete = new VEntete(this.getContext(),i);

            addView(entete, getMiseEnPageEntete(i));

            entetes.add(entete);


        }

    }

    private LayoutParams getMiseEnPageEntete(int colonne) {
        int rangee = 0;
        float poidsRangee = 2f;
        float poidsColonne = 2f;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }

    private void ajouterCases(int hauteur, int largeur) {

for (int i =0; i<largeur; i++){

    for (int j =0; i<hauteur; j++){

        VCase nCase = new VCase(this.getContext(),i,j);
        addView(nCase,getMiseEnPageCase(i,j));
        lesCases[i][j] = nCase;
    }
}
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne) {

        float poidsRangee = 1f;
        float poidsColonne = 1f;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }
}

