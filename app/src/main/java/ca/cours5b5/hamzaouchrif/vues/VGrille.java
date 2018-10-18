package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.hamzaouchrif.controleurs.Action;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurAction;
import ca.cours5b5.hamzaouchrif.global.GCommande;
import ca.cours5b5.hamzaouchrif.global.GConstantes;
import ca.cours5b5.hamzaouchrif.global.GCouleur;
import ca.cours5b5.hamzaouchrif.modeles.MColonne;
import ca.cours5b5.hamzaouchrif.modeles.MGrille;

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
    private class Colonne extends ArrayList<VCase> {

    }
    private List<Colonne> colonnesDeCases;

    // mémoriser les en-têtes ajoutées
    private List<VEntete> entetes;

    // mémoriser les VCase ajoutées (avec un tableau à deux dimensions)
    private VCase[][] lesCases;




    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Atelier06", VGrille.class.getSimpleName() + "::onFinishInflate");
    }



   public void creerGrille(int hauteur, int largeur) {
        this.initialiserColonnes(largeur);
        this.ajouterEnTetes(largeur);


        this.initialiserTableauDeCases(hauteur, largeur);
        this.ajouterCases(hauteur, largeur);


    }



    private void initialiserTableauDeCases(int hauteur, int largeur) {
        lesCases = new VCase[hauteur][largeur];
    }

    private void initialiserColonnes(int largeur) {
        this.colonnesDeCases = new ArrayList<>();
    }

    private Action demanderActionEntete() {


        return ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);
    }

    private void installerListenerEntete(VEntete entete, final int colonne) {
        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Action action = demanderActionEntete();
                action.setArguments(colonne);
                action.executerDesQuePossible();
            }
        });

    }




    private void ajouterEnTetes(int largeur) {

        this.entetes = new ArrayList<>();

        for (int colonne = 0; colonne < largeur; colonne++) {
            VEntete entete = new VEntete(this.getContext(), colonne);
            installerListenerEntete(entete, colonne);
            this.entetes.add(entete);
            this.addView(entete, this.getMiseEnPageEntete(colonne));
        }
    }





    private void afficherJeton(int colonne, int rangee, GCouleur jeton) {
        colonnesDeCases.get(colonne).get(rangee).afficherJeton(jeton);
    }

    private LayoutParams getMiseEnPageEntete(int colonne) {
        Spec specRangee = GridLayout.spec(GConstantes.ENTETE_RANGEE, (float) GConstantes.ENTETE_POIDS_RANGEE);
        Spec specColonne = GridLayout.spec(colonne, (float) GConstantes.ENTETE_POIDS_COLONNE);
        LayoutParams params = new LayoutParams(specRangee, specColonne);
        params.width = 0;
        params.height = 0;
        params.setGravity(Gravity.FILL);

        params.rightMargin = GConstantes.MARGE_GRILLE;
        params.leftMargin = GConstantes.MARGE_GRILLE;
        return params;
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne) {
        Spec specRangee = GridLayout.spec(rangee + 1, (float) GConstantes.CASE_POIDS_RANGEE);
        Spec specColonne = GridLayout.spec(colonne, (float) GConstantes.CASE_POIDS_COLONNE);

        LayoutParams params = new LayoutParams(specRangee, specColonne);
        params.width = 0;
        params.height = 0;
        params.setGravity(Gravity.FILL);
        params.rightMargin = GConstantes.MARGE_GRILLE;
        params.leftMargin = GConstantes.MARGE_GRILLE;


        return params;
    }


    private void ajouterCases(int hauteur, int largeur) {

        for (int i = 0; i < largeur; i++) {

            this.colonnesDeCases.add(new Colonne());
        }
        for (int i = 0; i < hauteur; i++) {

            for (int j = 0; j < largeur; j++) {

               VCase nCase = new VCase(this.getContext(), i, j);
                this.colonnesDeCases.get(j).add(nCase);
                this.addView(nCase, this.getMiseEnPageCase((hauteur - i) - 1, j));
            }
        }
    }
    public void afficherJetons(MGrille grille) {
        List<MColonne> colonnes = grille.getColonnes();

        for (int i = 0; i < colonnes.size(); i++) {
            for (int j = 0; j < colonnes.get(i).getJetons().size(); j++) {
                afficherJeton(i, j, colonnes.get(i).getJetons().get(j));
            }
        }

    }

}

