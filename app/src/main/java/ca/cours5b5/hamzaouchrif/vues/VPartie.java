package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;

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
    }

    private void observerPartie(){

    }
    /*
     * Appeler observer pour obtenir le modèle
     *
     * Une fois le modèle obtenu, créer la grille d'affichage
     *
     */

    private MPartie getPartie(Modele modele){
        return null;
    }

    private void initialiserGrille(MPartie partie){

    }
}
