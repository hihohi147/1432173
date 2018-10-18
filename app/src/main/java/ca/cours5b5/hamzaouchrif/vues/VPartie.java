package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.hamzaouchrif.R;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurObservation;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.hamzaouchrif.exceptions.ErreurObservation;
import ca.cours5b5.hamzaouchrif.modeles.MParametres;
import ca.cours5b5.hamzaouchrif.modeles.MPartie;
import ca.cours5b5.hamzaouchrif.modeles.Modele;

public class VPartie extends Vue {

    private VGrille grille;


    public VPartie(Context context){
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
       super.onFinishInflate();
        this.grille = findViewById(R.id.grillePartie);
        this.observerPartie();

            Log.d("Atelier06", VGrille.class.getSimpleName() + "::onFinishInflate");

    }
    /*
     * Appeler observer pour obtenir le modèle
     *
     * Une fois le modèle obtenu, créer la grille d'affichage
     *
     */
    private void observerPartie(){
        ControleurObservation.observerModele(MParametres.class.getSimpleName(),
                new ListenerObservateur() {

                    @Override
                    public void reagirNouveauModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        initialiserGrille(partie);

                    }

                    @Override
                    public void reagirChangementAuModele(Modele modele) {
                        miseAjourGrille(getPartie(modele));
                    }
                });
    }


    private MPartie getPartie(Modele modele){
        try{
            return (MPartie) modele;
        } catch (ErreurObservation e) {
           throw new ErreurObservation("..");
        }
    }

    private void initialiserGrille(MPartie partie){
grille.creerGrille(partie.getParametres().getHauteur(), partie.getParametres().getLargeur());
    }

    private void miseAjourGrille(MPartie partie) {

        this.grille.afficherJetons(partie.getGrille());

    }



}
